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

package com.liferay.commerce.tax.engine.fixed.service.base;

import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate;
import com.liferay.commerce.tax.engine.fixed.service.CommerceTaxFixedRateLocalService;
import com.liferay.commerce.tax.engine.fixed.service.CommerceTaxFixedRateLocalServiceUtil;
import com.liferay.commerce.tax.engine.fixed.service.persistence.CommerceTaxFixedRateAddressRelFinder;
import com.liferay.commerce.tax.engine.fixed.service.persistence.CommerceTaxFixedRateAddressRelPersistence;
import com.liferay.commerce.tax.engine.fixed.service.persistence.CommerceTaxFixedRatePersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the commerce tax fixed rate local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.tax.engine.fixed.service.impl.CommerceTaxFixedRateLocalServiceImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see com.liferay.commerce.tax.engine.fixed.service.impl.CommerceTaxFixedRateLocalServiceImpl
 * @generated
 */
public abstract class CommerceTaxFixedRateLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CommerceTaxFixedRateLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceTaxFixedRateLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceTaxFixedRateLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce tax fixed rate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTaxFixedRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTaxFixedRate the commerce tax fixed rate
	 * @return the commerce tax fixed rate that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceTaxFixedRate addCommerceTaxFixedRate(
		CommerceTaxFixedRate commerceTaxFixedRate) {

		commerceTaxFixedRate.setNew(true);

		return commerceTaxFixedRatePersistence.update(commerceTaxFixedRate);
	}

	/**
	 * Creates a new commerce tax fixed rate with the primary key. Does not add the commerce tax fixed rate to the database.
	 *
	 * @param commerceTaxFixedRateId the primary key for the new commerce tax fixed rate
	 * @return the new commerce tax fixed rate
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceTaxFixedRate createCommerceTaxFixedRate(
		long commerceTaxFixedRateId) {

		return commerceTaxFixedRatePersistence.create(commerceTaxFixedRateId);
	}

	/**
	 * Deletes the commerce tax fixed rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTaxFixedRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTaxFixedRateId the primary key of the commerce tax fixed rate
	 * @return the commerce tax fixed rate that was removed
	 * @throws PortalException if a commerce tax fixed rate with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceTaxFixedRate deleteCommerceTaxFixedRate(
			long commerceTaxFixedRateId)
		throws PortalException {

		return commerceTaxFixedRatePersistence.remove(commerceTaxFixedRateId);
	}

	/**
	 * Deletes the commerce tax fixed rate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTaxFixedRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTaxFixedRate the commerce tax fixed rate
	 * @return the commerce tax fixed rate that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceTaxFixedRate deleteCommerceTaxFixedRate(
		CommerceTaxFixedRate commerceTaxFixedRate) {

		return commerceTaxFixedRatePersistence.remove(commerceTaxFixedRate);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return commerceTaxFixedRatePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommerceTaxFixedRate.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceTaxFixedRatePersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.tax.engine.fixed.model.impl.CommerceTaxFixedRateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commerceTaxFixedRatePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.tax.engine.fixed.model.impl.CommerceTaxFixedRateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commerceTaxFixedRatePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceTaxFixedRatePersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commerceTaxFixedRatePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommerceTaxFixedRate fetchCommerceTaxFixedRate(
		long commerceTaxFixedRateId) {

		return commerceTaxFixedRatePersistence.fetchByPrimaryKey(
			commerceTaxFixedRateId);
	}

	/**
	 * Returns the commerce tax fixed rate with the primary key.
	 *
	 * @param commerceTaxFixedRateId the primary key of the commerce tax fixed rate
	 * @return the commerce tax fixed rate
	 * @throws PortalException if a commerce tax fixed rate with the primary key could not be found
	 */
	@Override
	public CommerceTaxFixedRate getCommerceTaxFixedRate(
			long commerceTaxFixedRateId)
		throws PortalException {

		return commerceTaxFixedRatePersistence.findByPrimaryKey(
			commerceTaxFixedRateId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commerceTaxFixedRateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceTaxFixedRate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceTaxFixedRateId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceTaxFixedRateLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommerceTaxFixedRate.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceTaxFixedRateId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commerceTaxFixedRateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceTaxFixedRate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceTaxFixedRateId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceTaxFixedRatePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceTaxFixedRateLocalService.deleteCommerceTaxFixedRate(
			(CommerceTaxFixedRate)persistedModel);
	}

	@Override
	public BasePersistence<CommerceTaxFixedRate> getBasePersistence() {
		return commerceTaxFixedRatePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceTaxFixedRatePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce tax fixed rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.tax.engine.fixed.model.impl.CommerceTaxFixedRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce tax fixed rates
	 * @param end the upper bound of the range of commerce tax fixed rates (not inclusive)
	 * @return the range of commerce tax fixed rates
	 */
	@Override
	public List<CommerceTaxFixedRate> getCommerceTaxFixedRates(
		int start, int end) {

		return commerceTaxFixedRatePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce tax fixed rates.
	 *
	 * @return the number of commerce tax fixed rates
	 */
	@Override
	public int getCommerceTaxFixedRatesCount() {
		return commerceTaxFixedRatePersistence.countAll();
	}

	/**
	 * Updates the commerce tax fixed rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTaxFixedRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTaxFixedRate the commerce tax fixed rate
	 * @return the commerce tax fixed rate that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceTaxFixedRate updateCommerceTaxFixedRate(
		CommerceTaxFixedRate commerceTaxFixedRate) {

		return commerceTaxFixedRatePersistence.update(commerceTaxFixedRate);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CommerceTaxFixedRateLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		commerceTaxFixedRateLocalService =
			(CommerceTaxFixedRateLocalService)aopProxy;

		_setLocalServiceUtilService(commerceTaxFixedRateLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceTaxFixedRateLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceTaxFixedRate.class;
	}

	protected String getModelClassName() {
		return CommerceTaxFixedRate.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceTaxFixedRatePersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		CommerceTaxFixedRateLocalService commerceTaxFixedRateLocalService) {

		try {
			Field field =
				CommerceTaxFixedRateLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, commerceTaxFixedRateLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CommerceTaxFixedRateLocalService commerceTaxFixedRateLocalService;

	@Reference
	protected CommerceTaxFixedRatePersistence commerceTaxFixedRatePersistence;

	@Reference
	protected CommerceTaxFixedRateAddressRelPersistence
		commerceTaxFixedRateAddressRelPersistence;

	@Reference
	protected CommerceTaxFixedRateAddressRelFinder
		commerceTaxFixedRateAddressRelFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}