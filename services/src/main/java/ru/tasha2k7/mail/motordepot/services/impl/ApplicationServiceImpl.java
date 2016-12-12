package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

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
import ru.tasha2k7.mail.motordepot.services.ApplicationService;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Inject
	private ApplicationDao applicationDao;

	@Inject
	private CarDao сarDao;

	@Inject
	private EmployeeDao employeeDao;

	@Inject
	private EmployeeService employeeService;

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

		if ((specificationsCargo.getWeightCargoKg() < specificationsVehicle.getCapacityCarryingKg())
				&& (specificationsCargo.getLengthCargoM() < specificationsVehicle.getLengthDimensionsM())
				&& (specificationsCargo.getWidthCargoM() < specificationsVehicle.getWidthDimensionsM())
				&& (specificationsCargo.getHeigthCargoM() < specificationsVehicle.getHeigthDimensionsM())) {
			return true;
		} else
			return false;
	}

	@Override
	public void appoint(Long appId, Long driverId, Long dispatcherId) {

		Application app = applicationDao.getById(appId);

		if (app.getStatus() == ApplicationStatus.notDistributed && employeeService.emptyDriver(driverId)
				&& (employeeService.appointedCar(driverId))
				&& (сarDao.getcondition(employeeDao.getCarIdByDriverId(driverId)))
				&& MatchingSpecificationsVehicle(appId, employeeDao.getCarIdByDriverId(driverId))) {
			applicationDao.appointApplication(appId, driverId, dispatcherId, "distributed");
		}

		// получить список всех свободных авто
		// найти среди них подходящее авто:
		// 1. проверить состояние авто
		// 2. проверить соответствие габаритов

		// обновить объект Заявка */
	}

	@Override
	public void canceled(Long id) {
		applicationDao.changeStatus("canceled", id);
	}

	@Override
	public List<Application> getAll() {
		return applicationDao.getAll();
	}

	@Override
	public List<Application> getAll(String status) {
		return applicationDao.getAll(status);
	}

	@Override
	public Application getById(Long id) {
		return applicationDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		applicationDao.delete(id);
		
	}

}
