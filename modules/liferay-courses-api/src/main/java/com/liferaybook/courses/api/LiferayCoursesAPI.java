package com.liferaybook.courses.api;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author matteo.donnini
 */
public interface LiferayCoursesAPI {
    int getCoursesCount();
    List<LiferayCourse> getCourses(int start, int end);
    LiferayCourse getCourse(Long courseId);
    void updateCourse(Long courseId, String name, String description) throws PortalException;
    void saveCourse(String name, String description) throws PortalException;
    void deleteCourse(Long courseId);
}