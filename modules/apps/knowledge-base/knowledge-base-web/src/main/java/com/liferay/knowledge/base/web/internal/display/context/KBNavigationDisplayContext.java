/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledge.base.web.internal.display.context;

import com.liferay.knowledge.base.constants.KBFolderConstants;
import com.liferay.knowledge.base.model.KBArticle;
import com.liferay.knowledge.base.model.KBFolder;
import com.liferay.knowledge.base.service.KBArticleLocalServiceUtil;
import com.liferay.knowledge.base.service.KBArticleServiceUtil;
import com.liferay.knowledge.base.service.KBFolderServiceUtil;
import com.liferay.knowledge.base.util.KnowledgeBaseUtil;
import com.liferay.knowledge.base.util.comparator.KBArticlePriorityComparator;
import com.liferay.knowledge.base.web.internal.KBUtil;
import com.liferay.knowledge.base.web.internal.configuration.KBDisplayPortletInstanceConfiguration;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

/**
 * @author Adolfo Pérez
 */
public class KBNavigationDisplayContext {

	public KBNavigationDisplayContext(
		PortletRequest portletRequest, PortalPreferences portalPreferences,
		KBDisplayPortletInstanceConfiguration
			kbDisplayPortletInstanceConfiguration,
		KBArticle kbArticle) {

		_portletRequest = portletRequest;
		_portalPreferences = portalPreferences;
		_kbDisplayPortletInstanceConfiguration =
			kbDisplayPortletInstanceConfiguration;
		_kbArticle = kbArticle;
	}

	public List<Long> getAncestorResourcePrimaryKeys() throws PortalException {
		if (_kbArticle == null) {
			return Collections.singletonList(
				KBFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		}

		KBArticle latestKBArticle =
			KBArticleLocalServiceUtil.getLatestKBArticle(
				_kbArticle.getResourcePrimKey(),
				WorkflowConstants.STATUS_APPROVED);

		List<Long> ancestorResourcePrimaryKeys =
			latestKBArticle.getAncestorResourcePrimaryKeys();

		Collections.reverse(ancestorResourcePrimaryKeys);

		return ancestorResourcePrimaryKeys;
	}

	public List<KBArticle> getChildKBArticles(
			long groupId, long parentResourcePrimKey, int level)
		throws PortalException {

		if ((parentResourcePrimKey == getResourcePrimKey()) && (level == 0) &&
			!isFolderResource()) {

			return Collections.singletonList(
				KBArticleServiceUtil.getLatestKBArticle(
					getResourcePrimKey(), WorkflowConstants.STATUS_APPROVED));
		}

		if (isMaxNestingLevelReached(level)) {
			return KBArticleServiceUtil.getAllDescendantKBArticles(
				groupId, parentResourcePrimKey,
				WorkflowConstants.STATUS_APPROVED,
				new KBArticlePriorityComparator(true));
		}

		return KBArticleServiceUtil.getKBArticles(
			groupId, parentResourcePrimKey, WorkflowConstants.STATUS_APPROVED,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			new KBArticlePriorityComparator(true));
	}

	public String getCurrentKBFolderURLTitle() throws PortalException {
		long rootResourcePrimKey = getRootResourcePrimKey();

		if (rootResourcePrimKey == KBFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return StringPool.BLANK;
		}

		KBFolder kbFolder = KBFolderServiceUtil.getKBFolder(
			rootResourcePrimKey);

		return kbFolder.getUrlTitle();
	}

	public String getPageTitle() throws PortalException {
		long rootResourcePrimKey = getRootResourcePrimKey();

		if (isFolderResource() &&
			(rootResourcePrimKey !=
				KBFolderConstants.DEFAULT_PARENT_FOLDER_ID)) {

			KBFolder kbFolder = KBFolderServiceUtil.getKBFolder(
				rootResourcePrimKey);

			String pageTitle =
				_kbDisplayPortletInstanceConfiguration.contentRootPrefix() +
					" " + kbFolder.getName();

			if (_kbArticle == null) {
				return pageTitle;
			}

			return _kbArticle.getTitle() + " - " + pageTitle;
		}

		if (_kbArticle != null) {
			return _kbArticle.getTitle();
		}

		return null;
	}

	public long getParentResourcePrimKey() throws PortalException {
		if (_kbArticle != null) {
			return _kbArticle.getParentResourcePrimKey();
		}

		return getRootResourcePrimKey();
	}

	public long getRootResourcePrimKey() throws PortalException {
		if (_rootResourcePrimKey != null) {
			return _rootResourcePrimKey;
		}

		if (!isFolderResource()) {
			_rootResourcePrimKey = getResourcePrimKey();
		}
		else if (_kbArticle != null) {
			_rootResourcePrimKey = KnowledgeBaseUtil.getKBFolderId(
				_kbArticle.getParentResourceClassNameId(),
				_kbArticle.getParentResourcePrimKey());
		}
		else {
			_rootResourcePrimKey = KBUtil.getRootResourcePrimKey(
				_portletRequest, PortalUtil.getScopeGroupId(_portletRequest),
				_getResourceClassNameId(), getResourcePrimKey());
		}

		return _rootResourcePrimKey;
	}

	public boolean isChildKBArticleExpanded(KBArticle childKBArticle, int level)
		throws PortalException {

		List<Long> ancestorResourcePrimaryKeys =
			getAncestorResourcePrimaryKeys();

		if ((ancestorResourcePrimaryKeys.size() > 1) &&
			(level < ancestorResourcePrimaryKeys.size()) &&
			(childKBArticle.getResourcePrimKey() ==
				ancestorResourcePrimaryKeys.get(level))) {

			return true;
		}

		return false;
	}

	public boolean isFolderResource() {
		long kbFolderClassNameId = PortalUtil.getClassNameId(
			KBFolderConstants.getClassName());

		if (kbFolderClassNameId == _getResourceClassNameId()) {
			return true;
		}

		return false;
	}

	public boolean isFurtherExpansionRequired(
			long parentResourcePrimKey, KBArticle childKBArticle, int level)
		throws PortalException {

		List<Long> ancestorResourcePrimaryKeys =
			getAncestorResourcePrimaryKeys();

		if (!isMaxNestingLevelReached(level) &&
			ancestorResourcePrimaryKeys.contains(
				childKBArticle.getResourcePrimKey())) {

			return true;
		}

		return false;
	}

	public boolean isLeftNavigationVisible() throws PortalException {
		if (_leftNavigationVisible == null) {
			_leftNavigationVisible = _hasMultipleDescendantKBArticles();
		}

		return _leftNavigationVisible;
	}

	public boolean isMaxNestingLevelReached(int level) {
		int maxNestingLevel =
			_kbDisplayPortletInstanceConfiguration.maxNestingLevel();

		if ((maxNestingLevel - level) <= 1) {
			return true;
		}

		return false;
	}

	public boolean isTopNavigationVisible() throws PortalException {
		if (isFolderResource() && !isLeftNavigationVisible()) {
			return true;
		}

		return false;
	}

	protected long getResourcePrimKey() {
		if (_resourcePrimKey == null) {
			_resourcePrimKey = GetterUtil.getLong(
				_kbDisplayPortletInstanceConfiguration.resourcePrimKey());
		}

		return _resourcePrimKey;
	}

	private long _getResourceClassNameId() {
		if (_resourceClassNameId != null) {
			return _resourceClassNameId;
		}

		if (_kbDisplayPortletInstanceConfiguration.resourceClassNameId() != 0) {
			_resourceClassNameId =
				_kbDisplayPortletInstanceConfiguration.resourceClassNameId();
		}
		else {
			_resourceClassNameId = PortalUtil.getClassNameId(
				KBFolderConstants.getClassName());
		}

		return _resourceClassNameId;
	}

	private boolean _hasMultipleDescendantKBArticles() throws PortalException {
		long scopeGroupId = PortalUtil.getScopeGroupId(_portletRequest);

		if (isFolderResource()) {
			List<KBFolder> kbFolders = KBUtil.getAlternateRootKBFolders(
				scopeGroupId, getResourcePrimKey());

			if (kbFolders.size() > 1) {
				int maxKBArticlesCount = 0;

				for (KBFolder kbFolder : kbFolders) {
					int kbArticlesCount =
						KBArticleLocalServiceUtil.getKBFolderKBArticlesCount(
							scopeGroupId, kbFolder.getKbFolderId(),
							WorkflowConstants.STATUS_APPROVED);

					if (kbArticlesCount > maxKBArticlesCount) {
						maxKBArticlesCount = kbArticlesCount;
					}
				}

				if (maxKBArticlesCount > 1) {
					return true;
				}

				return false;
			}
		}

		long rootResourcePrimKey = getRootResourcePrimKey();

		int kbArticlesCount = KBArticleLocalServiceUtil.getKBArticlesCount(
			scopeGroupId, rootResourcePrimKey,
			WorkflowConstants.STATUS_APPROVED);

		if (!isFolderResource()) {
			kbArticlesCount++;
		}

		if (kbArticlesCount == 0) {
			return false;
		}

		if (kbArticlesCount != 1) {
			return true;
		}

		List<KBArticle> kbArticles = KBArticleLocalServiceUtil.getKBArticles(
			scopeGroupId, rootResourcePrimKey,
			WorkflowConstants.STATUS_APPROVED, 0, 1, null);

		if (kbArticles.isEmpty()) {
			return false;
		}

		KBArticle navigationKBArticle = kbArticles.get(0);

		int navigationKBArticleChildCount =
			KBArticleLocalServiceUtil.getKBArticlesCount(
				scopeGroupId, navigationKBArticle.getResourcePrimKey(),
				WorkflowConstants.STATUS_APPROVED);

		if (navigationKBArticleChildCount == 0) {
			return false;
		}

		return true;
	}

	private final KBArticle _kbArticle;
	private final KBDisplayPortletInstanceConfiguration
		_kbDisplayPortletInstanceConfiguration;
	private Boolean _leftNavigationVisible;
	private final PortalPreferences _portalPreferences;
	private final PortletRequest _portletRequest;
	private Long _resourceClassNameId;
	private Long _resourcePrimKey;
	private Long _rootResourcePrimKey;

}