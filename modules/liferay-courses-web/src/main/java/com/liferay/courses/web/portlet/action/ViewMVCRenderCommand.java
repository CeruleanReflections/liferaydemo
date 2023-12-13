package com.liferay.courses.web.portlet.action;

import com.liferay.courses.web.constants.LiferayCoursesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferaybook.courses.api.LiferayCourse;
import com.liferaybook.courses.api.LiferayCoursesAPI;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + LiferayCoursesPortletKeys.PORTLET_ID,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)

public class ViewMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private LiferayCoursesAPI liferayCoursesAPI;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        renderRequest.setAttribute(LiferayCoursesAPI.class.getName(), liferayCoursesAPI);
        return LiferayCoursesPortletKeys.VIEW_JSP;
    }


}
