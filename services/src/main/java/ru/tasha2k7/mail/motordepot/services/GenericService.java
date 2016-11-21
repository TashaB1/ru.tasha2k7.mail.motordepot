package ru.tasha2k7.mail.motordepot.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericService<T, PK extends Serializable> {
	
	@Transactional
    PK save(final T obj);
	
	@Transactional
    void saveAll(List<T> obj);
	
	T getById(PK id);

    List<T> getAll();
	
}
