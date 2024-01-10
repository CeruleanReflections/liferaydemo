/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferaybook.courses.manager.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Matteo Donnini
 */
public class NoSuchLectureException extends NoSuchModelException {

	public NoSuchLectureException() {
	}

	public NoSuchLectureException(String msg) {
		super(msg);
	}

	public NoSuchLectureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLectureException(Throwable throwable) {
		super(throwable);
	}

}