package ru.tasha2k7.mail.motordepot.daodb.impl;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.RegistrationDataDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RegistrationDataMapper;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

@Repository
public class RegistrationDataDaoImpl extends GenericDaoImpl<RegistrationData, Long> implements RegistrationDataDao{

	public RegistrationDataDaoImpl() {
		super(RegistrationData.class,"registrationdata");
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public RegistrationData findByEmail(String email) {
		return jdbcTemplate.queryForObject("select * from registration_data where email = ?", new Object[] { email },
				new RegistrationDataMapper());
	}

}
