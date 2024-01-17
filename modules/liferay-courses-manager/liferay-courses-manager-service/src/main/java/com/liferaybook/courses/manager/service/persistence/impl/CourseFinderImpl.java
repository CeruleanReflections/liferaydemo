package com.liferaybook.courses.manager.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferaybook.courses.manager.model.Course;
import com.liferaybook.courses.manager.model.impl.CourseImpl;
import com.liferaybook.courses.manager.service.persistence.CourseFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(service = CourseFinder.class)
public class CourseFinderImpl extends CourseFinderBaseImpl implements CourseFinder {

    public static final String FIND_DIFFERENT_USER_COURSES = CourseFinder.class.getName() + ".findDifferentUserCourses";
    public static final String FIND_COURSES_ID_GREATER_THAN_500 = CourseFinder.class.getName() + ".findCoursesGT500";
    public static final String FIND_DBEAVER_ADDED_COURSES = CourseFinder.class.getName() + ".findDBeaverAddedCourses";

    public List<Course> findDifferentUserCourses(long userId){
        Session session = null;
        try{
            session = openSession();
            String sql = _customSQL.get(getClass(), FIND_DIFFERENT_USER_COURSES);
            SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);
            sqlQuery.addEntity("Course", CourseImpl.class);

            QueryPos queryPos = QueryPos.getInstance(sqlQuery);
            queryPos.add(userId);

            return (List<Course>) QueryUtil.list(sqlQuery, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        } catch (Exception e){
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }
    public List<Course> findCoursesGT500(){
        Session session = null;
        try{
            session = openSession();
            String sql = _customSQL.get(getClass(), FIND_COURSES_ID_GREATER_THAN_500);
            SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);
            sqlQuery.addEntity("Course", CourseImpl.class);

            return (List<Course>) QueryUtil.list(sqlQuery, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        } catch (Exception e){
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }
    public List<Course> findDBeaverAddedCourses(){
        Session session = null;
        try{
            session = openSession();
            String sql = _customSQL.get(getClass(), FIND_DBEAVER_ADDED_COURSES);
            SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);
            sqlQuery.addEntity("Course", CourseImpl.class);

            return (List<Course>) QueryUtil.list(sqlQuery, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        } catch (Exception e){
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }

    @Reference
    private CustomSQL _customSQL;

}
