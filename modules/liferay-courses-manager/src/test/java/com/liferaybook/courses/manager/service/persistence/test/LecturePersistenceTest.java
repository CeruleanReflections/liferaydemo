/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.liferaybook.courses.manager.exception.NoSuchLectureException;
import com.liferaybook.courses.manager.model.Lecture;
import com.liferaybook.courses.manager.service.LectureLocalServiceUtil;
import com.liferaybook.courses.manager.service.persistence.LecturePersistence;
import com.liferaybook.courses.manager.service.persistence.LectureUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class LecturePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferaybook.courses.manager.service"));

	@Before
	public void setUp() {
		_persistence = LectureUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Lecture> iterator = _lectures.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lecture lecture = _persistence.create(pk);

		Assert.assertNotNull(lecture);

		Assert.assertEquals(lecture.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Lecture newLecture = addLecture();

		_persistence.remove(newLecture);

		Lecture existingLecture = _persistence.fetchByPrimaryKey(
			newLecture.getPrimaryKey());

		Assert.assertNull(existingLecture);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLecture();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lecture newLecture = _persistence.create(pk);

		newLecture.setCompanyId(RandomTestUtil.nextLong());

		newLecture.setGroupId(RandomTestUtil.nextLong());

		newLecture.setCourseId(RandomTestUtil.nextLong());

		newLecture.setName(RandomTestUtil.randomString());

		newLecture.setDescription(RandomTestUtil.randomString());

		newLecture.setVideoLink(RandomTestUtil.randomString());

		_lectures.add(_persistence.update(newLecture));

		Lecture existingLecture = _persistence.findByPrimaryKey(
			newLecture.getPrimaryKey());

		Assert.assertEquals(
			existingLecture.getLectureId(), newLecture.getLectureId());
		Assert.assertEquals(
			existingLecture.getCompanyId(), newLecture.getCompanyId());
		Assert.assertEquals(
			existingLecture.getGroupId(), newLecture.getGroupId());
		Assert.assertEquals(
			existingLecture.getCourseId(), newLecture.getCourseId());
		Assert.assertEquals(existingLecture.getName(), newLecture.getName());
		Assert.assertEquals(
			existingLecture.getDescription(), newLecture.getDescription());
		Assert.assertEquals(
			existingLecture.getVideoLink(), newLecture.getVideoLink());
	}

	@Test
	public void testCountByCourseId() throws Exception {
		_persistence.countByCourseId(RandomTestUtil.nextLong());

		_persistence.countByCourseId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Lecture newLecture = addLecture();

		Lecture existingLecture = _persistence.findByPrimaryKey(
			newLecture.getPrimaryKey());

		Assert.assertEquals(existingLecture, newLecture);
	}

	@Test(expected = NoSuchLectureException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Lecture> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"lb_Lecture", "lectureId", true, "companyId", true, "groupId", true,
			"courseId", true, "name", true, "description", true, "videoLink",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Lecture newLecture = addLecture();

		Lecture existingLecture = _persistence.fetchByPrimaryKey(
			newLecture.getPrimaryKey());

		Assert.assertEquals(existingLecture, newLecture);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lecture missingLecture = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLecture);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Lecture newLecture1 = addLecture();
		Lecture newLecture2 = addLecture();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLecture1.getPrimaryKey());
		primaryKeys.add(newLecture2.getPrimaryKey());

		Map<Serializable, Lecture> lectures = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, lectures.size());
		Assert.assertEquals(
			newLecture1, lectures.get(newLecture1.getPrimaryKey()));
		Assert.assertEquals(
			newLecture2, lectures.get(newLecture2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Lecture> lectures = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(lectures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Lecture newLecture = addLecture();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLecture.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Lecture> lectures = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, lectures.size());
		Assert.assertEquals(
			newLecture, lectures.get(newLecture.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Lecture> lectures = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(lectures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Lecture newLecture = addLecture();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLecture.getPrimaryKey());

		Map<Serializable, Lecture> lectures = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, lectures.size());
		Assert.assertEquals(
			newLecture, lectures.get(newLecture.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LectureLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Lecture>() {

				@Override
				public void performAction(Lecture lecture) {
					Assert.assertNotNull(lecture);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Lecture newLecture = addLecture();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lecture.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("lectureId", newLecture.getLectureId()));

		List<Lecture> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Lecture existingLecture = result.get(0);

		Assert.assertEquals(existingLecture, newLecture);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lecture.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("lectureId", RandomTestUtil.nextLong()));

		List<Lecture> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Lecture newLecture = addLecture();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lecture.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lectureId"));

		Object newLectureId = newLecture.getLectureId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lectureId", new Object[] {newLectureId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLectureId = result.get(0);

		Assert.assertEquals(existingLectureId, newLectureId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lecture.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lectureId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lectureId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Lecture addLecture() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lecture lecture = _persistence.create(pk);

		lecture.setCompanyId(RandomTestUtil.nextLong());

		lecture.setGroupId(RandomTestUtil.nextLong());

		lecture.setCourseId(RandomTestUtil.nextLong());

		lecture.setName(RandomTestUtil.randomString());

		lecture.setDescription(RandomTestUtil.randomString());

		lecture.setVideoLink(RandomTestUtil.randomString());

		_lectures.add(_persistence.update(lecture));

		return lecture;
	}

	private List<Lecture> _lectures = new ArrayList<Lecture>();
	private LecturePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}