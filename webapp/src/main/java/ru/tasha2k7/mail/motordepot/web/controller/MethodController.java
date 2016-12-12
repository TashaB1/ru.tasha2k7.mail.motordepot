package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.web.converters.ClientConverter;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;

@Component
public class MethodController {

	@Inject
	private ClientService clientService;

	@Inject
	private RegistrationDataService registrationDataService;

	public List<ClientModel> getAll() {

		List<Client> all = clientService.getAll();

		List<ClientModel> converted = new ArrayList<>();
		for (Client client : all) {
			converted.add(entity2model(client));
		}
		return converted;
	}

	public ClientModel getById(Long clientId) {
		Client client = clientService.getById(clientId);
		RegistrationData registrationData = registrationDataService.getById(client.getRegistrationDataId());
		client.setRegistrationData(registrationData);
		/*
		 * if (client == null) { System.out.println("Client with id " + clientId
		 * + " not found"); return new
		 * ResponseEntity<ClientModel>(HttpStatus.NOT_FOUND); } else
		 */
		return entity2model(client);
	}

	// ----- converters -----
	private ClientModel entity2model(Client client) {
		ClientModel e = new ClientModel();
		e.setId(client.getId());
		e.setNameClient(client.getNameClient());
		e.setAddress(client.getAddress());
		e.setNumberPhone(client.getNumberPhone());
		e.setRegistrationDataId(client.getRegistrationDataId());
		e.setDeleted(client.getDeleted());
		return e;
	}
	
	
	
	

}
