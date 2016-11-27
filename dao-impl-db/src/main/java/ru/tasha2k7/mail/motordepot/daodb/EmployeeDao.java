package ru.tasha2k7.mail.motordepot.daodb;

import java.util.ArrayList;
import java.util.List;

import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface EmployeeDao extends GenericDao<Employee, Long>{

	List<Employee> getAllByPosition(String position);
	
	List<Long> getAllIdByPosition(String position);

	void appointCar(Long driverId, Long carId);  //назначить авто водителю
	
	Long getCarIdByDriverId(Long driverId);
}
