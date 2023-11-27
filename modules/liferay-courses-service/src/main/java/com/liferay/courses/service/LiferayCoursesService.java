package com.liferay.courses.service;

import com.liferay.courses.api.LiferayCourse;
import com.liferay.courses.api.LiferayCoursesAPI;

import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matteo.donnini
 */
@Component(
	property = {
		// TODO enter required service properties
	},
	service = LiferayCoursesAPI.class
)
public class LiferayCoursesService implements LiferayCoursesAPI {
	@Override
	public List<LiferayCourse> getCourses() {
		List<LiferayCourse> courses = new ArrayList<>();
		courses.add(new LiferayCourse("7.4 Business User", "Guide for Business Users"));
		courses.add(new LiferayCourse("7.4 BE Developer", "Guide for BE Developers"));
		courses.add(new LiferayCourse("7.4 FE Developer", "Guide for FE Developers"));
		return courses;
	}

	// TODO enter required service methods

}