package ru.tasha2k7.mail.motordepot.services;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.datamodel.Car;

public interface CarService extends AbstractService<Car>{
	
	void deleted(Long id, Date date);

}
