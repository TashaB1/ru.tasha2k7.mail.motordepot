package ru.tasha2k7.mail.motordepot.daodb.dimapper.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.DiMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Client;

@Repository
public class ClientDiMapperImpl implements DiMapper<Client> {

	@Override
	public Map<String, Object> mapColumns(Client client) {
		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		mapping.put("id", client.getId());
		mapping.put("name_client", client.getNameClient());
		mapping.put("address", client.getAddress());
		mapping.put("number_phone", client.getNumberPhone());
		mapping.put("registration_data_id", client.getRegistrationData().getId());
		mapping.put("deleted", client.getDeleted());
		return mapping;
	}

}
