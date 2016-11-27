package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.EmployeeDiMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;


@Repository
public class EmployeeDiMapperImpl implements EmployeeDiMapper {

	@Override
	public Map<String, Object> mapColumns(Employee employee) {
		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		mapping.put("id", employee.getId());
		mapping.put("firstname", employee.getFirstname());
		mapping.put("lastname", employee.getLastname());
		mapping.put("surname", employee.getSurname());
		mapping.put("birthday", employee.getBirthday());
		mapping.put("number_driver_license", employee.getNumberDriverLicense());
		mapping.put("category_driver_license", employee.getCategoryDriverLicense());
		mapping.put("position", employee.getPosition());
		mapping.put("registration_data_id", employee.getRegistrationData().getId());
		mapping.put("car_id", employee.getCar().getId());
		mapping.put("deleted", employee.getDeleted());
		return mapping;
	}
}