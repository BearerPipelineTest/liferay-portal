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

package com.liferay.commerce.product.service.base;

import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelService;
import com.liferay.commerce.product.service.CommerceChannelServiceUtil;
import com.liferay.commerce.product.service.persistence.CommerceChannelPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.lang.reflect.Field;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce channel remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.product.service.impl.CommerceChannelServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.product.service.impl.CommerceChannelServiceImpl
 * @generated
 */
public abstract class CommerceChannelServiceBaseImpl
	extends BaseServiceImpl
	implements CommerceChannelService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceChannelService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceChannelServiceUtil</code>.
	 */

	/**
	 * Returns the commerce channel local service.
	 *
	 * @return the commerce channel local service
	 */
	public com.liferay.commerce.product.service.CommerceChannelLocalService
		getCommerceChannelLocalService() {

		return commerceChannelLocalService;
	}

	/**
	 * Sets the commerce channel local service.
	 *
	 * @param commerceChannelLocalService the commerce channel local service
	 */
	public void setCommerceChannelLocalService(
		com.liferay.commerce.product.service.CommerceChannelLocalService
			commerceChannelLocalService) {

		this.commerceChannelLocalService = commerceChannelLocalService;
	}

	/**
	 * Returns the commerce channel remote service.
	 *
	 * @return the commerce channel remote service
	 */
	public CommerceChannelService getCommerceChannelService() {
		return commerceChannelService;
	}

	/**
	 * Sets the commerce channel remote service.
	 *
	 * @param commerceChannelService the commerce channel remote service
	 */
	public void setCommerceChannelService(
		CommerceChannelService commerceChannelService) {

		this.commerceChannelService = commerceChannelService;
	}

	/**
	 * Returns the commerce channel persistence.
	 *
	 * @return the commerce channel persistence
	 */
	public CommerceChannelPersistence getCommerceChannelPersistence() {
		return commerceChannelPersistence;
	}

	/**
	 * Sets the commerce channel persistence.
	 *
	 * @param commerceChannelPersistence the commerce channel persistence
	 */
	public void setCommerceChannelPersistence(
		CommerceChannelPersistence commerceChannelPersistence) {

		this.commerceChannelPersistence = commerceChannelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
		_setServiceUtilService(commerceChannelService);
	}

	public void destroy() {
		_setServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceChannelService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceChannel.class;
	}

	protected String getModelClassName() {
		return CommerceChannel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceChannelPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		CommerceChannelService commerceChannelService) {

		try {
			Field field = CommerceChannelServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, commerceChannelService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.product.service.CommerceChannelLocalService.class
	)
	protected com.liferay.commerce.product.service.CommerceChannelLocalService
		commerceChannelLocalService;

	@BeanReference(type = CommerceChannelService.class)
	protected CommerceChannelService commerceChannelService;

	@BeanReference(type = CommerceChannelPersistence.class)
	protected CommerceChannelPersistence commerceChannelPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}