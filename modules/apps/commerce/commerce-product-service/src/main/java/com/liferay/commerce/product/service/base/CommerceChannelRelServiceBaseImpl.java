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

import com.liferay.commerce.product.model.CommerceChannelRel;
import com.liferay.commerce.product.service.CommerceChannelRelService;
import com.liferay.commerce.product.service.CommerceChannelRelServiceUtil;
import com.liferay.commerce.product.service.persistence.CommerceChannelRelFinder;
import com.liferay.commerce.product.service.persistence.CommerceChannelRelPersistence;
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
 * Provides the base implementation for the commerce channel rel remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.product.service.impl.CommerceChannelRelServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.product.service.impl.CommerceChannelRelServiceImpl
 * @generated
 */
public abstract class CommerceChannelRelServiceBaseImpl
	extends BaseServiceImpl
	implements CommerceChannelRelService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceChannelRelService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceChannelRelServiceUtil</code>.
	 */

	/**
	 * Returns the commerce channel rel local service.
	 *
	 * @return the commerce channel rel local service
	 */
	public com.liferay.commerce.product.service.CommerceChannelRelLocalService
		getCommerceChannelRelLocalService() {

		return commerceChannelRelLocalService;
	}

	/**
	 * Sets the commerce channel rel local service.
	 *
	 * @param commerceChannelRelLocalService the commerce channel rel local service
	 */
	public void setCommerceChannelRelLocalService(
		com.liferay.commerce.product.service.CommerceChannelRelLocalService
			commerceChannelRelLocalService) {

		this.commerceChannelRelLocalService = commerceChannelRelLocalService;
	}

	/**
	 * Returns the commerce channel rel remote service.
	 *
	 * @return the commerce channel rel remote service
	 */
	public CommerceChannelRelService getCommerceChannelRelService() {
		return commerceChannelRelService;
	}

	/**
	 * Sets the commerce channel rel remote service.
	 *
	 * @param commerceChannelRelService the commerce channel rel remote service
	 */
	public void setCommerceChannelRelService(
		CommerceChannelRelService commerceChannelRelService) {

		this.commerceChannelRelService = commerceChannelRelService;
	}

	/**
	 * Returns the commerce channel rel persistence.
	 *
	 * @return the commerce channel rel persistence
	 */
	public CommerceChannelRelPersistence getCommerceChannelRelPersistence() {
		return commerceChannelRelPersistence;
	}

	/**
	 * Sets the commerce channel rel persistence.
	 *
	 * @param commerceChannelRelPersistence the commerce channel rel persistence
	 */
	public void setCommerceChannelRelPersistence(
		CommerceChannelRelPersistence commerceChannelRelPersistence) {

		this.commerceChannelRelPersistence = commerceChannelRelPersistence;
	}

	/**
	 * Returns the commerce channel rel finder.
	 *
	 * @return the commerce channel rel finder
	 */
	public CommerceChannelRelFinder getCommerceChannelRelFinder() {
		return commerceChannelRelFinder;
	}

	/**
	 * Sets the commerce channel rel finder.
	 *
	 * @param commerceChannelRelFinder the commerce channel rel finder
	 */
	public void setCommerceChannelRelFinder(
		CommerceChannelRelFinder commerceChannelRelFinder) {

		this.commerceChannelRelFinder = commerceChannelRelFinder;
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
		_setServiceUtilService(commerceChannelRelService);
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
		return CommerceChannelRelService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceChannelRel.class;
	}

	protected String getModelClassName() {
		return CommerceChannelRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceChannelRelPersistence.getDataSource();

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
		CommerceChannelRelService commerceChannelRelService) {

		try {
			Field field = CommerceChannelRelServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, commerceChannelRelService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.product.service.CommerceChannelRelLocalService.class
	)
	protected
		com.liferay.commerce.product.service.CommerceChannelRelLocalService
			commerceChannelRelLocalService;

	@BeanReference(type = CommerceChannelRelService.class)
	protected CommerceChannelRelService commerceChannelRelService;

	@BeanReference(type = CommerceChannelRelPersistence.class)
	protected CommerceChannelRelPersistence commerceChannelRelPersistence;

	@BeanReference(type = CommerceChannelRelFinder.class)
	protected CommerceChannelRelFinder commerceChannelRelFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}