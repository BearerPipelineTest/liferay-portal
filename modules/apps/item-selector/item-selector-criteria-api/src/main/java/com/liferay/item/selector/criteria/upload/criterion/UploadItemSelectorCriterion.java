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

package com.liferay.item.selector.criteria.upload.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.portal.kernel.upload.UploadServletRequestConfigurationHelperUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Ambrín Chaudhary
 */
public class UploadItemSelectorCriterion extends BaseItemSelectorCriterion {

	public UploadItemSelectorCriterion() {
	}

	public UploadItemSelectorCriterion(
		String portletId, String url, String repositoryName, long maxFileSize,
		String[] extensions) {

		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
		_extensions = extensions;
	}

	public UploadItemSelectorCriterion(
		String mimeTypeRestriction, String portletId, String url,
		String repositoryName) {

		this(
			mimeTypeRestriction, portletId, url, repositoryName,
			UploadServletRequestConfigurationHelperUtil.getMaxSize());
	}

	public UploadItemSelectorCriterion(
		String mimeTypeRestriction, String portletId, String url,
		String repositoryName, long maxFileSize) {

		_mimeTypeRestriction = mimeTypeRestriction;
		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
	}

	public String[] getExtensions() {
		return _extensions;
	}

	public long getMaxFileSize() {
		return _maxFileSize;
	}

	@Override
	public String getMimeTypeRestriction() {
		if (Validator.isNull(_mimeTypeRestriction)) {
			super.getMimeTypeRestriction();
		}

		return _mimeTypeRestriction;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getRepositoryName() {
		return _repositoryName;
	}

	public String getURL() {
		return _url;
	}

	public void setExtensions(String[] extensions) {
		_extensions = extensions;
	}

	public void setMaxFileSize(long maxFileSize) {
		_maxFileSize = maxFileSize;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setRepositoryName(String repositoryName) {
		_repositoryName = repositoryName;
	}

	public void setURL(String url) {
		_url = url;
	}

	private String[] _extensions;
	private long _maxFileSize;
	private String _mimeTypeRestriction;
	private String _portletId;
	private String _repositoryName;
	private String _url;

}