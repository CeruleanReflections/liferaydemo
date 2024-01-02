/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;lb_Course&quot; database table.
 *
 * @author Matteo Donnini
 * @see Course
 * @generated
 */
public class CourseTable extends BaseTable<CourseTable> {

	public static final CourseTable INSTANCE = new CourseTable();

	public final Column<CourseTable, Long> courseId = createColumn(
		"courseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CourseTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CourseTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CourseTable() {
		super("lb_Course", CourseTable::new);
	}

}