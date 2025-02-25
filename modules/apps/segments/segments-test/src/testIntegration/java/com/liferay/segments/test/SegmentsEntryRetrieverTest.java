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

package com.liferay.segments.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.configuration.test.util.CompanyConfigurationTemporarySwapper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HashMapDictionaryBuilder;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.segments.SegmentsEntryRetriever;
import com.liferay.segments.configuration.SegmentsCompanyConfiguration;
import com.liferay.segments.constants.SegmentsEntryConstants;
import com.liferay.segments.criteria.Criteria;
import com.liferay.segments.criteria.CriteriaSerializer;
import com.liferay.segments.criteria.contributor.SegmentsCriteriaContributor;
import com.liferay.segments.model.SegmentsEntry;
import com.liferay.segments.test.util.SegmentsTestUtil;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class SegmentsEntryRetrieverTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_user = UserTestUtil.addUser(_group.getGroupId());
	}

	@Test
	public void testGetSegmentsEntryIds() throws Exception {
		try (CompanyConfigurationTemporarySwapper
				companyConfigurationTemporarySwapper =
					new CompanyConfigurationTemporarySwapper(
						TestPropsValues.getCompanyId(),
						SegmentsCompanyConfiguration.class.getName(),
						HashMapDictionaryBuilder.<String, Object>put(
							"segmentationEnabled", true
						).build(),
						SettingsFactoryUtil.getSettingsFactory())) {

			SegmentsEntry segmentsEntry = _addSegmentsEntry(_user);

			long[] segmentsEntryIds =
				_segmentsEntryRetriever.getSegmentsEntryIds(
					_group.getGroupId(), _user.getUserId(), null);

			Assert.assertEquals(
				Arrays.toString(segmentsEntryIds), 2, segmentsEntryIds.length);
			Assert.assertTrue(
				ArrayUtil.contains(
					segmentsEntryIds, SegmentsEntryConstants.ID_DEFAULT));
			Assert.assertTrue(
				ArrayUtil.contains(
					segmentsEntryIds, segmentsEntry.getSegmentsEntryId()));
		}
	}

	@Test
	public void testGetSegmentsEntryIdsWithoutSegmentsEntry() throws Exception {
		long[] segmentsEntryIds = _segmentsEntryRetriever.getSegmentsEntryIds(
			_group.getGroupId(), _user.getUserId(), null);

		Assert.assertEquals(
			Arrays.toString(segmentsEntryIds), 1, segmentsEntryIds.length);
		Assert.assertEquals(
			SegmentsEntryConstants.ID_DEFAULT, segmentsEntryIds[0]);
	}

	private SegmentsEntry _addSegmentsEntry(User user) throws Exception {
		Criteria criteria = new Criteria();

		_userSegmentsCriteriaContributor.contribute(
			criteria, String.format("(firstName eq '%s')", user.getFirstName()),
			Criteria.Conjunction.AND);

		return SegmentsTestUtil.addSegmentsEntry(
			_group.getGroupId(), CriteriaSerializer.serialize(criteria),
			User.class.getName());
	}

	@DeleteAfterTestRun
	private Group _group;

	@Inject
	private SegmentsEntryRetriever _segmentsEntryRetriever;

	@DeleteAfterTestRun
	private User _user;

	@Inject(
		filter = "segments.criteria.contributor.key=user",
		type = SegmentsCriteriaContributor.class
	)
	private SegmentsCriteriaContributor _userSegmentsCriteriaContributor;

}