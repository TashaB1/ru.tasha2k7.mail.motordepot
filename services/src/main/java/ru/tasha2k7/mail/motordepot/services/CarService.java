package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Car;

public interface CarService {

	@Transactional
	Long save(Car car);
	
	@Transactional
    void saveAll(List<Car> car);

}
