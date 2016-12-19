package ru.tasha2k7.mail.motordepot.annotation.analyzer;


import java.lang.annotation.Annotation;

import org.springframework.core.annotation.AnnotationUtils;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;
import ru.tasha2k7.mail.motordepot.annotation.DaoMetadata;

/*@SuppressWarnings("unused")
public class DaoMetadataAnalyzer {

	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {

		final Class aClass = this.getClass();
		DaoMetadata ne = AnnotationUtils.findAnnotation(aClass, DaoMetadata.class);

		return ne.entity();
	}

}*/
public class DaoMetadataAnalyzer {


	@SuppressWarnings("rawtypes")
	public static Class getMapper(Class<?> clazz) {

		if (clazz.isAnnotationPresent(DaoMetadata.class)) {
			// Получаем доступ к атрибутам
			Annotation annotation = clazz.getAnnotation(DaoMetadata.class);
			DaoMetadata daoMetadata = (DaoMetadata) annotation;

			return daoMetadata.mapper();
		}
		return clazz;	
	}

}
