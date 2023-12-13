package com.liferaybook.courses.api;

import java.util.List;

/**
 * @author matteo.donnini
 */
public interface LiferayCoursesAPI {
    int getCoursesCount();
    List<LiferayCourse> getCourses(int start, int end);
    LiferayCourse getCourse(Long courseId);
}