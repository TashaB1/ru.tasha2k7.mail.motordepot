package ru.tasha2k7.mail.motordepot.annotation.analyzer;


import org.springframework.core.annotation.AnnotationUtils;

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
	public Class getEntityClass(Object obj) {

		final Class aClass = obj.getClass();
		DaoMetadata ne = AnnotationUtils.findAnnotation(aClass, DaoMetadata.class);

		return ne.entity();
	}

}
