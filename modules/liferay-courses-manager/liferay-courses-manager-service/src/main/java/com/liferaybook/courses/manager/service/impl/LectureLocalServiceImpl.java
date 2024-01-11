/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferaybook.courses.manager.model.Lecture;
import com.liferaybook.courses.manager.service.base.LectureLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Matteo Donnini
 */
@Component(
	property = "model.class.name=com.liferaybook.courses.manager.model.Lecture",
	service = AopService.class
)
public class LectureLocalServiceImpl extends LectureLocalServiceBaseImpl {

	public List<Lecture> getCourseLectures (long courseId){
		return lecturePersistence.findByCourseId(courseId);
	}

}