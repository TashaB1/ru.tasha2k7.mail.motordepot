package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.tasha2k7.mail.motordepot.datamodel.Car;

public class CarMapper implements RowMapper<Car>{

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car entity = new Car();
        entity.setId(rs.getLong("id"));
        entity.setMakeModel(rs.getString("make_model"));
        entity.setNumberRegistration(rs.getString("number_registration"));
        entity.setCapacityCarryingKg(rs.getDouble("capacity_carrying_kg"));
        entity.setLengthDimensionsM(rs.getDouble("length_dimensions_m"));
        entity.setWidthDimensionsM(rs.getDouble("width_dimensions_m"));
        entity.setHeigthDimensionsM(rs.getDouble("heigth_dimensions_m"));
        entity.setConditionVehical(rs.getBoolean("condition_vehical"));
        entity.setInspectionDate(rs.getDate("inspection_date"));
        entity.setDeleted(rs.getDate("deleted"));
        return entity;
	}

}
