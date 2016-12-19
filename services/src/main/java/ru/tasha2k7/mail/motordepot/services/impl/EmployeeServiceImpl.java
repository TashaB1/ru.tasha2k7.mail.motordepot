package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.Date;
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
import ru.tasha2k7.mail.motordepot.datamodel.Employee;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Inject
	private IEmployeeDao employeeDao;

	@Inject
	private IApplicationDao applicationDao;

	@Inject
	private ICarDao carDao;

	@Override
	public Long save(Employee employee) {
		if (employee.getId() == null) {
			Long id = employeeDao.insert(employee);
			LOGGER.info("Employee created.");
			return id;
		} else {
			employeeDao.update(employee);
			return employee.getId();
		}
	}

	@Override
	public void saveAll(List<Employee> employees) {
		for (Employee employee : employees) {
			save(employee);
		}
	}

	@Override
	public void markDeliveryTrip(Application application) {
		applicationDao.update(application);
	}

	@Override
	public void markConditionVehical(Car car) {
		carDao.update(car);
	}

	@Override
	public Boolean appointedCar(Long driverId) {
		Employee driver = employeeDao.getById(driverId);

		if (driver.getCarId() != null) {
			return true;
		} else
			return false;
	}

	@Override
	public Boolean emptyDriver(Long driverId) {
		List<Long> appointedDriver = applicationDao.getAllIdAppointedDriver(ApplicationStatus.distributed.name());

		if (appointedDriver.indexOf(driverId) == -1) {
			return true;
		} else
			return false;
	}

	@Override
	public Employee getById(Long id) {
		return employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public Long findTotalRecords() {
		return employeeDao.findTotalRecords();
	}

	@Override
	public Long getSequence() {
		return employeeDao.getSequence();
	}

	@Override
	public void deleted(Long id, Date date) {
		employeeDao.deleted(id, date);
	}

}
