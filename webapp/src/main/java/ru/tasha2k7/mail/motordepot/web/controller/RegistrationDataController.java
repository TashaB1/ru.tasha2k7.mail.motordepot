package ru.tasha2k7.mail.motordepot.web.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.services.RoleService;
import ru.tasha2k7.mail.motordepot.web.model.RegistrationDataModel;
import ru.tasha2k7.mail.motordepot.web.model.RegistrationRoleModel;
import ru.tasha2k7.mail.motordepot.web.model.RoleModel;

@RestController
@RequestMapping("/registrationdata")
public class RegistrationDataController {

	@Inject
	private RegistrationDataService registrationDataService;

	@Inject
	private RoleService roleService;

	/*
	 * @RequestMapping(value = "/{mail}", method = RequestMethod.GET) public
	 * ResponseEntity<RegistrationDataModel> getByMail(@PathVariable String
	 * mail) { RegistrationData registrationData =
	 * registrationDataService.findByEmail(mail); return new
	 * ResponseEntity<RegistrationDataModel>(entity2model(registrationData),
	 * HttpStatus.OK); }
	 */

	@RequestMapping(value = "/{registrationDataId}", method = RequestMethod.GET)
	public ResponseEntity<RegistrationDataModel> getById(@PathVariable Long registrationDataId) {

		RegistrationData registrationData = registrationDataService.getById(registrationDataId);
		Role role = roleService.getById(registrationData.getRoleId());
		registrationData.setRole(role);

		return new ResponseEntity<RegistrationDataModel>(entity2model(registrationData), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewRegistrationData(@RequestBody RegistrationRoleModel registrationRoleModel) {

		RoleModel roleModel = registrationRoleModel.getRoleModel();
		RegistrationDataModel registrationDataModel = registrationRoleModel.getRegistrationDataModel();

		Long roleId = roleService.getIdByNameRole(roleModel.getNameRole());
		roleModel.setId(roleId);
		
		registrationDataModel.setRoleModel(roleModel);
		registrationDataService.save(model2entity(registrationDataModel));

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{registrationDataId}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateRegistrationData(@RequestBody RegistrationRoleModel registrationRoleModel,
			@PathVariable Long registrationDataId) {

		RoleModel roleModel = registrationRoleModel.getRoleModel();
		RegistrationDataModel registrationDataModel = registrationRoleModel.getRegistrationDataModel();

		Long roleId = roleService.getIdByNameRole(roleModel.getNameRole());
		roleModel.setId(roleId);
		
		registrationDataModel.setRoleModel(roleModel);
		registrationDataModel.setId(registrationDataId);

		RegistrationData registrationData = model2entity(registrationDataModel);
		registrationDataService.save(registrationData);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{registrationDataId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long registrationDataId) {
		registrationDataService.delete(registrationDataId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	// ===
	private RegistrationDataModel entity2model(RegistrationData registrationData) {
		RegistrationDataModel e = new RegistrationDataModel();
		e.setId(registrationData.getId());
		e.setEmail(registrationData.getEmail());
		e.setPassword(registrationData.getPassword());
		e.setRoleModel(entity2model(registrationData.getRole()));
		return e;
	}

	private RegistrationData model2entity(RegistrationDataModel registrationDataModel) {
		RegistrationData e = new RegistrationData();
		e.setId(registrationDataModel.getId());
		e.setEmail(registrationDataModel.getEmail());
		e.setPassword(registrationDataModel.getPassword());
		e.setRole(model2entity(registrationDataModel.getRoleModel()));
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

}
