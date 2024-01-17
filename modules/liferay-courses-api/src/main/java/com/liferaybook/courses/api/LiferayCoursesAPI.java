package com.liferaybook.courses.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * @author matteo.donnini
 */
public interface LiferayCoursesAPI {
    int getCoursesCount(long groupId);

    List<LiferayCourse> getDBeaverCreatedCourses();
    List<LiferayCourse> getCoursesGT500();
    int getDifferentUserCoursesCount(long userId);
    List<LiferayCourse> getDifferentUserCourses(long userId);
    List<LiferayCourse> getCourses(long groupId, int start, int end);
    LiferayCourse getCourse(Long courseId);
    void updateCourse(long userId, Long courseId, String name, String description, ServiceContext serviceContext) throws PortalException;
    void saveCourse(long userId, long groupId, String name, String description, ServiceContext serviceContext) throws PortalException;
    void deleteCourse(Long courseId);
}