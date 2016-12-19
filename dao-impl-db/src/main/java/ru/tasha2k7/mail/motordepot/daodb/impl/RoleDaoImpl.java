package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.IRoleDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RegistrationDataMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RoleMapper;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements IRoleDao {

	public RoleDaoImpl() {
		super(Role.class, "role", RoleMapper.class);
	}
	
	@Inject
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public List<RegistrationData> getAll(String role) {
		return jdbcTemplate.query("select * from registrationdata where name_role = ?", new Object[] { role },
				new RegistrationDataMapper());
	}

	@Override
	public List<RegistrationData> getAll(Long id) {
		return jdbcTemplate.query("select * from registrationdata where id = ?", new Object[] { id },
				new RegistrationDataMapper());
	}

	@Override
	public Long getIdByNameRole(String role) {
		return jdbcTemplate.queryForObject("select id from role where name_role = ?", Long.class, role);
	}

}
