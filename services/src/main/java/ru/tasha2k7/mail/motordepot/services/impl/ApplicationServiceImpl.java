package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daoapi.IApplicationDao;
import ru.tasha2k7.mail.motordepot.daoapi.ICarDao;
import ru.tasha2k7.mail.motordepot.daoapi.IEmployeeDao;
import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.services.ApplicationService;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Inject
	private IApplicationDao applicationDao;

	@Inject
	private ICarDao сarDao;

	@Inject
	private IEmployeeDao employeeDao;

	@Inject
	private EmployeeService employeeService;

	@Override
	public Long save(Application application) {
		if (application.getId() == null) {
			Long id = applicationDao.insert(application);
			LOGGER.info("Application created: " + application.toString());
			return id;
		} else {
			applicationDao.update(application);
			LOGGER.info("Application update: " + application.toString());
			return application.getId();
		}
	}

	@Override
	public void saveAll(List<Application> applications) {
		for (Application application : applications) {
			save(application);
			LOGGER.info("Saved all applications: " + application.toString());
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

			LOGGER.info(
					"Specifications vehicle correspond to application. Car id=" + carId + ", application id=" + appId);

			return true;
		} else {
			LOGGER.info("Specifications vehicle do not correspond to application. Car id=" + carId + ", application id="
					+ appId);
			return false;
		}
	}

	@Override
	public void appoint(Long appId, Long driverId, Long dispatcherId) {

		Application app = applicationDao.getById(appId);

		if (app.getStatus() == ApplicationStatus.notDistributed && employeeService.emptyDriver(driverId)
				&& (employeeService.appointedCar(driverId))
				&& (сarDao.getcondition(employeeDao.getCarIdByDriverId(driverId)))
				&& MatchingSpecificationsVehicle(appId, employeeDao.getCarIdByDriverId(driverId))) {
			applicationDao.appointApplication(appId, driverId, dispatcherId, ApplicationStatus.distributed.name());
			LOGGER.info("Specifications vehicle do not correspond to application. Application №"
					+ app.getNumberApplication() + " appointed to the driver "
					+ employeeDao.getById(driverId).getFirstname() + " " + employeeDao.getById(driverId).getLastname()
					+ " dispatcher " + employeeDao.getById(dispatcherId).getFirstname() + " "
					+ employeeDao.getById(dispatcherId).getLastname());
		}

		// получить список всех свободных авто
		// найти среди них подходящее авто:
		// 1. проверить состояние авто
		// 2. проверить соответствие габаритов
		// обновить объект Заявка */
	}

	// @Override
	// public void canceled(Long id) {
	// applicationDao.changeStatus("canceled", id);
	// LOGGER.info("Application canceled: " +
	// applicationDao.getById(id).toString());
	// }

	@Override
	public void changeStatus(String status, Long id) {

		String oldStatus = applicationDao.getById(id).getStatus().toString();

		applicationDao.changeStatus(status, id);
		LOGGER.info("Application change status: " + oldStatus + " -> " + status + ".");
	}

	@Override
	public List<Application> getAll() {
		//LOGGER.info("Get all applications.");
		return applicationDao.getAll();
	}

	@Override
	public List<Application> getAll(String status) {
		LOGGER.info("Get all applications by status " + status + ".");
		return applicationDao.getAll(status);
	}

	@Override
	public Application getById(Long id) {
		//LOGGER.info("Get application by " + id + ".");
		return applicationDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Delete application by " + id + ".");
		applicationDao.delete(id);
	}

	@Override
	public Long findTotalRecords() {
		return applicationDao.findTotalRecords();
	}

	@Override
	public Long getSequence() {
		return applicationDao.getSequence();
	}

}
