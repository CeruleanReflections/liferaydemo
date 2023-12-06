package com.liferay.courses.service;

import com.liferaybook.courses.api.LiferayCourse;
import com.liferaybook.courses.api.LiferayCoursesAPI;

import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;


/**
 * @author matteo.donnini
 */
@Component(
	property = {
	},
	service = LiferayCoursesAPI.class
)
public class LiferayCoursesService implements LiferayCoursesAPI {
	@Override
	public ArrayList<LiferayCourse> getCourses() {
		ArrayList<LiferayCourse> courses = new ArrayList<>();
		courses.add(new LiferayCourse("Corso 1", "Descrizione corso 1"));
		courses.add(new LiferayCourse("Corso 2","Descrizione corso 2"));
		courses.add(new LiferayCourse("Corso 3", "Descrizione corso 3"));
		return courses;
	}

}