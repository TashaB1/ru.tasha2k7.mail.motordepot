package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.ApplicationDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.ApplicationDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.ApplicationMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RoleMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.SpecificationsCargoMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Application;

@Repository
public class ApplicationDaoImpl extends GenericDaoImpl<Application, Long> implements ApplicationDao {

	public ApplicationDaoImpl() {
		super(Application.class, "application", ApplicationMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Application> getAllByClientId(Long clientId) {
		return jdbcTemplate.query("select * from application where client_id = ?", new Object[] { clientId },
				new ApplicationMapper());
	}

	@Override
	public List<Application> getAllByDriverId(Long driverId) {
		return jdbcTemplate.query("select * from application where driver_id = ?", new Object[] { driverId },
				new ApplicationMapper());
	}

	@Override
	public List<Application> getAllByDispatcherId(Long dispatcherId) {
		return jdbcTemplate.query("select * from application where dispatcher_id = ?", new Object[] { dispatcherId },
				new ApplicationMapper());
	}

	@Override
	public List<Application> getAllByTripId(Long tripId) {
		return jdbcTemplate.query("select * from application where trip_id = ?", new Object[] { tripId },
				new ApplicationMapper());
	}

	@Override
	public List<Application> getAllByStatusApplication(Application.ApplicationStatus status) {
		try {
			return jdbcTemplate.query("select * from motordepot.application where status = ?", new Object[] { status },
					new ApplicationMapper());

			// new
			// ApplicationMapper());
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@Override
	public Application SpecificationsCargo(Long Id) {
		try {
			return jdbcTemplate.queryForObject("select * from application where id = ?",new Object[] { Id },
					new SpecificationsCargoMapper());
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@Override
	public List<Application> getAll(String status) {
		return jdbcTemplate.query("select * from application where status = ?", new Object[] { status },
				new ApplicationMapper());
	}

	@Override
	public void changeStatus(String status, Long appId) {
		jdbcTemplate.update("update application set status=? where id=?", status, appId);
	}

	@Override
	public List<Long> getAllIdAppointedDriver(String status) {
		return  jdbcTemplate.queryForList("select id from application where status = ?", new Object[] { status }, Long.class);
	}

	@Override
	public void appointApplication(Long appId, Long driverId, Long dispatcherId, String status) {
		jdbcTemplate.update("update application set driver_id=?, dispatcher_id=?, status=? where id=?", driverId, dispatcherId, status, appId);
		
	}

}
