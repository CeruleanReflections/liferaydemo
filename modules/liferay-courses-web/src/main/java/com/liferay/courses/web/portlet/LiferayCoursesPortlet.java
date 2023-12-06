package com.liferay.courses.web.portlet;

import com.liferay.courses.web.constants.LiferayCoursesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.swing.*;

import com.liferaybook.courses.api.LiferayCourse;
import com.liferaybook.courses.api.LiferayCoursesAPI;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author matteo.donnini
 */

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LiferayCourses",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LiferayCoursesPortletKeys.LIFERAYCOURSES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class LiferayCoursesPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ArrayList<LiferayCourse> courses = liferayCoursesAPI.getCourses();
		renderRequest.setAttribute("courses",courses);
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private LiferayCoursesAPI liferayCoursesAPI;
}