package ru.tasha2k7.mail.motordepot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE) // только для классов
@Retention(RetentionPolicy.RUNTIME) // позволит сохранять нашу аннотацию JVM во
									// время выполнения, что даст возможность
									// использовать отображение(reflection)
public @interface DaoMetadata {
	//String name() default ""; // default - говорит про то, что метод по
	// умолчанию будет возвращать определённое
	// значение

	Class<?> mapper() default Void.class;
	
	
	//Class<?> dimapper() default Void.class;
}
