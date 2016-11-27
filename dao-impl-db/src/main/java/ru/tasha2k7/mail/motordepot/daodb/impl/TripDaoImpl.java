package ru.tasha2k7.mail.motordepot.daodb.impl;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.TripDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.TripDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.TripMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;

@Repository
public class TripDaoImpl extends GenericDaoImpl<Trip, Long> implements TripDao {

	public TripDaoImpl() {
		super(Trip.class, "trip",TripMapper.class,TripDiMapperImpl.class);
	}
}
