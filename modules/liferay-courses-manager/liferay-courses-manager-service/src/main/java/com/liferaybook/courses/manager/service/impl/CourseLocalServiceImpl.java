/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.service.base.CourseLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Matteo Donnini
 */
@Component(
	property = "model.class.name=com.liferaybook.courses.manager.model.Course",
	service = AopService.class
)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	public Course addCourse(String name, String description) throws PortalException{
		long courseId = counterLocalService.increment();
		Course course = coursePersistence.create(courseId);
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}

	public Course updateCourse(long courseId, String name, String description) throws PortalException{
		Course course = coursePersistence.findByPrimaryKey(courseId);
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}
}
