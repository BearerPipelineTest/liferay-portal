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

package com.liferay.commerce.product.service.impl;

import com.liferay.commerce.product.exception.CPTaxCategoryNameException;
import com.liferay.commerce.product.exception.DuplicateCPTaxCategoryException;
import com.liferay.commerce.product.model.CPTaxCategory;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.base.CPTaxCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Alessio Antonio Rendina
 */
public class CPTaxCategoryLocalServiceImpl
	extends CPTaxCategoryLocalServiceBaseImpl {

	@Override
	public CPTaxCategory addCPTaxCategory(
			String externalReferenceCode, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		User user = _userLocalService.getUser(serviceContext.getUserId());

		validate(user.getCompanyId(), 0, externalReferenceCode, nameMap);

		long cpTaxCategoryId = counterLocalService.increment();

		CPTaxCategory cpTaxCategory = cpTaxCategoryPersistence.create(
			cpTaxCategoryId);

		cpTaxCategory.setExternalReferenceCode(externalReferenceCode);
		cpTaxCategory.setCompanyId(user.getCompanyId());
		cpTaxCategory.setUserId(user.getUserId());
		cpTaxCategory.setUserName(user.getFullName());
		cpTaxCategory.setNameMap(nameMap);
		cpTaxCategory.setDescriptionMap(descriptionMap);

		return cpTaxCategoryPersistence.update(cpTaxCategory);
	}

	@Override
	public int countCPTaxCategoriesByCompanyId(long companyId, String keyword) {
		return cpTaxCategoryFinder.countCPTaxCategoriesByCompanyId(
			companyId, keyword);
	}

	@Override
	public void deleteCPTaxCategories(long companyId) {
		cpTaxCategoryPersistence.removeByCompanyId(companyId);
	}

	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CPTaxCategory deleteCPTaxCategory(CPTaxCategory cpTaxCategory)
		throws PortalException {

		// Commerce product tax category

		cpTaxCategory = cpTaxCategoryPersistence.remove(cpTaxCategory);

		// Commerce product definitions

		_cpDefinitionLocalService.updateCPDefinitionsByCPTaxCategoryId(
			cpTaxCategory.getCPTaxCategoryId());

		return cpTaxCategory;
	}

	@Override
	public CPTaxCategory deleteCPTaxCategory(long cpTaxCategoryId)
		throws PortalException {

		CPTaxCategory cpTaxCategory = cpTaxCategoryPersistence.findByPrimaryKey(
			cpTaxCategoryId);

		return cpTaxCategoryLocalService.deleteCPTaxCategory(cpTaxCategory);
	}

	@Override
	public List<CPTaxCategory> findCPTaxCategoriesByCompanyId(
		long companyId, String keyword, int start, int end) {

		return cpTaxCategoryFinder.findCPTaxCategoriesByCompanyId(
			companyId, keyword, start, end);
	}

	@Override
	public List<CPTaxCategory> getCPTaxCategories(long companyId) {
		return cpTaxCategoryPersistence.findByCompanyId(companyId);
	}

	@Override
	public List<CPTaxCategory> getCPTaxCategories(
		long companyId, int start, int end,
		OrderByComparator<CPTaxCategory> orderByComparator) {

		return cpTaxCategoryPersistence.findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	@Override
	public int getCPTaxCategoriesCount(long companyId) {
		return cpTaxCategoryPersistence.countByCompanyId(companyId);
	}

	@Override
	public CPTaxCategory updateCPTaxCategory(
			String externalReferenceCode, long cpTaxCategoryId,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap)
		throws PortalException {

		CPTaxCategory cpTaxCategory = cpTaxCategoryPersistence.findByPrimaryKey(
			cpTaxCategoryId);

		validate(
			cpTaxCategory.getCompanyId(), cpTaxCategoryId,
			externalReferenceCode, nameMap);

		cpTaxCategory.setExternalReferenceCode(externalReferenceCode);
		cpTaxCategory.setNameMap(nameMap);
		cpTaxCategory.setDescriptionMap(descriptionMap);

		return cpTaxCategoryPersistence.update(cpTaxCategory);
	}

	protected void validate(
			long companyId, long cpTaxCategoryId, String externalReferenceCode,
			Map<Locale, String> nameMap)
		throws PortalException {

		if (Validator.isNotNull(externalReferenceCode)) {
			CPTaxCategory cpTaxCategory = cpTaxCategoryPersistence.fetchByC_ERC(
				companyId, externalReferenceCode);

			if ((cpTaxCategory != null) &&
				(cpTaxCategory.getCPTaxCategoryId() != cpTaxCategoryId)) {

				throw new DuplicateCPTaxCategoryException(
					"There is another commerce tax category with external " +
						"reference code " + externalReferenceCode);
			}
		}

		validate(nameMap);
	}

	protected void validate(Map<Locale, String> nameMap)
		throws PortalException {

		Locale locale = LocaleUtil.getSiteDefault();

		String name = nameMap.get(locale);

		if (Validator.isNull(name)) {
			throw new CPTaxCategoryNameException();
		}
	}

	@BeanReference(type = CPDefinitionLocalService.class)
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@ServiceReference(type = UserLocalService.class)
	private UserLocalService _userLocalService;

}