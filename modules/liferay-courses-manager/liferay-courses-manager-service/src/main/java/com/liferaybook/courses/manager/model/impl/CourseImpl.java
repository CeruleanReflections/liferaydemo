/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model.impl;

import com.liferaybook.courses.manager.model.Lecture;
import com.liferaybook.courses.manager.service.LectureLocalServiceUtil;

import java.util.List;

/**
 * @author Matteo Donnini
 */
public class CourseImpl extends CourseBaseImpl {

    public List<Lecture> getLectures(){
        long courseId = getCourseId();
        return LectureLocalServiceUtil.getCourseLectures(courseId);
    }


}