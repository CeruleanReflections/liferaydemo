package com.liferay.courses.web.portlet;

import com.liferay.courses.web.constants.LiferayCoursesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

/**
 * @author matteo.donnini
 */

@Component(
	property = {
		"com.liferay.portlet.display-category=" + LiferayCoursesPortletKeys.CATEGORY_NAME,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + LiferayCoursesPortletKeys.DISPLAY_NAME,
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=" + LiferayCoursesPortletKeys.VIEW_JSP,
		"javax.portlet.name=" + LiferayCoursesPortletKeys.PORTLET_ID,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.css-class-wrapper=liferay-courses-wrapper",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)

public class LiferayCoursesPortlet extends MVCPortlet {

}