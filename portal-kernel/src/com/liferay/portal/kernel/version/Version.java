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

package com.liferay.portal.kernel.version;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shuyang Zhou
 */
public class Version implements Comparable<Version> {

	public static Version parseVersion(String version) {
		if (version == null) {
			return new Version(0, 0, 0);
		}

		version = version.trim();

		if (version.isEmpty()) {
			return new Version(0, 0, 0);
		}

		version = version.trim();

		Matcher matcher = _versionPattern.matcher(version);

		if (!matcher.matches()) {
			return new Version(0, 0, 0);
		}

		return new Version(
			GetterUtil.getInteger(matcher.group(1)),
			GetterUtil.getInteger(matcher.group(3)),
			GetterUtil.getInteger(matcher.group(5)),
			GetterUtil.getString(matcher.group(7)));
	}

	public Version(int major, int minor, int micro) {
		_major = major;
		_minor = minor;
		_micro = micro;

		_qualifier = StringPool.BLANK;
	}

	public Version(int major, int minor, int micro, String qualifier) {
		_major = major;
		_minor = minor;
		_micro = micro;
		_qualifier = qualifier;
	}

	@Override
	public int compareTo(Version version) {
		int result = Integer.compare(_major, version._major);

		if (result != 0) {
			return result;
		}

		result = Integer.compare(_minor, version._minor);

		if (result != 0) {
			return result;
		}

		result = Integer.compare(_micro, version._micro);

		if (result != 0) {
			return result;
		}

		String qualifier = version._qualifier;

		result = _qualifier.compareTo(qualifier);

		if (_qualifier.equals(StringPool.BLANK) ||
			qualifier.equals(StringPool.BLANK)) {

			return result * -1;
		}

		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Version)) {
			return false;
		}

		Version version = (Version)object;

		if ((_major == version._major) && (_minor == version._minor) &&
			(_micro == version._micro) &&
			_qualifier.equals(version._qualifier)) {

			return true;
		}

		return false;
	}

	public int getMajor() {
		return _major;
	}

	public int getMicro() {
		return _micro;
	}

	public int getMinor() {
		return _minor;
	}

	public String getQualifier() {
		return _qualifier;
	}

	@Override
	public int hashCode() {
		int hash = HashUtil.hash(0, _major);

		hash = HashUtil.hash(hash, _minor);
		hash = HashUtil.hash(hash, _micro);

		return HashUtil.hash(hash, _qualifier);
	}

	@Override
	public String toString() {
		if (getQualifier().equals(StringPool.BLANK)) {
			return StringBundler.concat(
				_major, StringPool.PERIOD, _minor, StringPool.PERIOD, _micro);
		}

		return StringBundler.concat(
			_major, StringPool.PERIOD, _minor, StringPool.PERIOD, _micro,
			StringPool.PERIOD, _qualifier);
	}

	private static final Pattern _versionPattern = Pattern.compile(
		"(\\d{1,10})(\\.(\\d{1,10})(\\.(\\d{1,10})" +
			"(\\.([-_\\da-zA-Z]+))?)?)?");

	private final int _major;
	private final int _micro;
	private final int _minor;
	private final String _qualifier;

}