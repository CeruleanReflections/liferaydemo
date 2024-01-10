/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;lb_Lecture&quot; database table.
 *
 * @author Matteo Donnini
 * @see Lecture
 * @generated
 */
public class LectureTable extends BaseTable<LectureTable> {

	public static final LectureTable INSTANCE = new LectureTable();

	public final Column<LectureTable, Long> lectureId = createColumn(
		"lectureId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LectureTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LectureTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LectureTable, Long> courseId = createColumn(
		"courseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LectureTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LectureTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LectureTable, String> videoLink = createColumn(
		"videoLink", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LectureTable() {
		super("lb_Lecture", LectureTable::new);
	}

}