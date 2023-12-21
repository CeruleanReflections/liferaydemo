<%@ include file="init.jsp" %>

<portlet:actionURL name="/courses/edit_course" var="editCourseURL" />
<aui:form action="${editCourseURL}" method="post" name="fm">

   <aui:input name="courseId" type="hidden" value="${course.courseId}" />
   <clay:container-fluid>
       <clay:sheet>
           <clay:sheet-header>
               <h2 class="sheet-title">
               <c:choose>
                    <c:when test="${course.courseId gt 0}">
                        Modifica corso "${course.courseId}" "${course.name}"
                    </c:when>
                <c:otherwise>
                    Aggiungi un nuovo corso
                </c:otherwise>
               </c:choose>
               </h2>
           </clay:sheet-header>
           <clay:sheet-section>
               <aui:input name="name" label="Nome" value="${course.name}" />
               <aui:input name="description" label="Descrizione" value="${course.description}" />
           </clay:sheet-section>
           <clay:sheet-footer cssClass="sheet-footer-btn-block-sm-down">
               <div class="btn-group">
                   <div class="btn-group-item">
              <clay:button displayType="primary" label="Salva" type="submit" />
              <clay:link href="${coursesListUrl}" type="button" displayType="secondary" label="Annulla" />
                   </div>
               </div>
           </clay:sheet-footer>
       </clay:sheet>
   </clay:container-fluid>
</aui:form>
