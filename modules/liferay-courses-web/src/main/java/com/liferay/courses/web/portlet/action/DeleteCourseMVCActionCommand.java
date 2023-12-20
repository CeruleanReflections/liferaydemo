package com.liferay.courses.web.portlet.action;

import com.liferay.courses.web.constants.LiferayCoursesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferaybook.courses.api.LiferayCoursesAPI;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + LiferayCoursesPortletKeys.PORTLET_ID,
                "mvc.command.name=/courses/delete_course"
        },
        service = MVCActionCommand.class
)

public class DeleteCourseMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        Long courseId = ParamUtil.getLong(actionRequest, "courseId");
        liferayCoursesAPI.deleteCourse(courseId);
    }

    @Reference
    private LiferayCoursesAPI liferayCoursesAPI;
}