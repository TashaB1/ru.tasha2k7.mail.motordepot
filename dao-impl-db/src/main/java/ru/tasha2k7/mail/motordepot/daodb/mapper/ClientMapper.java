package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
@Repository
public class ClientMapper implements RowMapper<Client>{

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client entity = new Client();
        entity.setId(rs.getLong("id"));
        entity.setNameClient(rs.getString("name_client"));
        entity.setAddress(rs.getString("address"));
        entity.setNumberPhone(rs.getString("number_phone"));
        entity.setRegistrationDataId(rs.getLong("registration_data_id"));
        entity.setDeleted(rs.getDate("deleted"));
        return entity;
	}
}
