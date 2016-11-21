package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Car;

public class SpecificationsVehicleMapper implements RowMapper<Car>{

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car entity = new Car();
        entity.setCapacityCarryingKg(rs.getDouble("capacity_carrying_kg"));
        entity.setLengthDimensionsM(rs.getDouble("length_dimensions_m"));
        entity.setWidthDimensionsM(rs.getDouble("width_dimensions_m"));
        entity.setHeigthDimensionsM(rs.getDouble("heigth_dimensions_m"));
        return entity;
	}

}
