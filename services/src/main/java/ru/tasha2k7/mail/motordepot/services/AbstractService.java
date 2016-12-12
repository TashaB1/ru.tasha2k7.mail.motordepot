package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface AbstractService<T> {

	@Transactional
	Long save(T obj);

	@Transactional
	void saveAll(List<T> obj);

	T getById(Long id);

	List<T> getAll();

	@Transactional
	void delete(Long id);
}
