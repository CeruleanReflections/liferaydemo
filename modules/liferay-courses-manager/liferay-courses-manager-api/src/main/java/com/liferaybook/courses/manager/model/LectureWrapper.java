/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Lecture}.
 * </p>
 *
 * @author Matteo Donnini
 * @see Lecture
 * @generated
 */
public class LectureWrapper
	extends BaseModelWrapper<Lecture>
	implements Lecture, ModelWrapper<Lecture> {

	public LectureWrapper(Lecture lecture) {
		super(lecture);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureId", getLectureId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("courseId", getCourseId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("videoLink", getVideoLink());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureId = (Long)attributes.get("lectureId");

		if (lectureId != null) {
			setLectureId(lectureId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String videoLink = (String)attributes.get("videoLink");

		if (videoLink != null) {
			setVideoLink(videoLink);
		}
	}

	@Override
	public Lecture cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this lecture.
	 *
	 * @return the company ID of this lecture
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the course ID of this lecture.
	 *
	 * @return the course ID of this lecture
	 */
	@Override
	public long getCourseId() {
		return model.getCourseId();
	}

	/**
	 * Returns the description of this lecture.
	 *
	 * @return the description of this lecture
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this lecture.
	 *
	 * @return the group ID of this lecture
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lecture ID of this lecture.
	 *
	 * @return the lecture ID of this lecture
	 */
	@Override
	public long getLectureId() {
		return model.getLectureId();
	}

	/**
	 * Returns the name of this lecture.
	 *
	 * @return the name of this lecture
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this lecture.
	 *
	 * @return the primary key of this lecture
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video link of this lecture.
	 *
	 * @return the video link of this lecture
	 */
	@Override
	public String getVideoLink() {
		return model.getVideoLink();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this lecture.
	 *
	 * @param companyId the company ID of this lecture
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the course ID of this lecture.
	 *
	 * @param courseId the course ID of this lecture
	 */
	@Override
	public void setCourseId(long courseId) {
		model.setCourseId(courseId);
	}

	/**
	 * Sets the description of this lecture.
	 *
	 * @param description the description of this lecture
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this lecture.
	 *
	 * @param groupId the group ID of this lecture
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lecture ID of this lecture.
	 *
	 * @param lectureId the lecture ID of this lecture
	 */
	@Override
	public void setLectureId(long lectureId) {
		model.setLectureId(lectureId);
	}

	/**
	 * Sets the name of this lecture.
	 *
	 * @param name the name of this lecture
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this lecture.
	 *
	 * @param primaryKey the primary key of this lecture
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video link of this lecture.
	 *
	 * @param videoLink the video link of this lecture
	 */
	@Override
	public void setVideoLink(String videoLink) {
		model.setVideoLink(videoLink);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LectureWrapper wrap(Lecture lecture) {
		return new LectureWrapper(lecture);
	}

}