package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.CarDao;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.services.CarService;

@Service
public class CarServiceImpl implements CarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

	@Inject
	private CarDao carDao;

	@Override
	public Long save(Car car) {
		if (car.getId() == null) {
			Long id = carDao.insert(car);
			LOGGER.info("Car created."); // id={}, ... ",
											// application.getId(), ...
											// );
			return id;
		} else {
			carDao.update(car);
			return car.getId();
		}
	}

	@Override
	public void saveAll(List<Car> cars) {
		for (Car car : cars) {
			save(car);
		}
	}

	@Override
	public Car getById(Long id) {
		return carDao.getById(id);
	}

	@Override
	public List<Car> getAll() {
		return carDao.getAll();
	}

	@Override
	public void delete(Long id) {
		carDao.delete(id);
		
	}

}
