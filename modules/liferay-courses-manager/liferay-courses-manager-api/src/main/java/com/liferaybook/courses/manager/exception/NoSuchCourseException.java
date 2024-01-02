/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferaybook.courses.manager.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Matteo Donnini
 */
public class NoSuchCourseException extends NoSuchModelException {

	public NoSuchCourseException() {
	}

	public NoSuchCourseException(String msg) {
		super(msg);
	}

	public NoSuchCourseException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCourseException(Throwable throwable) {
		super(throwable);
	}

}