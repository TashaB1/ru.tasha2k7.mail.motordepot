package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.EmployeeDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.EmployeeMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class, "employee");
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ArrayList<Employee> getAllByPosition(String position) {
		return (ArrayList<Employee>) jdbcTemplate.query("select * from employee where position = ?", new Object[] { position },
				new EmployeeMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Long> getAllIdByPosition(String position) {
		return jdbcTemplate.queryForObject("select id from employee where position = ?", new Object[] { position }, ArrayList.class);
	}


}
