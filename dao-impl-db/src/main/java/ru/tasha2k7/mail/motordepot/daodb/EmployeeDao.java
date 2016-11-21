package ru.tasha2k7.mail.motordepot.daodb;

import java.util.ArrayList;
import java.util.List;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface EmployeeDao extends GenericDao<Employee, Long>{

	ArrayList<Employee> getAllByPosition(String position);
	
	ArrayList<Long> getAllIdByPosition(String position);

	
}
