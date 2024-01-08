package com.liferay.courses.web.portlet.action;

import com.liferay.courses.web.constants.LiferayCoursesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferaybook.courses.api.LiferayCoursesAPI;
import org.jsoup.helper.Validate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component (
        immediate = true,
        property = {
                "javax.portlet.name=" + LiferayCoursesPortletKeys.PORTLET_ID,
                "mvc.command.name=/courses/edit_course"
        },
        service = MVCActionCommand.class
)

public class EditCourseMVCActionCommand extends BaseMVCActionCommand {

    /*I parametri del metodo ParamUtil.get... devono rispecchiare il campo input name presente nel file JSP.
    La modifica viene accettata ugualmente ma i parametri modificati sono vuoti perchè il metodo non trova il campo che cerca.
    * */
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            Long courseId = ParamUtil.getLong(actionRequest, "courseId");
            String name = ParamUtil.getString(actionRequest, "name");

            if (Validator.isBlank(name) || name.trim().length() < 5) {
                SessionErrors.add(actionRequest, "courseNameNotValid");
                actionResponse.getRenderParameters().setValue("mvcRenderCommandName", "/courses/edit_course");
                hideDefaultErrorMessage(actionRequest);
                return;
            }

            String description = ParamUtil.getString(actionRequest, "description");
            long groupId = portal.getScopeGroupId(actionRequest);
            long userId = portal.getUserId(actionRequest);
            if (courseId > 0)
                liferayCoursesAPI.updateCourse(userId, courseId, name, description);
            else
                liferayCoursesAPI.saveCourse(userId, groupId, name, description);

        } catch (Exception e) {
            SessionErrors.add(actionRequest, e.getClass());
            actionResponse.getRenderParameters().setValue("mvcRenderCommandName", "/courses/edit_course");
            hideDefaultErrorMessage(actionRequest);
        }
    }

    @Reference
    private LiferayCoursesAPI liferayCoursesAPI;

    @Reference
    private Portal portal;
}
