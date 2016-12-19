package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.datamodel.Application;

@Repository
public class SpecificationsCargoDiMapperImpl implements RowMapper<Application>{

	@Override
	public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
		Application entity = new Application();
        entity.setWeightCargoKg(rs.getDouble("weight_cargo_kg"));
        entity.setLengthCargoM(rs.getDouble("length_cargo_m"));
        entity.setWidthCargoM(rs.getDouble("width_cargo_m"));
        entity.setHeigthCargoM(rs.getDouble("heigth_cargo_m"));
        return entity;
	}

}
