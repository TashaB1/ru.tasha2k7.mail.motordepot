package ru.tasha2k7.mail.motordepot.daodb.impl;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.CarDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.CarDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.CarMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.SpecificationsVehicleMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Car;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car, Long> implements CarDao {

	public CarDaoImpl() {
		super(Car.class, "car", CarMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Car SpecificationsVehicle(Long Id) {
		try {
			return jdbcTemplate.queryForObject("select * from car where id = ?", new Object[] { Id }, new SpecificationsVehicleMapper());
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@Override
	public Boolean getcondition(Long Id) {
		return jdbcTemplate.queryForObject("select condition_vehical from car where id = ?", Boolean.class, Id);
	}

}