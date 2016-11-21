package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.tasha2k7.mail.motordepot.datamodel.Application;

public class ApplicationMapper implements RowMapper<Application>{

	@Override
	public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
		Application entity = new Application();
        entity.setId(rs.getLong("id"));
        entity.setNumberApplication(rs.getLong("number_application"));
        entity.setDateApplication(rs.getDate("date_application"));
        entity.getClient().setId(rs.getLong("client_id"));
        entity.getTrip().setId(rs.getLong("trip_id"));
        entity.setWeightCargoKg(rs.getDouble("weight_cargo_kg"));
        entity.setLengthCargoM(rs.getDouble("length_cargo_m"));
        entity.setWidthCargoM(rs.getDouble("width_cargo_m"));
        entity.setHeigthCargoM(rs.getDouble("heigth_cargo_m"));
        entity.setBeginningTripMark(rs.getDate("beginning_trip_mark"));
        entity.setDeliveryCargoMark(rs.getDate("delivery_cargo_mark"));
        entity.setEndingTripMark(rs.getDate("ending_trip_mark"));
        entity.getEmployee().setId(rs.getLong("dispatcher_id"));
        entity.getEmployee().setId(rs.getLong("driver_id"));
        entity.setNote(rs.getString("note"));
        entity.setStatus(Application.ApplicationStatus.valueOf(rs.getString("status")));
        return entity;
	}

}
