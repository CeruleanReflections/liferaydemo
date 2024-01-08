/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.service.base.CourseLocalServiceBaseImpl;

import com.liferaybook.courses.manager.service.persistence.CoursePersistence;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Matteo Donnini
 */
@Component(
	property = "model.class.name=com.liferaybook.courses.manager.model.Course",
	service = AopService.class
)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	public Course addCourse(long userId, long groupId, String name, String description) throws PortalException{
		User user = userLocalService.fetchUser(userId);
		long companyId = user.getCompanyId();
		long courseId = counterLocalService.increment();
		Course course = coursePersistence.create(courseId);
		course.setCompanyId(companyId);
		course.setGroupId(groupId);
		course.setUserId(userId);
		course.setUserName(user.getFullName());
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}

	public Course updateCourse(long userId, long courseId, String name, String description) throws PortalException{
		Course course = coursePersistence.findByPrimaryKey(courseId);
		course.setUserId(userId);
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}

	public int getGroupCoursesCount(long groupId){
		return coursePersistence.countByGroupId(groupId);
	}

	public List<Course> getGroupCourses(long groupId, int start, int end){
		return coursePersistence.findByGroupId(groupId, start, end);
	}
}
