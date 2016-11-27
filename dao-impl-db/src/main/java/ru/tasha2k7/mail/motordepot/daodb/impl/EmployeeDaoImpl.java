package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.ApplicationDao;
import ru.tasha2k7.mail.motordepot.daodb.ClientDao;
import ru.tasha2k7.mail.motordepot.daodb.EmployeeDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.EmployeeDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.EmployeeMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class, "employee",EmployeeMapper.class,EmployeeDiMapperImpl.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	private ApplicationDao applicationDao;
	
	@Inject
	private ClientDao clientDao;	
	
	@Override
	public List<Employee> getAllByPosition(String position) {
		return jdbcTemplate.query("select * from employee where position = ?", new Object[] { position },
				new EmployeeMapper());
	}
	
	@Override
	public List<Long> getAllIdByPosition(String position) {
		return  jdbcTemplate.queryForList("select id from employee where position = ?", new Object[] { position }, Long.class);
	}

	@Override
	public void appointCar(Long driverId, Long carId) {
		jdbcTemplate.update("update employee set car_id=? where id=?", carId, driverId);		
	}

	@Override
	public Long getCarIdByDriverId(Long driverId) {
		return jdbcTemplate.queryForObject("select car_id from employee where id = ?", Long.class, driverId);
	}


}
