package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.datamodel.Trip;
@Repository
public class TripMapper implements RowMapper<Trip>{

	@Override
	public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trip entity = new Trip();
        entity.setId(rs.getLong("id"));
        entity.setPointDeparture(rs.getString("point_departure"));
        entity.setDestination(rs.getString("destination"));
        entity.setMileageKm(rs.getDouble("mileage_km"));
        return entity;
	}

}
