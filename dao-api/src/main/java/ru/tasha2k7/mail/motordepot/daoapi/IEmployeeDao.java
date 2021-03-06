package ru.tasha2k7.mail.motordepot.daoapi;

import java.util.Date;
import java.util.List;

import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface IEmployeeDao extends IGenericDao<Employee, Long> {

	List<Employee> getAllByPosition(String position);

	List<Long> getAllIdByPosition(String position);

	void appointCar(Long driverId, Long carId); // назначить авто водителю

	Long getCarIdByDriverId(Long driverId);

	void deleted(Long id, Date date);
}
