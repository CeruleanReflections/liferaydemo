/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferaybook.courses.manager.model.Lecture;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lecture service. This utility wraps <code>com.liferaybook.courses.manager.service.persistence.impl.LecturePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matteo Donnini
 * @see LecturePersistence
 * @generated
 */
public class LectureUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Lecture lecture) {
		getPersistence().clearCache(lecture);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Lecture> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lecture> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lecture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lecture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lecture> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lecture update(Lecture lecture) {
		return getPersistence().update(lecture);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lecture update(
		Lecture lecture, ServiceContext serviceContext) {

		return getPersistence().update(lecture, serviceContext);
	}

	/**
	 * Returns all the lectures where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching lectures
	 */
	public static List<Lecture> findByCourseId(long courseId) {
		return getPersistence().findByCourseId(courseId);
	}

	/**
	 * Returns a range of all the lectures where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @return the range of matching lectures
	 */
	public static List<Lecture> findByCourseId(
		long courseId, int start, int end) {

		return getPersistence().findByCourseId(courseId, start, end);
	}

	/**
	 * Returns an ordered range of all the lectures where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectures
	 */
	public static List<Lecture> findByCourseId(
		long courseId, int start, int end,
		OrderByComparator<Lecture> orderByComparator) {

		return getPersistence().findByCourseId(
			courseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectures where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectures
	 */
	public static List<Lecture> findByCourseId(
		long courseId, int start, int end,
		OrderByComparator<Lecture> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCourseId(
			courseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lecture in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lecture
	 * @throws NoSuchLectureException if a matching lecture could not be found
	 */
	public static Lecture findByCourseId_First(
			long courseId, OrderByComparator<Lecture> orderByComparator)
		throws com.liferaybook.courses.manager.exception.
			NoSuchLectureException {

		return getPersistence().findByCourseId_First(
			courseId, orderByComparator);
	}

	/**
	 * Returns the first lecture in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lecture, or <code>null</code> if a matching lecture could not be found
	 */
	public static Lecture fetchByCourseId_First(
		long courseId, OrderByComparator<Lecture> orderByComparator) {

		return getPersistence().fetchByCourseId_First(
			courseId, orderByComparator);
	}

	/**
	 * Returns the last lecture in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lecture
	 * @throws NoSuchLectureException if a matching lecture could not be found
	 */
	public static Lecture findByCourseId_Last(
			long courseId, OrderByComparator<Lecture> orderByComparator)
		throws com.liferaybook.courses.manager.exception.
			NoSuchLectureException {

		return getPersistence().findByCourseId_Last(
			courseId, orderByComparator);
	}

	/**
	 * Returns the last lecture in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lecture, or <code>null</code> if a matching lecture could not be found
	 */
	public static Lecture fetchByCourseId_Last(
		long courseId, OrderByComparator<Lecture> orderByComparator) {

		return getPersistence().fetchByCourseId_Last(
			courseId, orderByComparator);
	}

	/**
	 * Returns the lectures before and after the current lecture in the ordered set where courseId = &#63;.
	 *
	 * @param lectureId the primary key of the current lecture
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lecture
	 * @throws NoSuchLectureException if a lecture with the primary key could not be found
	 */
	public static Lecture[] findByCourseId_PrevAndNext(
			long lectureId, long courseId,
			OrderByComparator<Lecture> orderByComparator)
		throws com.liferaybook.courses.manager.exception.
			NoSuchLectureException {

		return getPersistence().findByCourseId_PrevAndNext(
			lectureId, courseId, orderByComparator);
	}

	/**
	 * Removes all the lectures where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 */
	public static void removeByCourseId(long courseId) {
		getPersistence().removeByCourseId(courseId);
	}

	/**
	 * Returns the number of lectures where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching lectures
	 */
	public static int countByCourseId(long courseId) {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	 * Caches the lecture in the entity cache if it is enabled.
	 *
	 * @param lecture the lecture
	 */
	public static void cacheResult(Lecture lecture) {
		getPersistence().cacheResult(lecture);
	}

	/**
	 * Caches the lectures in the entity cache if it is enabled.
	 *
	 * @param lectures the lectures
	 */
	public static void cacheResult(List<Lecture> lectures) {
		getPersistence().cacheResult(lectures);
	}

	/**
	 * Creates a new lecture with the primary key. Does not add the lecture to the database.
	 *
	 * @param lectureId the primary key for the new lecture
	 * @return the new lecture
	 */
	public static Lecture create(long lectureId) {
		return getPersistence().create(lectureId);
	}

	/**
	 * Removes the lecture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureId the primary key of the lecture
	 * @return the lecture that was removed
	 * @throws NoSuchLectureException if a lecture with the primary key could not be found
	 */
	public static Lecture remove(long lectureId)
		throws com.liferaybook.courses.manager.exception.
			NoSuchLectureException {

		return getPersistence().remove(lectureId);
	}

	public static Lecture updateImpl(Lecture lecture) {
		return getPersistence().updateImpl(lecture);
	}

	/**
	 * Returns the lecture with the primary key or throws a <code>NoSuchLectureException</code> if it could not be found.
	 *
	 * @param lectureId the primary key of the lecture
	 * @return the lecture
	 * @throws NoSuchLectureException if a lecture with the primary key could not be found
	 */
	public static Lecture findByPrimaryKey(long lectureId)
		throws com.liferaybook.courses.manager.exception.
			NoSuchLectureException {

		return getPersistence().findByPrimaryKey(lectureId);
	}

	/**
	 * Returns the lecture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureId the primary key of the lecture
	 * @return the lecture, or <code>null</code> if a lecture with the primary key could not be found
	 */
	public static Lecture fetchByPrimaryKey(long lectureId) {
		return getPersistence().fetchByPrimaryKey(lectureId);
	}

	/**
	 * Returns all the lectures.
	 *
	 * @return the lectures
	 */
	public static List<Lecture> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lectures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @return the range of lectures
	 */
	public static List<Lecture> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lectures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectures
	 */
	public static List<Lecture> findAll(
		int start, int end, OrderByComparator<Lecture> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LectureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectures
	 * @param end the upper bound of the range of lectures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectures
	 */
	public static List<Lecture> findAll(
		int start, int end, OrderByComparator<Lecture> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lectures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lectures.
	 *
	 * @return the number of lectures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LecturePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LecturePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LecturePersistence _persistence;

}