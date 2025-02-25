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

package com.liferay.portal.kernel.dao.orm;

import com.liferay.petra.executor.PortalExecutorManager;
import com.liferay.portal.kernel.module.util.SystemBundleUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriterHelper;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author André de Oliveira
 */
public class IndexableActionableDynamicQueryTest {

	@Before
	public void setUp() {
		BundleContext bundleContext = SystemBundleUtil.getBundleContext();

		_serviceRegistration = bundleContext.registerService(
			PortalExecutorManager.class,
			Mockito.mock(PortalExecutorManager.class), null);

		indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setIndexWriterHelper(indexWriterHelper);
	}

	@After
	public void tearDown() {
		_serviceRegistration.unregister();
	}

	@Test
	public void testAddDocuments() throws Exception {
		indexableActionableDynamicQuery.setInterval(1);

		indexableActionableDynamicQuery.addDocuments(document1, document2);

		verifyDocumentsUpdated(document1, document2);
	}

	@Test
	public void testAddDocumentsWithinInterval() throws Exception {
		indexableActionableDynamicQuery.setInterval(3);

		indexableActionableDynamicQuery.addDocuments(document1, document2);

		verifyNoDocumentsUpdated();

		indexableActionableDynamicQuery.addDocuments(document3);

		verifyDocumentsUpdated(document1, document2, document3);
	}

	protected void verifyDocumentsUpdated(Document... documents)
		throws Exception {

		Mockito.verify(
			indexWriterHelper
		).updateDocuments(
			null, 0, Arrays.asList(documents), false
		);
	}

	protected void verifyNoDocumentsUpdated() {
		Mockito.verifyNoInteractions(indexWriterHelper);
	}

	protected Document document1 = Mockito.mock(Document.class);
	protected Document document2 = Mockito.mock(Document.class);
	protected Document document3 = Mockito.mock(Document.class);
	protected IndexableActionableDynamicQuery indexableActionableDynamicQuery;
	protected IndexWriterHelper indexWriterHelper = Mockito.mock(
		IndexWriterHelper.class);

	private ServiceRegistration<?> _serviceRegistration;

}