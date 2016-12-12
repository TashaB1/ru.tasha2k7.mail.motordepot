package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;
import ru.tasha2k7.mail.motordepot.web.model.ClientRegistrationModel;
import ru.tasha2k7.mail.motordepot.web.model.RegistrationDataModel;

@RestController
@RequestMapping(value = "/auth/client")  // produces = MediaType.APPLICATION_JSON_VALUE говорит, что по умолчанию все методы этого контроллера будут отдавать JSON
public class ClientController {

	@Inject
	private ClientService clientService;

	@SuppressWarnings("unused")
	@Inject
	private RegistrationDataController registrationDataController;
	
	@Inject
	private MethodController methodController;

	@Inject
	private RegistrationDataService registrationDataService;
	
	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientModel> getById(@PathVariable Long clientId) {
	
		ClientModel clientModel = methodController.getById(clientId);
		
		/*	Client client = clientService.getById(clientId);
		RegistrationData registrationData = registrationDataService.getById(client.getRegistrationDataId());
		client.setRegistrationData(registrationData);
		
		 * if (client == null) { System.out.println("Client with id " + clientId
		 * + " not found"); return new
		 * ResponseEntity<ClientModel>(HttpStatus.NOT_FOUND); } else
		 */
		return new ResponseEntity<ClientModel>(clientModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientModel>> getAll() {
		
		List<ClientModel> converted = methodController.getAll();
		return new ResponseEntity<List<ClientModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewClient(@RequestBody ClientRegistrationModel clientRegistrationModel) {

		RegistrationDataModel registrationDataModel = clientRegistrationModel.getRegistrationDataModel();
		ClientModel clientModel = clientRegistrationModel.getClientModel();

		Long registrationDataId = registrationDataService.save(model2entity(registrationDataModel));
		registrationDataModel.setId(registrationDataId);
		clientModel.setRegistrationDataModel(registrationDataModel);
		clientService.save(model2entity(clientModel));

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{clientId}/{registrationDataId}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateClient(@RequestBody ClientRegistrationModel clientRegistrationModel,
			@PathVariable("clientId") Long clientId, @PathVariable("registrationDataId") Long registrationDataId) {

		RegistrationDataModel registrationDataModel = clientRegistrationModel.getRegistrationDataModel();
		ClientModel clientModel = clientRegistrationModel.getClientModel();
		
		registrationDataModel.setId(registrationDataId);
		RegistrationData registrationData = model2entity(registrationDataModel);
		registrationDataService.save(registrationData);
		
		clientModel.setRegistrationDataModel(registrationDataModel);
		clientModel.setId(clientId);
		Client client = model2entity(clientModel);
		clientService.save(client);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long clientId) {

		Client client = clientService.getById(clientId);
		Long registrationDataId = client.getRegistrationDataId();		
		clientService.delete(clientId);
		registrationDataService.delete(registrationDataId);
		
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	
//-----convertors	
	private RegistrationData model2entity(RegistrationDataModel registrationDataModel) {
		RegistrationData e = new RegistrationData();
		e.setId(registrationDataModel.getId());
		e.setEmail(registrationDataModel.getEmail());
		e.setPassword(registrationDataModel.getPassword());
		return e;
	}

	private RegistrationDataModel entity2model(RegistrationData registrationData) {
		RegistrationDataModel e = new RegistrationDataModel();
		e.setId(registrationData.getId());
		e.setEmail(registrationData.getEmail());
		e.setPassword(registrationData.getPassword());
		return e;
	}

	private ClientModel entity2model(Client client) {
		ClientModel e = new ClientModel();
		e.setId(client.getId());
		e.setNameClient(client.getNameClient());
		e.setAddress(client.getAddress());
		e.setNumberPhone(client.getNumberPhone());
		e.setRegistrationDataModel(entity2model(client.getRegistrationData()));
		e.setDeleted(client.getDeleted());
		return e;
	}

	private Client model2entity(ClientModel clientModel) {
		Client e = new Client();
		e.setId(clientModel.getId());
		e.setNameClient(clientModel.getNameClient());
		e.setAddress(clientModel.getAddress());
		e.setNumberPhone(clientModel.getNumberPhone());
		e.setRegistrationData(model2entity(clientModel.getRegistrationDataModel()));// e.setRegistrationData(clientModel.getRegistrationDataModel().getId());
		e.setDeleted(clientModel.getDeleted());
		return e;
	}

	private ClientRegistrationModel entity2model(Client client, RegistrationData registrationData) {

		ClientRegistrationModel clientRegistrationModel = new ClientRegistrationModel();

		clientRegistrationModel.setClientModel(entity2model(client));
		clientRegistrationModel.setRegistrationDataModel(entity2model(registrationData));

		return null;
	}

}
