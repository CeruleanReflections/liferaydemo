package com.liferay.courses.service;


import com.liferay.portal.kernel.util.ListUtil;
import com.liferaybook.courses.api.LiferayCourse;
import com.liferaybook.courses.api.LiferayCoursesAPI;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matteo.donnini
 */
@Component(service = LiferayCoursesAPI.class)
public class LiferayCoursesService implements LiferayCoursesAPI {
	private List<LiferayCourse> courses;

	@Activate
	public void init(){
		courses = new ArrayList<>();

		courses.add(new LiferayCourse(1L,"Corso 1","Descrizione corso 1"));
		courses.add(new LiferayCourse(2L,"Corso 2","Descrizione corso 2"));
		courses.add(new LiferayCourse(3L,"Corso 3","Descrizione corso 3"));
		courses.add(new LiferayCourse(4L,"Corso 4","Descrizione corso 4"));
		courses.add(new LiferayCourse(5L,"Corso 5","Descrizione corso 5"));
		courses.add(new LiferayCourse(6L,"Corso 6","Descrizione corso 6"));
		courses.add(new LiferayCourse(7L,"Corso 7","Descrizione corso 7"));
		courses.add(new LiferayCourse(8L,"Corso 8","Descrizione corso 8"));
	}

	@Override
	public int getCoursesCount() {
		return courses.size();
	}

	@Override
	public List<LiferayCourse> getCourses(int start, int end) {
		return ListUtil.subList(courses, start, end);
	}

	@Override
	public LiferayCourse getCourse(Long courseId) {
		return courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst().orElse(null);
	}

}