<%@ include file="init.jsp" %>

<% LiferayCoursesAPI coursesAPI = (LiferayCoursesAPI)request.getAttribute(LiferayCoursesAPI.class.getName()); %>

<clay:container-fluid>
	<clay:sheet>
		<clay:sheet-section>
            <liferay-ui:search-container
                  total="<%= coursesAPI.getCoursesCount() %>" delta = "3" emptyResultsMessage="Nessun corso trovato">
               <liferay-ui:search-container-results
                     results="<%= coursesAPI.getCourses(searchContainer.getStart(), searchContainer.getEnd())  %>"/>
               <liferay-ui:search-container-row
                     className="com.liferaybook.courses.api.LiferayCourse" modelVar="course" keyProperty="courseId">
                  <liferay-ui:search-container-column-text name="ID Corso" value="${course.courseId}" />
                  <liferay-ui:search-container-column-text name="Nome" value="${course.name}" />
                  <liferay-ui:search-container-column-text name="Descrizione" value="${course.description}" />
                  <liferay-ui:search-container-column-text>
                     <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
                        <portlet:renderURL var="viewCourseURL">
                           <portlet:param name="mvcRenderCommandName" value="/courses/view_course" />
                           <portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>" />
                        </portlet:renderURL>
                        <liferay-ui:icon message="Dettagli" url="${viewCourseURL}"  />
                     </liferay-ui:icon-menu>
                  </liferay-ui:search-container-column-text>

               </liferay-ui:search-container-row>
               <liferay-ui:search-iterator markupView="lexicon" />
            </liferay-ui:search-container>
        </clay:sheet-section>
	</clay:sheet>
</clay:container-fluid>