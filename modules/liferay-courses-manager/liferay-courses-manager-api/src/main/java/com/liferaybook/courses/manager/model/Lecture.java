/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Lecture service. Represents a row in the &quot;lb_Lecture&quot; database table, with each column mapped to a property of this class.
 *
 * @author Matteo Donnini
 * @see LectureModel
 * @generated
 */
@ImplementationClassName(
	"com.liferaybook.courses.manager.model.impl.LectureImpl"
)
@ProviderType
public interface Lecture extends LectureModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferaybook.courses.manager.model.impl.LectureImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Lecture, Long> LECTURE_ID_ACCESSOR =
		new Accessor<Lecture, Long>() {

			@Override
			public Long get(Lecture lecture) {
				return lecture.getLectureId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Lecture> getTypeClass() {
				return Lecture.class;
			}

		};

	public Course getCourse();

}