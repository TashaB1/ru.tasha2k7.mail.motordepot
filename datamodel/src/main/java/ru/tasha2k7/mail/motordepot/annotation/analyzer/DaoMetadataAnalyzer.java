package ru.tasha2k7.mail.motordepot.annotation.analyzer;

import java.lang.annotation.Annotation;

import ru.tasha2k7.mail.motordepot.annotation.DaoMetadata;

public class DaoMetadataAnalyzer {

	@SuppressWarnings("rawtypes")
	public Class getEntityClass(Object obj) {

	/*	if (clazz.isAnnotationPresent(DaoMetadata.class)) {
			// Получаем доступ к атрибутам
			Annotation annotation = clazz.getAnnotation(DaoMetadata.class);
			DaoMetadata daoMetadata = (DaoMetadata) annotation;

			clazz = daoMetadata.entity().getSuperclass();
		}*/
		
		Class subclass = obj.getClass();
	    Class superclass = subclass.getSuperclass();	
		
		return superclass;
	}
}
