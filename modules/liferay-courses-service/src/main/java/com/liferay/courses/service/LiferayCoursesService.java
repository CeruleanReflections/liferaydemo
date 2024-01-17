package com.liferay.courses.service;


import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferaybook.courses.api.LiferayCourse;
import com.liferaybook.courses.api.LiferayCoursesAPI;

import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.service.CourseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matteo.donnini
 */
@Component(service = LiferayCoursesAPI.class)
public class LiferayCoursesService implements LiferayCoursesAPI {

	@Override
	public int getCoursesCount(long groupId)
	{
		return courseLocalService.getGroupCoursesCount(groupId);
	}

	@Override
	public List<LiferayCourse> getDBeaverCreatedCourses() {
		List<Course> courses = courseLocalService.getDBeaverAddedCourses();
		return convertToLiferayCourses(courses);
	}

	@Override
	public List<LiferayCourse> getCoursesGT500() {
		List<Course> courses = courseLocalService.getCoursesGT500();
		return convertToLiferayCourses(courses);
	}

	@Override
	public int getDifferentUserCoursesCount(long userId) {
		return courseLocalService.getDifferentUserCourses(userId).size();
	}

	@Override
	public List<LiferayCourse> getDifferentUserCourses(long userId) {
		List<Course> courses = courseLocalService.getDifferentUserCourses(userId);
		return convertToLiferayCourses(courses);
	}

	@Override
	public List<LiferayCourse> getCourses(long groupId, int start, int end) {
		List<Course> courses = courseLocalService.getGroupCourses(groupId, start, end);
 		return convertToLiferayCourses(courses);
	}

	@Override
	public LiferayCourse getCourse(Long courseId) {
		Course course = courseLocalService.fetchCourse(courseId);
		return convertToLiferayCourse(course);
	}

	@Override
	public void updateCourse(long userId, Long courseId, String name, String description, ServiceContext serviceContext) throws PortalException {
		courseLocalService.updateCourse(userId, courseId, name, description, serviceContext);
	}
	@Override
	public void saveCourse(long userId, long groupId, String name, String description, ServiceContext serviceContext) throws PortalException {
		courseLocalService.addCourse(userId, groupId, name, description, serviceContext);
	}
	@Override
	public void deleteCourse(Long courseId) {
		try{
			courseLocalService.deleteCourse(courseId);
		} catch (PortalException e) {
            _log.error(e.getCause(), e);
        }
    }

	private LiferayCourse convertToLiferayCourse(Course course){
		LiferayCourse liferayCourse = null;
		if (course != null){
			liferayCourse = new LiferayCourse();
			BeanPropertiesUtil.copyProperties(course, liferayCourse);
		}
		return liferayCourse;
	}

	private List<LiferayCourse> convertToLiferayCourses(List<Course> courses){
		return courses.stream().map(this::convertToLiferayCourse).collect(Collectors.toList());
	}


	@Reference
	private CourseLocalService courseLocalService;

	private static final Log _log = LogFactoryUtil.getLog(LiferayCoursesService.class);

}