package ru.tasha2k7.mail.motordepot.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.services.GenericService;

@Service
public class GenericServiceImpl <T, PK extends Serializable> implements GenericService<T, PK>{

	@Override
	public PK save(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<T> obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
