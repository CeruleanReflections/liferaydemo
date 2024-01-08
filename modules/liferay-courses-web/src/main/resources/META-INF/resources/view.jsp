<%@ include file="init.jsp" %>

<% LiferayCoursesAPI coursesAPI = (LiferayCoursesAPI)request.getAttribute(LiferayCoursesAPI.class.getName()); %>

<clay:container-fluid>
	<clay:sheet>
		<clay:sheet-section>

        <%-- Bottone Aggiunta Corsi --%>
        <div class="w-100 text-right">
		<portlet:renderURL var="addCourseURL">
            <portlet:param name="mvcRenderCommandName" value="/courses/edit_course" />
            </portlet:renderURL>
            <clay:link href="${addCourseURL}" label="+" type="button" displayType="primary" />
        </div>

            <liferay-ui:search-container total="<%= coursesAPI.getCoursesCount(scopeGroupId) %>" delta="4" emptyResultsMessage="Nessun corso trovato">
            				<liferay-ui:search-container-results results="<%= coursesAPI.getCourses(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd())  %>"/>
               <liferay-ui:search-container-row

                     className="com.liferaybook.courses.api.LiferayCourse" modelVar="course" keyProperty="courseId">
                  <liferay-ui:search-container-column-text name="courses-courses-id" value="${course.courseId}" />
                  <liferay-ui:search-container-column-text name="courses-name" value="${course.name}" />
                  <liferay-ui:search-container-column-text name="courses-description" value="${course.description}" />
                  <liferay-ui:search-container-column-text name="courses-user" value="${course.userName}" />
                  <liferay-ui:search-container-column-text name="courses-create-date"> <fmt:formatDate var="courseCreateDate" value="${course.createDate}" pattern="dd-MM-yyyy hh:mm" /> ${courseCreateDate} </liferay-ui:search-container-column-text>
                  <liferay-ui:search-container-column-text name="courses-modified-date"> <fmt:formatDate var="courseModifiedDate" value="${course.modifiedDate}" pattern="dd-MM-yyyy hh:mm" /> ${courseModifiedDate} </liferay-ui:search-container-column-text>

                  <liferay-ui:search-container-column-text>
                     <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">

                        <%-- Comando Dettagli --%>
                        <portlet:renderURL var="viewCourseURL">
                           <portlet:param name="mvcRenderCommandName" value="/courses/view_course" />
                           <portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>" />
                        </portlet:renderURL>
                        <liferay-ui:icon message="Dettagli" url="${viewCourseURL}"  />

                        <%-- Comando Modifica --%>
                        <portlet:renderURL var="editCourseURL">
                        <portlet:param name="mvcRenderCommandName" value="/courses/edit_course" />
                        <portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>" />
                        </portlet:renderURL>
                        <liferay-ui:icon message="Modifica" url="${editCourseURL}" />

                        <%-- Comando Elimina --%>
                        <portlet:actionURL name="/courses/delete_course" var="deleteCourseURL">
                        <portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>" />
                        </portlet:actionURL>
                        <liferay-ui:icon-delete message="Elimina" confirmation="Sei sicuro di voler eliminare il corso?" url="${deleteCourseURL}" />

                     </liferay-ui:icon-menu>
                  </liferay-ui:search-container-column-text>

               </liferay-ui:search-container-row>

               <liferay-ui:search-iterator markupView="lexicon" />
            </liferay-ui:search-container>

        </clay:sheet-section>
	</clay:sheet>
</clay:container-fluid>