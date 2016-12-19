package ru.tasha2k7.mail.motordepot.daoxml.impl;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.ITripDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.TripDiMapperImpl;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;

@Repository
public class TripDaoXmlImpl extends GenericDaoXmlImpl<Trip, Long> implements ITripDao {

	@Override
	public Long getSequence() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Trip findRoute(String departure, String destination) {
		throw new UnsupportedOperationException();
	}

}
