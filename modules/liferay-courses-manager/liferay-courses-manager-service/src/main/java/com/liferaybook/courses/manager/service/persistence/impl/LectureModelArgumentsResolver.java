/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferaybook.courses.manager.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.liferaybook.courses.manager.model.LectureTable;
import com.liferaybook.courses.manager.model.impl.LectureImpl;
import com.liferaybook.courses.manager.model.impl.LectureModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Lecture.
 *
 * @author Matteo Donnini
 * @generated
 */
@Component(
	property = {
		"class.name=com.liferaybook.courses.manager.model.impl.LectureImpl",
		"table.name=lb_Lecture"
	},
	service = ArgumentsResolver.class
)
public class LectureModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		LectureModelImpl lectureModelImpl = (LectureModelImpl)baseModel;

		long columnBitmask = lectureModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(lectureModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= lectureModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(lectureModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return LectureImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return LectureTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		LectureModelImpl lectureModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = lectureModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = lectureModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}