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

import com.liferay.commerce.product.model.CPTaxCategory;
import com.liferay.commerce.product.service.CPTaxCategoryService;
import com.liferay.commerce.product.service.CPTaxCategoryServiceUtil;
import com.liferay.commerce.product.service.persistence.CPTaxCategoryFinder;
import com.liferay.commerce.product.service.persistence.CPTaxCategoryPersistence;
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
 * Provides the base implementation for the cp tax category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.product.service.impl.CPTaxCategoryServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.product.service.impl.CPTaxCategoryServiceImpl
 * @generated
 */
public abstract class CPTaxCategoryServiceBaseImpl
	extends BaseServiceImpl
	implements CPTaxCategoryService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CPTaxCategoryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CPTaxCategoryServiceUtil</code>.
	 */

	/**
	 * Returns the cp tax category local service.
	 *
	 * @return the cp tax category local service
	 */
	public com.liferay.commerce.product.service.CPTaxCategoryLocalService
		getCPTaxCategoryLocalService() {

		return cpTaxCategoryLocalService;
	}

	/**
	 * Sets the cp tax category local service.
	 *
	 * @param cpTaxCategoryLocalService the cp tax category local service
	 */
	public void setCPTaxCategoryLocalService(
		com.liferay.commerce.product.service.CPTaxCategoryLocalService
			cpTaxCategoryLocalService) {

		this.cpTaxCategoryLocalService = cpTaxCategoryLocalService;
	}

	/**
	 * Returns the cp tax category remote service.
	 *
	 * @return the cp tax category remote service
	 */
	public CPTaxCategoryService getCPTaxCategoryService() {
		return cpTaxCategoryService;
	}

	/**
	 * Sets the cp tax category remote service.
	 *
	 * @param cpTaxCategoryService the cp tax category remote service
	 */
	public void setCPTaxCategoryService(
		CPTaxCategoryService cpTaxCategoryService) {

		this.cpTaxCategoryService = cpTaxCategoryService;
	}

	/**
	 * Returns the cp tax category persistence.
	 *
	 * @return the cp tax category persistence
	 */
	public CPTaxCategoryPersistence getCPTaxCategoryPersistence() {
		return cpTaxCategoryPersistence;
	}

	/**
	 * Sets the cp tax category persistence.
	 *
	 * @param cpTaxCategoryPersistence the cp tax category persistence
	 */
	public void setCPTaxCategoryPersistence(
		CPTaxCategoryPersistence cpTaxCategoryPersistence) {

		this.cpTaxCategoryPersistence = cpTaxCategoryPersistence;
	}

	/**
	 * Returns the cp tax category finder.
	 *
	 * @return the cp tax category finder
	 */
	public CPTaxCategoryFinder getCPTaxCategoryFinder() {
		return cpTaxCategoryFinder;
	}

	/**
	 * Sets the cp tax category finder.
	 *
	 * @param cpTaxCategoryFinder the cp tax category finder
	 */
	public void setCPTaxCategoryFinder(
		CPTaxCategoryFinder cpTaxCategoryFinder) {

		this.cpTaxCategoryFinder = cpTaxCategoryFinder;
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
		_setServiceUtilService(cpTaxCategoryService);
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
		return CPTaxCategoryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CPTaxCategory.class;
	}

	protected String getModelClassName() {
		return CPTaxCategory.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cpTaxCategoryPersistence.getDataSource();

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
		CPTaxCategoryService cpTaxCategoryService) {

		try {
			Field field = CPTaxCategoryServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, cpTaxCategoryService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.product.service.CPTaxCategoryLocalService.class
	)
	protected com.liferay.commerce.product.service.CPTaxCategoryLocalService
		cpTaxCategoryLocalService;

	@BeanReference(type = CPTaxCategoryService.class)
	protected CPTaxCategoryService cpTaxCategoryService;

	@BeanReference(type = CPTaxCategoryPersistence.class)
	protected CPTaxCategoryPersistence cpTaxCategoryPersistence;

	@BeanReference(type = CPTaxCategoryFinder.class)
	protected CPTaxCategoryFinder cpTaxCategoryFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}