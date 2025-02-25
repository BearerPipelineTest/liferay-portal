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

package com.liferay.ratings.kernel.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.ratings.kernel.model.RatingsStats;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ratings stats service. This utility wraps <code>com.liferay.portlet.ratings.service.persistence.impl.RatingsStatsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RatingsStatsPersistence
 * @generated
 */
public class RatingsStatsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RatingsStats ratingsStats) {
		getPersistence().clearCache(ratingsStats);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, RatingsStats> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RatingsStats> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RatingsStats update(RatingsStats ratingsStats) {
		return getPersistence().update(ratingsStats);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RatingsStats update(
		RatingsStats ratingsStats, ServiceContext serviceContext) {

		return getPersistence().update(ratingsStats, serviceContext);
	}

	/**
	 * Returns all the ratings statses where classNameId = &#63; and classPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPKs the class pks
	 * @return the matching ratings statses
	 */
	public static List<RatingsStats> findByC_C(
		long classNameId, long[] classPKs) {

		return getPersistence().findByC_C(classNameId, classPKs);
	}

	/**
	 * Returns a range of all the ratings statses where classNameId = &#63; and classPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPKs the class pks
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @return the range of matching ratings statses
	 */
	public static List<RatingsStats> findByC_C(
		long classNameId, long[] classPKs, int start, int end) {

		return getPersistence().findByC_C(classNameId, classPKs, start, end);
	}

	/**
	 * Returns an ordered range of all the ratings statses where classNameId = &#63; and classPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPKs the class pks
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ratings statses
	 */
	public static List<RatingsStats> findByC_C(
		long classNameId, long[] classPKs, int start, int end,
		OrderByComparator<RatingsStats> orderByComparator) {

		return getPersistence().findByC_C(
			classNameId, classPKs, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ratings statses where classNameId = &#63; and classPK = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPKs the class pks
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ratings statses
	 */
	public static List<RatingsStats> findByC_C(
		long classNameId, long[] classPKs, int start, int end,
		OrderByComparator<RatingsStats> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_C(
			classNameId, classPKs, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the ratings stats where classNameId = &#63; and classPK = &#63; or throws a <code>NoSuchStatsException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching ratings stats
	 * @throws NoSuchStatsException if a matching ratings stats could not be found
	 */
	public static RatingsStats findByC_C(long classNameId, long classPK)
		throws com.liferay.ratings.kernel.exception.NoSuchStatsException {

		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	 * Returns the ratings stats where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching ratings stats, or <code>null</code> if a matching ratings stats could not be found
	 */
	public static RatingsStats fetchByC_C(long classNameId, long classPK) {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	 * Returns the ratings stats where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ratings stats, or <code>null</code> if a matching ratings stats could not be found
	 */
	public static RatingsStats fetchByC_C(
		long classNameId, long classPK, boolean useFinderCache) {

		return getPersistence().fetchByC_C(
			classNameId, classPK, useFinderCache);
	}

	/**
	 * Removes the ratings stats where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the ratings stats that was removed
	 */
	public static RatingsStats removeByC_C(long classNameId, long classPK)
		throws com.liferay.ratings.kernel.exception.NoSuchStatsException {

		return getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	 * Returns the number of ratings statses where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching ratings statses
	 */
	public static int countByC_C(long classNameId, long classPK) {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	 * Returns the number of ratings statses where classNameId = &#63; and classPK = any &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPKs the class pks
	 * @return the number of matching ratings statses
	 */
	public static int countByC_C(long classNameId, long[] classPKs) {
		return getPersistence().countByC_C(classNameId, classPKs);
	}

	/**
	 * Caches the ratings stats in the entity cache if it is enabled.
	 *
	 * @param ratingsStats the ratings stats
	 */
	public static void cacheResult(RatingsStats ratingsStats) {
		getPersistence().cacheResult(ratingsStats);
	}

	/**
	 * Caches the ratings statses in the entity cache if it is enabled.
	 *
	 * @param ratingsStatses the ratings statses
	 */
	public static void cacheResult(List<RatingsStats> ratingsStatses) {
		getPersistence().cacheResult(ratingsStatses);
	}

	/**
	 * Creates a new ratings stats with the primary key. Does not add the ratings stats to the database.
	 *
	 * @param statsId the primary key for the new ratings stats
	 * @return the new ratings stats
	 */
	public static RatingsStats create(long statsId) {
		return getPersistence().create(statsId);
	}

	/**
	 * Removes the ratings stats with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statsId the primary key of the ratings stats
	 * @return the ratings stats that was removed
	 * @throws NoSuchStatsException if a ratings stats with the primary key could not be found
	 */
	public static RatingsStats remove(long statsId)
		throws com.liferay.ratings.kernel.exception.NoSuchStatsException {

		return getPersistence().remove(statsId);
	}

	public static RatingsStats updateImpl(RatingsStats ratingsStats) {
		return getPersistence().updateImpl(ratingsStats);
	}

	/**
	 * Returns the ratings stats with the primary key or throws a <code>NoSuchStatsException</code> if it could not be found.
	 *
	 * @param statsId the primary key of the ratings stats
	 * @return the ratings stats
	 * @throws NoSuchStatsException if a ratings stats with the primary key could not be found
	 */
	public static RatingsStats findByPrimaryKey(long statsId)
		throws com.liferay.ratings.kernel.exception.NoSuchStatsException {

		return getPersistence().findByPrimaryKey(statsId);
	}

	/**
	 * Returns the ratings stats with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statsId the primary key of the ratings stats
	 * @return the ratings stats, or <code>null</code> if a ratings stats with the primary key could not be found
	 */
	public static RatingsStats fetchByPrimaryKey(long statsId) {
		return getPersistence().fetchByPrimaryKey(statsId);
	}

	/**
	 * Returns all the ratings statses.
	 *
	 * @return the ratings statses
	 */
	public static List<RatingsStats> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ratings statses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @return the range of ratings statses
	 */
	public static List<RatingsStats> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ratings statses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ratings statses
	 */
	public static List<RatingsStats> findAll(
		int start, int end, OrderByComparator<RatingsStats> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ratings statses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RatingsStatsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ratings statses
	 * @param end the upper bound of the range of ratings statses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ratings statses
	 */
	public static List<RatingsStats> findAll(
		int start, int end, OrderByComparator<RatingsStats> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ratings statses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ratings statses.
	 *
	 * @return the number of ratings statses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RatingsStatsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RatingsStatsPersistence _persistence;

}