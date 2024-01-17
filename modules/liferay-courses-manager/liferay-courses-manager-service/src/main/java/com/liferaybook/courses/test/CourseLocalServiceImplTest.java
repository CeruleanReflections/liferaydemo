package com.liferaybook.courses.test;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.service.CourseLocalService;
import com.liferaybook.courses.manager.service.impl.CourseLocalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
@RunWith(MockitoJUnitRunner.class)
public class CourseLocalServiceImplTest {

    public static String name = "Ciao Ciao";
    public static String description = "Descrizione Ciao Ciao";
    public static long userId = 21211L;
    public static long companyId = 20096L;
    public static long courseId = 41406L;
    public static long groupId = 21564L;

    public ServiceContext getServiceContext(){
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(companyId);
        serviceContext.setUserId(userId);
        serviceContext.setScopeGroupId(groupId);
        return serviceContext;
    }
    CourseLocalServiceImpl courseLocalServiceToBeTested = new CourseLocalServiceImpl();

    private void createImpl(){
        CourseLocalService courseLocalService = Mockito.mock(CourseLocalService.class);
        Mockito.when(courseLocalService.fetchCourse(courseId)).thenReturn(createCourse());
        Mockito.when(courseLocalService.getCoursesCount()).thenReturn(1);
        Mockito.when(courseLocalService.addCourse(createCourse())).thenReturn(createCourse());
    }


    @Test
    public void testThatCoursesCanFetched() {
        Course tempCourse = courseLocalServiceToBeTested.fetchCourse(courseId);
        Optional<Course> result = Optional.ofNullable(tempCourse);
        assert(result.isPresent());
    }

    private Course createCourse(){
        Course course = Mockito.mock(Course.class);
        course.setCourseId(1L);
        course.setDescription("Description");
        course.setName("CourseNAME");
        course.setCompanyId(companyId);
        course.setGroupId(groupId);
        return course;
    }

}
