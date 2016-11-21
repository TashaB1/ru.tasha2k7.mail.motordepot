package ru.tasha2k7.mail.motordepot.annotation.analyzer;

import java.lang.annotation.Annotation;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;

public class DBTableNameAnalyzer {

	public String getDBTableName(Class<?> clazz) {
		String result;

		if (clazz.isAnnotationPresent(DBTableName.class)) {
			// Получаем доступ к атрибутам
			Annotation annotation = clazz.getAnnotation(DBTableName.class);
			DBTableName dbTableName = (DBTableName) annotation;

			if (!dbTableName.name().isEmpty()) {
				result = dbTableName.name();
			} else {
				result = (clazz.getSimpleName()).toLowerCase();
			}
		} else {
			result = (clazz.getSimpleName()).toLowerCase();
		}
		return result;
	}
}
