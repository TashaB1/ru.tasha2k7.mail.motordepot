package ru.tasha2k7.mail.motordepot.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.tasha2k7.mail.motordepot.datamodel.Application;


public class ApplicationMapper implements RowMapper<Application>{

	/*implement abstract method for declaring mapping
     *between POJO attributes and relational table attributes
     */
	
	@Override
	public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
				
		Application entity = new Application();
        entity.setId(id);
        entity.setNumberApplication(rs.getLong("number_application"));
        entity.setDateApplication(rs.getDate("date_application"));
        entity.setClientId(rs.getLong("client_id"));
        entity.setTripId(rs.getLong("trip_id"));
        entity.setWeightCargoKg(rs.getDouble("weight_cargo_kg"));
        entity.setLengthCargoM(rs.getDouble("length_cargo_m"));
        entity.setWidthCargoM(rs.getDouble("width_cargo_m"));
        entity.setHeigthCargoM(rs.getDouble("heigth_cargo_m"));
        entity.setBeginningTripMark(rs.getDate("beginning_trip_mark"));
        entity.setDeliveryCargoMark(rs.getDate("delivery_cargo_mark"));
        entity.setEndingTripMark(rs.getDate("ending_trip_mark"));
        entity.setDispatcherId(rs.getLong("dispatcher_id"));
        entity.setDriverId(rs.getLong("driver_id"));
        entity.setNote(rs.getString("note"));
        entity.setStatus(Application.ApplicationStatus.valueOf(rs.getString("status")));
        return entity;
	}

}
