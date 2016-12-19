package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.services.RoleService;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;
import ru.tasha2k7.mail.motordepot.web.model.ClientRegistrationRoleModel;
import ru.tasha2k7.mail.motordepot.web.model.RegistrationDataModel;
import ru.tasha2k7.mail.motordepot.web.model.RoleModel;

@RestController
@RequestMapping(value = "/basicAuthSecured/clientRest", produces = MediaType.APPLICATION_JSON_VALUE+"; charset=UTF-8")  // produces = MediaType.APPLICATION_JSON_VALUE говорит, что по умолчанию все методы этого контроллера будут отдавать JSON
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

	@Inject
	private RoleService roleService;

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientModel> getById(@PathVariable Long clientId) {

		ClientModel clientModel = methodController.getById(clientId);

//		if (clientModel == null) {
//			// System.out.priSntln("Client with id " + clientId + " not found");
//			return new ResponseEntity<ClientModel>(clientModel, HttpStatus.NOT_FOUND);
//		} else
			return new ResponseEntity<ClientModel>(clientModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientModel>> getAll() {

		// List<ClientModel> converted = methodController.getAll();
		List<Client> all = clientService.getAll();

		List<ClientModel> converted = new ArrayList<>();
		for (Client client : all) {

			RegistrationData registrationData = registrationDataService.getById(client.getRegistrationDataId());
			Role role = roleService.getById(registrationData.getRoleId());
			registrationData.setRole(role);
			client.setRegistrationData(registrationData);

			converted.add(entity2model(client));
		}
		return new ResponseEntity<List<ClientModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewClient(@RequestBody ClientRegistrationRoleModel clientRegistrationRoleModel) {

		RegistrationDataModel registrationDataModel = clientRegistrationRoleModel.getRegistrationDataModel();
		ClientModel clientModel = clientRegistrationRoleModel.getClientModel();
		RoleModel roleModel = clientRegistrationRoleModel.getRoleModel();

		Long roleId = roleService.getIdByNameRole(roleModel.getNameRole());
		roleModel.setId(roleId);

		registrationDataModel.setRoleModel(roleModel);
		Long registrationDataId = registrationDataService.save(model2entity(registrationDataModel));
		registrationDataModel.setId(registrationDataId);

		clientModel.setRegistrationDataModel(registrationDataModel);

		clientService.save(model2entity(clientModel));

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{clientId}/{registrationDataId}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateClient(@RequestBody ClientRegistrationRoleModel clientRegistrationRoleModel,
			@PathVariable("clientId") Long clientId, @PathVariable("registrationDataId") Long registrationDataId) {

		RegistrationDataModel registrationDataModel = clientRegistrationRoleModel.getRegistrationDataModel();
		ClientModel clientModel = clientRegistrationRoleModel.getClientModel();
		RoleModel roleModel = clientRegistrationRoleModel.getRoleModel();

		Long roleId = roleService.getIdByNameRole(roleModel.getNameRole());
		roleModel.setId(roleId);

		registrationDataModel.setRoleModel(roleModel);
		registrationDataModel.setId(registrationDataId);

		clientModel.setRegistrationDataModel(registrationDataModel);
		clientModel.setId(clientId);
		clientService.save(model2entity(clientModel));

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

	// -----convertors
	private RegistrationData model2entity(RegistrationDataModel registrationDataModel) {
		RegistrationData e = new RegistrationData();
		e.setId(registrationDataModel.getId());
		e.setEmail(registrationDataModel.getEmail());
		e.setPassword(registrationDataModel.getPassword());
		e.setRole(model2entity(registrationDataModel.getRoleModel()));
		return e;
	}

	private RegistrationDataModel entity2model(RegistrationData registrationData) {
		RegistrationDataModel e = new RegistrationDataModel();
		e.setId(registrationData.getId());
		e.setEmail(registrationData.getEmail());
		e.setPassword(registrationData.getPassword());
		e.setRoleModel(entity2model(registrationData.getRole()));
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

	private RoleModel entity2model(Role role) {
		RoleModel e = new RoleModel();
		e.setId(role.getId());
		e.setNameRole(role.getNameRole());
		return e;
	}

	private Role model2entity(RoleModel roleModel) {
		Role e = new Role();
		e.setId(roleModel.getId());
		e.setNameRole(roleModel.getNameRole());
		return e;
	}

	private ClientRegistrationRoleModel entity2model(Client client, RegistrationData registrationData, Role role) {

		ClientRegistrationRoleModel clientRegistrationRoleModel = new ClientRegistrationRoleModel();

		clientRegistrationRoleModel.setClientModel(entity2model(client));
		clientRegistrationRoleModel.setRegistrationDataModel(entity2model(registrationData));
		clientRegistrationRoleModel.setRoleModel(entity2model(role));
		return null;
	}

}
