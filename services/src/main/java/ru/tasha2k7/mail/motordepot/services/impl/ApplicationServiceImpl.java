package ru.tasha2k7.mail.motordepot.services.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.ApplicationDao;
import ru.tasha2k7.mail.motordepot.daodb.CarDao;
import ru.tasha2k7.mail.motordepot.daodb.EmployeeDao;
import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;
import ru.tasha2k7.mail.motordepot.services.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Inject
	private ApplicationDao applicationDao;

	@Inject
	private CarDao сarDao;
	
	@Inject
	private EmployeeDao employeeDao;

	@Override
	public Long save(Application application) {
		if (application.getId() == null) {
			Long id = applicationDao.insert(application);
			LOGGER.info("Application created."); // id={}, ... ",
													// application.getId(), ...
													// );
			return id;
		} else {
			applicationDao.update(application);
			return application.getId();
		}
	}

	@Override
	public void saveAll(List<Application> applications) {
		for (Application application : applications) {
			save(application);
		}
	}

	@Override
	public Boolean MatchingSpecificationsVehicle(Long appId, Long carId) {

		Application specificationsCargo = applicationDao.SpecificationsCargo(appId);

		Car specificationsVehicle = сarDao.SpecificationsVehicle(carId);

		if  ((specificationsCargo.getWeightCargoKg() < specificationsVehicle.getCapacityCarryingKg()) 
				&& (specificationsCargo.getLengthCargoM() < specificationsVehicle.getLengthDimensionsM())
				&& (specificationsCargo.getWidthCargoM() < specificationsVehicle.getWidthDimensionsM())
				&& (specificationsCargo.getHeigthCargoM() < specificationsVehicle.getHeigthDimensionsM()) ) {
			return true;
		} else
			return false;
	}

	@Override
	public void appoint(Employee employee) {
		//найти свободного водителя  : получить заявки действующие
		//		List<Long> driverInTrip = null;
		
		
		ApplicationStatus applicationStatus = ApplicationStatus.distributed;
		List<Application> currentApplication = applicationDao.getAllByStatusApplication(applicationStatus);
		
		ArrayList<Long> allIdDrivers = (ArrayList<Long>) employeeDao.getAllIdByPosition("driver");		 		
		
		for (Application application : currentApplication) {
			allIdDrivers.remove(application.getDriverId());
			allIdDrivers.trimToSize();
		}
		ArrayList<Long> emptyDrivers = allIdDrivers;
		
		
		/*for (Long driver: emptyDrivers){
			if (driver != ) {
					if ((MatchingSpecificationsVehicle(application.getId(), driver.getId())) ) {
						//&& (carDao.getcondition(driver.getId()))
					}
				}
			}
		}
		
		//получить список всех свободных авто
		//найти среди них подходящее авто: 
		//1. проверить состояние авто
		//2. проверить соответствие габаритов 
		
		//обновить объект Заявка */
	}

	@Override
	public void canceled(Long id) {

	}

}
