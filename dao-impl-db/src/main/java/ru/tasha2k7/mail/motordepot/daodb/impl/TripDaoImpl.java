package ru.tasha2k7.mail.motordepot.daodb.impl;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.ITripDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.TripDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RegistrationDataMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.TripMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;

@Repository
public class TripDaoImpl extends GenericDaoImpl<Trip, Long> implements ITripDao {

	public TripDaoImpl() {
		super(Trip.class, "trip",TripMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Trip findRoute(String departure, String destination) {
		return jdbcTemplate.queryForObject("select * from trip where point_departure = ? and destination = ?", new Object[] {departure, destination },
				new TripMapper());
	}
}
