<%@ include file="init.jsp" %>

<% LiferayCoursesAPI coursesAPI = (LiferayCoursesAPI)request.getAttribute(LiferayCoursesAPI.class.getName()); %>

<liferay-ui:search-container
      total="<%= coursesAPI.getCoursesCount() %>" delta = "3" emptyResultsMessage="Nessun corso trovato">
   <liferay-ui:search-container-results
         results="<%= coursesAPI.getCourses(searchContainer.getStart(),
         searchContainer.getEnd())  %>"/>
   <liferay-ui:search-container-row
         className="com.liferaybook.courses.api.LiferayCourse"
         modelVar="course" keyProperty="courseId">
      <liferay-ui:search-container-column-text name="ID Corso"
                                     value="${course.courseId}" />
      <liferay-ui:search-container-column-text name="Nome"
                                     value="${course.name}" />
      <liferay-ui:search-container-column-text name="Descrizione"
                                     value="${course.description}" />
   </liferay-ui:search-container-row>
   <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>