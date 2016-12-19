package ru.tasha2k7.mail.motordepot.daoapi;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, PK extends Serializable> {

	T getById(final PK id);

	PK insert(final T obj);

	void update(final T obj);

	void delete(final PK id);

	void deleteAll(T obj);

	List<T> getAll();
	
	PK findTotalRecords();
	
	PK getSequence();
	
	
	//void update(String table, String pole, PK znach, Long id);
}
