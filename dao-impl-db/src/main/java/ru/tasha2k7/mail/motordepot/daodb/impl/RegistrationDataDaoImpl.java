package ru.tasha2k7.mail.motordepot.daodb.impl;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.RegistrationDataDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.RegistrationDataDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RegistrationDataMapper;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

@Repository
public class RegistrationDataDaoImpl extends GenericDaoImpl<RegistrationData, Long> implements RegistrationDataDao{

	public RegistrationDataDaoImpl() {
		super(RegistrationData.class,"registrationdata",RegistrationDataMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public RegistrationData findByEmail(String email) {
		return jdbcTemplate.queryForObject("select * from registrationdata where email = ?", new Object[] { email },
				new RegistrationDataMapper());
	}

	@Override
	public RegistrationData getRegistrationData(Long id) {
		return jdbcTemplate.queryForObject("select * from registrationdata where id = ?", new Object[] { id },
				new RegistrationDataMapper());
	}

	@Override
	public String getRoleName(String email) {
		return jdbcTemplate.queryForObject("select r.name_role from registrationdata rd left join role r on rd.role_id=r.id where rd.email = ?", String.class, email);
		
	}

}
