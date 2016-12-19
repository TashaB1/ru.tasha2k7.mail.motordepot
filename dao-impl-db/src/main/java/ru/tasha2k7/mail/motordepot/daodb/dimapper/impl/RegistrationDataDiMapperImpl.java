package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.dimapper.RegistrationDataDiMapper;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

@Repository
public class RegistrationDataDiMapperImpl implements RegistrationDataDiMapper{
	
	@Override
	public Map<String, Object> mapColumns(RegistrationData registrationData) {
		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		mapping.put("id", registrationData.getId());
		mapping.put("email", registrationData.getEmail());
		mapping.put("password", registrationData.getPassword());
		Role role = registrationData.getRole();
		mapping.put("role_id", registrationData.getRole().getId());
		return mapping;
	}
}
