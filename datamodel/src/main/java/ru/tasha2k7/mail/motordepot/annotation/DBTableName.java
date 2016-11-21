package ru.tasha2k7.mail.motordepot.annotation;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE) // только для классов
@Retention(RetentionPolicy.RUNTIME) // позволит сохранять нашу аннотацию JVM во
									// время выполнения, что даст возможность
									// использовать отображение(reflection)
public @interface DBTableName {
	String name() default ""; // default - говорит про то, что метод по
								// умолчанию будет возвращать определённое
								// значение
}
