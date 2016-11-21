package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.tasha2k7.mail.motordepot.datamodel.Role;

public class RoleMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role entity = new Role();
        entity.setId(rs.getLong("id"));
        entity.setNameRole(rs.getString("name_role"));
        return entity;
	}

}
