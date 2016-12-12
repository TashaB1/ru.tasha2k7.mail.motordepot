package ru.tasha2k7.mail.motordepot.services;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface EmployeeService extends AbstractService<Employee> {

	// ----driver----

	void markDeliveryTrip(Application application);

	void markConditionVehical(Car car);

	void updateStatus(Employee employee);

	Boolean appointedCar(Long driverId); // +- назначен ли водителю автомобиль

	Boolean emptyDriver(Long driverId); // свободен ли водитель
}
