package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

public class RegistrationDataMapper implements RowMapper<RegistrationData> {

	@Override
	public RegistrationData mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistrationData entity = new RegistrationData();
		entity.setId(rs.getLong("id"));
		entity.setEmail(rs.getString("email"));
		entity.setPassword(rs.getString("password"));
		entity.setRoleId(rs.getLong("role_id"));
		return entity;
	}

}
