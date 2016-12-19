package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.IEmployeeDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.EmployeeMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long> implements IEmployeeDao {

	public EmployeeDaoImpl() {
		super(Employee.class, "employee", EmployeeMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllByPosition(String position) {
		return jdbcTemplate.query("select * from employee where position = ?", new Object[] { position },
				new EmployeeMapper());
	}

	@Override
	public List<Long> getAllIdByPosition(String position) {
		return jdbcTemplate.queryForList("select id from employee where position = ?", new Object[] { position },
				Long.class);
	}

	@Override
	public void appointCar(Long driverId, Long carId) {
		jdbcTemplate.update("update employee set car_id=? where id=?", carId, driverId);
	}

	@Override
	public Long getCarIdByDriverId(Long driverId) {
		return jdbcTemplate.queryForObject("select car_id from employee where id = ?", Long.class, driverId);
	}

	@Override
	public void deleted(Long id, Date date) {
		jdbcTemplate.update("update employee set deleted=? where id=?", date, id);
	}

}
