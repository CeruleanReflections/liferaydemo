<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.liferaybook.courses.api.LiferayCourse" %>
<%@ page import="com.liferaybook.courses.api.LiferayCoursesAPI" %>
<%@ page import="com.liferaybook.courses.manager.exception.CourseNameLengthException" %>
<%@ page import="com.liferaybook.courses.manager.exception.CourseDescriptionLengthException" %>
<%@ page import="com.liferaybook.courses.manager.exception.DuplicateCourseNameException" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="coursesListUrl" />