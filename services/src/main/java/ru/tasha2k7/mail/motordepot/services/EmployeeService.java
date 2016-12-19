package ru.tasha2k7.mail.motordepot.services;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface EmployeeService extends AbstractService<Employee> {

	// ----driver----

	void markDeliveryTrip(Application application);

	void markConditionVehical(Car car);

	Boolean appointedCar(Long driverId); // +- назначен ли водителю автомобиль

	Boolean emptyDriver(Long driverId); // свободен ли водитель

	void deleted(Long id, Date date);
}
