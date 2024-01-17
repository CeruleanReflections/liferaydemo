/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferaybook.courses.manager.exception.CourseDescriptionLengthException;
import com.liferaybook.courses.manager.exception.CourseNameLengthException;
import com.liferaybook.courses.manager.exception.DuplicateCourseNameException;
import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.service.base.CourseLocalServiceBaseImpl;
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

	public Course addCourse(long userId, long groupId, String name, String description, ServiceContext serviceContext) throws PortalException{
		long courseId = counterLocalService.increment();
		validate(courseId,groupId,name,description);
		User user = userLocalService.fetchUser(userId);
		Course course = coursePersistence.create(courseId);
		course.setCompanyId(serviceContext.getCompanyId());
		course.setGroupId(groupId);
		course.setUserId(userId);
		course.setUserName(user.getFullName());
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}

	public Course updateCourse(long userId, long courseId, String name, String description, ServiceContext serviceContext) throws PortalException{
		Course course = coursePersistence.findByPrimaryKey(courseId);
		validate(courseId,course.getGroupId(),name,description);
		course.setUserId(userId);
		course.setName(name);
		course.setDescription(description);
		return courseLocalService.updateCourse(course);
	}

	private void validate(long courseId, long groupId, String name, String description) throws PortalException {
		int nameMinLength = 5;
		int nameMaxLength = ModelHintsUtil.getMaxLength(Course.class.getName(), "name");
		if (Validator.isNull(name) || name.length() < nameMinLength || name.length() > nameMaxLength){
			throw new CourseNameLengthException(String.format("Course name should have from %d to %d characters.", nameMinLength, nameMaxLength));
		}

		if (Validator.isNull(description)){
			int descriptionMaxLength = ModelHintsUtil.getMaxLength(Course.class.getName(), "description");
			if (description.length() > descriptionMaxLength){
				throw new CourseDescriptionLengthException(String.format("Description has more than %d characters", descriptionMaxLength));
			}
		}

		Course course = coursePersistence.fetchByGroupIdAndName(groupId, name);
		if (course != null && course.getCourseId() != courseId) {
			throw new DuplicateCourseNameException(String.format("Course name %s is already in use", name));
		}
	}

	public int getGroupCoursesCount(long groupId){
		return coursePersistence.countByGroupId(groupId);
	}

	public List<Course> getGroupCourses(long groupId, int start, int end){
		return coursePersistence.findByGroupId(groupId, start, end);
	}
	public List<Course> getDifferentUserCourses(long userId){
		return courseFinder.findDifferentUserCourses(userId);
	}

	public List<Course> getCoursesGT500(){
		return courseFinder.findCoursesGT500();
	}

	public List<Course> getDBeaverAddedCourses(){
		return courseFinder.findDBeaverAddedCourses();
	}

}
