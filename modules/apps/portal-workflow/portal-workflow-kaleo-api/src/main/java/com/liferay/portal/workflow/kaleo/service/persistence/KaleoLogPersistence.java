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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.change.tracking.CTPersistence;
import com.liferay.portal.workflow.kaleo.exception.NoSuchLogException;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the kaleo log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoLogUtil
 * @generated
 */
@ProviderType
public interface KaleoLogPersistence
	extends BasePersistence<KaleoLog>, CTPersistence<KaleoLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KaleoLogUtil} to access the kaleo log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the kaleo logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the kaleo logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where companyId = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByCompanyId_PrevAndNext(
			long kaleoLogId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of kaleo logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching kaleo logs
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the kaleo logs where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoDefinitionVersionId(
		long kaleoDefinitionVersionId);

	/**
	 * Returns a range of all the kaleo logs where kaleoDefinitionVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoDefinitionVersionId(
		long kaleoDefinitionVersionId, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoDefinitionVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoDefinitionVersionId(
		long kaleoDefinitionVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoDefinitionVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoDefinitionVersionId(
		long kaleoDefinitionVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoDefinitionVersionId_First(
			long kaleoDefinitionVersionId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoDefinitionVersionId_First(
		long kaleoDefinitionVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoDefinitionVersionId_Last(
			long kaleoDefinitionVersionId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoDefinitionVersionId_Last(
		long kaleoDefinitionVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByKaleoDefinitionVersionId_PrevAndNext(
			long kaleoLogId, long kaleoDefinitionVersionId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where kaleoDefinitionVersionId = &#63; from the database.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 */
	public void removeByKaleoDefinitionVersionId(long kaleoDefinitionVersionId);

	/**
	 * Returns the number of kaleo logs where kaleoDefinitionVersionId = &#63;.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID
	 * @return the number of matching kaleo logs
	 */
	public int countByKaleoDefinitionVersionId(long kaleoDefinitionVersionId);

	/**
	 * Returns all the kaleo logs where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoInstanceId(long kaleoInstanceId);

	/**
	 * Returns a range of all the kaleo logs where kaleoInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoInstanceId(
		long kaleoInstanceId, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoInstanceId(
		long kaleoInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoInstanceId(
		long kaleoInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoInstanceId_First(
			long kaleoInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoInstanceId_First(
		long kaleoInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoInstanceId_Last(
			long kaleoInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoInstanceId_Last(
		long kaleoInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param kaleoInstanceId the kaleo instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByKaleoInstanceId_PrevAndNext(
			long kaleoLogId, long kaleoInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where kaleoInstanceId = &#63; from the database.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 */
	public void removeByKaleoInstanceId(long kaleoInstanceId);

	/**
	 * Returns the number of kaleo logs where kaleoInstanceId = &#63;.
	 *
	 * @param kaleoInstanceId the kaleo instance ID
	 * @return the number of matching kaleo logs
	 */
	public int countByKaleoInstanceId(long kaleoInstanceId);

	/**
	 * Returns all the kaleo logs where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId);

	/**
	 * Returns a range of all the kaleo logs where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoTaskInstanceTokenId_First(
			long kaleoTaskInstanceTokenId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoTaskInstanceTokenId_First(
		long kaleoTaskInstanceTokenId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKaleoTaskInstanceTokenId_Last(
			long kaleoTaskInstanceTokenId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKaleoTaskInstanceTokenId_Last(
		long kaleoTaskInstanceTokenId,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByKaleoTaskInstanceTokenId_PrevAndNext(
			long kaleoLogId, long kaleoTaskInstanceTokenId,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where kaleoTaskInstanceTokenId = &#63; from the database.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 */
	public void removeByKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId);

	/**
	 * Returns the number of kaleo logs where kaleoTaskInstanceTokenId = &#63;.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID
	 * @return the number of matching kaleo logs
	 */
	public int countByKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId);

	/**
	 * Returns all the kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, String type);

	/**
	 * Returns a range of all the kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKITI_T_First(
			long kaleoInstanceTokenId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKITI_T_First(
		long kaleoInstanceTokenId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKITI_T_Last(
			long kaleoInstanceTokenId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKITI_T_Last(
		long kaleoInstanceTokenId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByKITI_T_PrevAndNext(
			long kaleoLogId, long kaleoInstanceTokenId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63; from the database.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 */
	public void removeByKITI_T(long kaleoInstanceTokenId, String type);

	/**
	 * Returns the number of kaleo logs where kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @return the number of matching kaleo logs
	 */
	public int countByKITI_T(long kaleoInstanceTokenId, String type);

	/**
	 * Returns all the kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @return the matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type);

	/**
	 * Returns a range of all the kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kaleo logs
	 */
	public java.util.List<KaleoLog> findByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kaleo log in the ordered set where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKCN_KCPK_KITI_T_First(
			String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the first kaleo log in the ordered set where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKCN_KCPK_KITI_T_First(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the last kaleo log in the ordered set where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log
	 * @throws NoSuchLogException if a matching kaleo log could not be found
	 */
	public KaleoLog findByKCN_KCPK_KITI_T_Last(
			String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Returns the last kaleo log in the ordered set where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo log, or <code>null</code> if a matching kaleo log could not be found
	 */
	public KaleoLog fetchByKCN_KCPK_KITI_T_Last(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns the kaleo logs before and after the current kaleo log in the ordered set where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoLogId the primary key of the current kaleo log
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog[] findByKCN_KCPK_KITI_T_PrevAndNext(
			long kaleoLogId, String kaleoClassName, long kaleoClassPK,
			long kaleoInstanceTokenId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
				orderByComparator)
		throws NoSuchLogException;

	/**
	 * Removes all the kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63; from the database.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 */
	public void removeByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type);

	/**
	 * Returns the number of kaleo logs where kaleoClassName = &#63; and kaleoClassPK = &#63; and kaleoInstanceTokenId = &#63; and type = &#63;.
	 *
	 * @param kaleoClassName the kaleo class name
	 * @param kaleoClassPK the kaleo class pk
	 * @param kaleoInstanceTokenId the kaleo instance token ID
	 * @param type the type
	 * @return the number of matching kaleo logs
	 */
	public int countByKCN_KCPK_KITI_T(
		String kaleoClassName, long kaleoClassPK, long kaleoInstanceTokenId,
		String type);

	/**
	 * Caches the kaleo log in the entity cache if it is enabled.
	 *
	 * @param kaleoLog the kaleo log
	 */
	public void cacheResult(KaleoLog kaleoLog);

	/**
	 * Caches the kaleo logs in the entity cache if it is enabled.
	 *
	 * @param kaleoLogs the kaleo logs
	 */
	public void cacheResult(java.util.List<KaleoLog> kaleoLogs);

	/**
	 * Creates a new kaleo log with the primary key. Does not add the kaleo log to the database.
	 *
	 * @param kaleoLogId the primary key for the new kaleo log
	 * @return the new kaleo log
	 */
	public KaleoLog create(long kaleoLogId);

	/**
	 * Removes the kaleo log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoLogId the primary key of the kaleo log
	 * @return the kaleo log that was removed
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog remove(long kaleoLogId) throws NoSuchLogException;

	public KaleoLog updateImpl(KaleoLog kaleoLog);

	/**
	 * Returns the kaleo log with the primary key or throws a <code>NoSuchLogException</code> if it could not be found.
	 *
	 * @param kaleoLogId the primary key of the kaleo log
	 * @return the kaleo log
	 * @throws NoSuchLogException if a kaleo log with the primary key could not be found
	 */
	public KaleoLog findByPrimaryKey(long kaleoLogId) throws NoSuchLogException;

	/**
	 * Returns the kaleo log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kaleoLogId the primary key of the kaleo log
	 * @return the kaleo log, or <code>null</code> if a kaleo log with the primary key could not be found
	 */
	public KaleoLog fetchByPrimaryKey(long kaleoLogId);

	/**
	 * Returns all the kaleo logs.
	 *
	 * @return the kaleo logs
	 */
	public java.util.List<KaleoLog> findAll();

	/**
	 * Returns a range of all the kaleo logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @return the range of kaleo logs
	 */
	public java.util.List<KaleoLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the kaleo logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kaleo logs
	 */
	public java.util.List<KaleoLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the kaleo logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KaleoLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo logs
	 * @param end the upper bound of the range of kaleo logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kaleo logs
	 */
	public java.util.List<KaleoLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KaleoLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the kaleo logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of kaleo logs.
	 *
	 * @return the number of kaleo logs
	 */
	public int countAll();

}