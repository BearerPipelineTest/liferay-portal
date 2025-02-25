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

package com.liferay.commerce.account.service.base;

import com.liferay.commerce.account.model.CommerceAccountGroupRel;
import com.liferay.commerce.account.service.CommerceAccountGroupRelLocalService;
import com.liferay.commerce.account.service.CommerceAccountGroupRelLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;

import java.lang.reflect.Field;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the commerce account group rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.account.service.impl.CommerceAccountGroupRelLocalServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.account.service.impl.CommerceAccountGroupRelLocalServiceImpl
 * @generated
 */
public abstract class CommerceAccountGroupRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CommerceAccountGroupRelLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceAccountGroupRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceAccountGroupRelLocalServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CommerceAccountGroupRelLocalService.class,
			IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		commerceAccountGroupRelLocalService =
			(CommerceAccountGroupRelLocalService)aopProxy;

		_setLocalServiceUtilService(commerceAccountGroupRelLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceAccountGroupRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceAccountGroupRel.class;
	}

	protected String getModelClassName() {
		return CommerceAccountGroupRel.class.getName();
	}

	private void _setLocalServiceUtilService(
		CommerceAccountGroupRelLocalService
			commerceAccountGroupRelLocalService) {

		try {
			Field field =
				CommerceAccountGroupRelLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, commerceAccountGroupRelLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CommerceAccountGroupRelLocalService
		commerceAccountGroupRelLocalService;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}