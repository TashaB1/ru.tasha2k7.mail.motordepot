package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.dimapper.RoleDiMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

@Repository
public class RoleDiMapperImpl implements RoleDiMapper {

	public Map<String, Object> mapColumns(Role role) {
		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		mapping.put("id", role.getId());
		mapping.put("name_role", role.getNameRole());
		return mapping;
	}

}
