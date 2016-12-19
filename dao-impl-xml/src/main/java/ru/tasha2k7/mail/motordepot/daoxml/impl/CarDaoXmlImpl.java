package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.util.Date;

import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.ICarDao;
import ru.tasha2k7.mail.motordepot.datamodel.Car;

@Repository
public class CarDaoXmlImpl extends GenericDaoXmlImpl<Car, Long> implements ICarDao {


	@Override
	public Car SpecificationsVehicle(Long Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean getcondition(Long Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getSequence() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleted(Long id, Date date) {
		throw new UnsupportedOperationException();
	}

}