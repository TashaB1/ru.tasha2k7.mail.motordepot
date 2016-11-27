package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;
public class EmployeeMapper implements RowMapper<Employee> {
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee entity = new Employee();
		entity.setId(rs.getLong("id"));
		entity.setFirstname(rs.getString("firstname"));
		entity.setLastname(rs.getString("lastname"));
		entity.setSurname(rs.getString("surname"));
		entity.setBirthday(rs.getDate("birthday"));
		entity.setNumberDriverLicense(rs.getString("number_driver_license"));
		entity.setCategoryDriverLicense(rs.getString("category_driver_license"));
		entity.setPosition(rs.getString("position"));
		entity.setRegistrationDataId(rs.getLong("registration_data_id"));
		entity.setCarId(rs.getLong("car_id"));
		
		/*entity.getRegistrationData().setId(rs.getLong("registration_data_id"));

		RegistrationData registrationData = new RegistrationData();
		registrationData.setId(rs.getLong("registration_data_id"));
		registrationData.setEmail(rs.getString("email"));
		registrationData.setPassword(rs.getString("password"));		
		
		entity.setRegistrationData(registrationData);*/
		
		entity.setDeleted(rs.getDate("deleted"));
		return entity;
	}

}
