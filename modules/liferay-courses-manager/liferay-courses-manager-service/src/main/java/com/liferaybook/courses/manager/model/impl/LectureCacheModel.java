/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.liferaybook.courses.manager.model.Lecture;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Lecture in entity cache.
 *
 * @author Matteo Donnini
 * @generated
 */
public class LectureCacheModel implements CacheModel<Lecture>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LectureCacheModel)) {
			return false;
		}

		LectureCacheModel lectureCacheModel = (LectureCacheModel)object;

		if (lectureId == lectureCacheModel.lectureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lectureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{lectureId=");
		sb.append(lectureId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", videoLink=");
		sb.append(videoLink);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lecture toEntityModel() {
		LectureImpl lectureImpl = new LectureImpl();

		lectureImpl.setLectureId(lectureId);
		lectureImpl.setCompanyId(companyId);
		lectureImpl.setGroupId(groupId);
		lectureImpl.setCourseId(courseId);

		if (name == null) {
			lectureImpl.setName("");
		}
		else {
			lectureImpl.setName(name);
		}

		if (description == null) {
			lectureImpl.setDescription("");
		}
		else {
			lectureImpl.setDescription(description);
		}

		if (videoLink == null) {
			lectureImpl.setVideoLink("");
		}
		else {
			lectureImpl.setVideoLink(videoLink);
		}

		lectureImpl.resetOriginalValues();

		return lectureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		courseId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		videoLink = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lectureId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(courseId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (videoLink == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videoLink);
		}
	}

	public long lectureId;
	public long companyId;
	public long groupId;
	public long courseId;
	public String name;
	public String description;
	public String videoLink;

}