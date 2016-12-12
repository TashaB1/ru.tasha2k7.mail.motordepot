package ru.tasha2k7.mail.motordepot.web.converters;

public interface Converters<T,M> {

	T model2entity(M obj);
	
	M entity2model(T obj);
	
}
