package ru.tasha2k7.mail.motordepot.daodb.dimapper;

import java.util.Map;

public interface DiMapper<T> {	
	Map<String, Object> mapColumns(T t);
}
