package ru.tasha2k7.mail.motordepot.web.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.impl.ClientServiceImpl;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Inject
	private ClientService clientService;

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<ClientModel> getById(@PathVariable Long clientId) {
		Client client = clientService.getById(clientId);
		return new ResponseEntity<ClientModel>(entity2model(client), HttpStatus.OK);
	}

	private ClientModel entity2model(Client client) {
		ClientModel e = new ClientModel();
		e.setNameClient(client.getNameClient());
		e.setAddress(client.getAddress());
		e.setNumberPhone(client.getNumberPhone());
		e.setRegistrationDataId(client.getRegistrationDataId());
		e.setDeleted(client.getDeleted());
		return e;
	}

	private Client model2entity(ClientModel clientModel) {
		Client e = new Client();
		e.setNameClient(clientModel.getNameClient());
		e.setAddress(clientModel.getAddress());
		e.setNumberPhone(clientModel.getNumberPhone());
		e.setRegistrationDataId(clientModel.getRegistrationDataId());
		e.setDeleted(clientModel.getDeleted());
		return e;
	}

}
