/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.analytics.reports.web.internal.display.context;

import com.liferay.analytics.reports.info.item.ClassNameClassPKInfoItemIdentifier;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.InfoItemReference;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.Collections;
import java.util.Map;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

/**
 * @author David Arques
 * @author Sarai Díaz
 */
public class AnalyticsReportsDisplayContext<T> {

	public AnalyticsReportsDisplayContext(
		InfoItemReference infoItemReference, Portal portal,
		RenderRequest renderRequest, RenderResponse renderResponse) {

		_infoItemReference = infoItemReference;
		_portal = portal;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
	}

	public Map<String, Object> getData() throws PortalException {
		if (_data != null) {
			return _data;
		}

		_data = Collections.singletonMap(
			"context",
			Collections.singletonMap(
				"analyticsReportsDataURL",
				String.valueOf(
					_getResourceURL("/analytics_reports/get_data"))));

		return _data;
	}

	private ResourceURL _getResourceURL(String resourceID)
		throws PortalException {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(_renderRequest);

		ResourceURL resourceURL =
			(ResourceURL)PortletURLBuilder.createLiferayPortletURL(
				_portal.getLiferayPortletResponse(_renderResponse),
				liferayPortletRequest.getPlid(),
				liferayPortletRequest.getPortletName(),
				PortletRequest.RESOURCE_PHASE, MimeResponse.Copy.PUBLIC
			).setRedirect(
				ParamUtil.getString(_renderRequest, "redirect")
			).setParameter(
				"className", _infoItemReference.getClassName()
			).buildPortletURL();

		if (_infoItemReference.getInfoItemIdentifier() instanceof
				ClassNameClassPKInfoItemIdentifier) {

			ClassNameClassPKInfoItemIdentifier
				classNameClassPKInfoItemIdentifier =
					(ClassNameClassPKInfoItemIdentifier)
						_infoItemReference.getInfoItemIdentifier();

			resourceURL.setParameter(
				"classPK",
				String.valueOf(
					classNameClassPKInfoItemIdentifier.getClassPK()));
			resourceURL.setParameter(
				"classTypeName",
				classNameClassPKInfoItemIdentifier.getClassName());
		}
		else if (_infoItemReference.getInfoItemIdentifier() instanceof
					ClassPKInfoItemIdentifier) {

			ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
				(ClassPKInfoItemIdentifier)
					_infoItemReference.getInfoItemIdentifier();

			resourceURL.setParameter(
				"classPK",
				String.valueOf(classPKInfoItemIdentifier.getClassPK()));
		}

		resourceURL.setResourceID(resourceID);

		return resourceURL;
	}

	private Map<String, Object> _data;
	private final InfoItemReference _infoItemReference;
	private final Portal _portal;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;

}