package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.ApplicationDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.ApplicationMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.SpecificationsCargoMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Application;

@Repository
public class ApplicationDaoImpl extends GenericDaoImpl<Application, Long> implements ApplicationDao {	

	public ApplicationDaoImpl() {
		super(Application.class, "application");
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
		return jdbcTemplate.query("select * from application where status = ?", new Object[] { status.toString() },
				new ApplicationMapper());
	}

	@Override
	public Application SpecificationsCargo(Long Id) {
		try {
			return jdbcTemplate.queryForObject("select * from application where id = ?",
					new SpecificationsCargoMapper());
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

}
