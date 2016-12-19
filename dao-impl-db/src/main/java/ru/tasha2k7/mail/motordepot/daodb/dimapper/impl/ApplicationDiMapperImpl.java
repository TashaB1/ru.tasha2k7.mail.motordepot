package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.ApplicationDiMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Application;

@Repository
public class ApplicationDiMapperImpl implements ApplicationDiMapper {

	@Override
	public Map<String, Object> mapColumns(Application application) {

		Long id;

		if (application.getEmployee() == null) {
			id = null;
		} else {
			id = application.getEmployee().getId();
		}

		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		mapping.put("id", application.getId());
		mapping.put("number_application", application.getNumberApplication());
		mapping.put("date_application", application.getDateApplication());
		mapping.put("client_id", application.getClient().getId());
		mapping.put("trip_id", application.getTrip().getId());
		mapping.put("weight_cargo_kg", application.getWeightCargoKg());
		mapping.put("length_cargo_m", application.getLengthCargoM());
		mapping.put("width_cargo_m", application.getWidthCargoM());
		mapping.put("heigth_cargo_m", application.getHeigthCargoM());
		mapping.put("beginning_trip_mark", application.getBeginningTripMark());
		mapping.put("delivery_cargo_mark", application.getDeliveryCargoMark());
		mapping.put("ending_trip_mark", application.getEndingTripMark());
		mapping.put("dispatcher_id", id);
		mapping.put("driver_id", id);
		mapping.put("note", application.getNote());
		mapping.put("status", application.getStatus().toString());
		return mapping;
	}

}
