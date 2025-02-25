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

import React from 'react';

import {CheckboxField} from '../../../../../../app/components/fragment-configuration-fields/CheckboxField';
import {HideFromSearchField} from '../../../../../../app/components/fragment-configuration-fields/HideFromSearchField';
import {SelectField} from '../../../../../../app/components/fragment-configuration-fields/SelectField';
import {VIEWPORT_SIZES} from '../../../../../../app/config/constants/viewportSizes';
import {
	useDispatch,
	useSelector,
} from '../../../../../../app/contexts/StoreContext';
import selectSegmentsExperienceId from '../../../../../../app/selectors/selectSegmentsExperienceId';
import updateItemConfig from '../../../../../../app/thunks/updateItemConfig';
import {getLayoutDataItemPropTypes} from '../../../../../../prop-types/index';
import CSSFieldSet from './CSSFieldSet';

const HTML_TAGS = [
	'div',
	'header',
	'nav',
	'section',
	'article',
	'main',
	'aside',
	'footer',
];

export default function ContainerAdvancedPanel({item}) {
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);
	const selectedViewportSize = useSelector(
		(state) => state.selectedViewportSize
	);

	return (
		<>
			{selectedViewportSize === VIEWPORT_SIZES.desktop && (
				<>
					<SelectField
						className="mb-1"
						field={{
							label: Liferay.Language.get('html-tag'),
							name: 'htmlTag',
							typeOptions: {
								validValues: HTML_TAGS.map((tag) => ({
									label: tag,
									value: tag,
								})),
							},
						}}
						onValueSelect={(name, value) => {
							const itemConfig = {
								[name]: value === 'div' ? '' : value,
							};

							dispatch(
								updateItemConfig({
									itemConfig,
									itemId: item.itemId,
									segmentsExperienceId,
								})
							);
						}}
						value={item.config.htmlTag}
					/>
					<p className="small text-secondary">
						{Liferay.Language.get(
							'misusing-this-setup-might-impact-seo'
						)}
					</p>

					<CheckboxField
						className="mb-2"
						field={{
							defaultValue: '',
							label: Liferay.Language.get(
								'set-content-visibility-to-auto'
							),
							name: 'contentVisibility',
							typeOptions: {
								customValues: {
									checked: 'auto',
									unchecked: '',
								},
							},
						}}
						onValueSelect={(name, value) => {
							dispatch(
								updateItemConfig({
									itemConfig: {
										[name]: value,
									},
									itemId: item.itemId,
									segmentsExperienceId,
								})
							);
						}}
						value={item.config.contentVisibility}
					/>
				</>
			)}

			<HideFromSearchField item={item} />

			<CSSFieldSet item={item} />
		</>
	);
}

ContainerAdvancedPanel.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
};
