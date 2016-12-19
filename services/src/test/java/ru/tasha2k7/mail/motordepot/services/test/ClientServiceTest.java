package ru.tasha2k7.mail.motordepot.services.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.services.RoleService;
import ru.tasha2k7.mail.motordepot.services.impl.ClientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Inject
	private ClientService clientService;

	@Inject
	private RegistrationDataService registrationDataService;

	@Inject
	private RoleService roleService;

	@Test
	public void getByIdTest() {
		Client client = clientService.getById(1l);

		Assert.assertNotNull(client);
		Assert.assertEquals(new Long(1), client.getId());
	}

	@Test
	public void getAllTest() {
		List<Client> clients = clientService.getAll();
		// System.out.println(clientService.getAll().toString());

		Assert.assertNotNull(clients);
	}

	@Test
	public void insertTest() {

		RegistrationData registrationData = new RegistrationData();
		registrationData.setEmail("client" + String.valueOf(registrationDataService.getSequence() + 1) + "@mail.ru");
		registrationData.setPassword("123");
		registrationData.setRole(roleService.getById(4l));
		Long registrationDataId = registrationDataService.save(registrationData);
		registrationData.setId(registrationDataId);

		Client client = new Client();
		client.setNameClient("client" + String.valueOf(clientService.getSequence() + 1));
		client.setAddress("советская 3");
		client.setNumberPhone("444555666");
		client.setRegistrationData(registrationData);
		Long id = clientService.save(client);

		Assert.assertNotNull(registrationDataId);
		Assert.assertNotNull(id);

		RegistrationData registrationDataFromDb = registrationDataService.getById(registrationDataId);
		Client clientFromDb = clientService.getById(id);

		Assert.assertEquals(registrationData.getEmail(), registrationDataFromDb.getEmail());
		Assert.assertEquals(client.getNameClient(), clientFromDb.getNameClient());
	}

	@Test
	public void updateTest() {

		Long idUpdate = 1l;
		
		Client oldClient = clientService.getById(idUpdate);		
		LOGGER.info("Client to update: " + oldClient.toString());
		RegistrationData regdata = registrationDataService.getById(oldClient.getRegistrationDataId());

		Client client = new Client();
		client.setId(idUpdate);
		client.setNameClient("client" + String.valueOf(clientService.getSequence() + 1)+ "_1");
		client.setAddress("cool 2");
		client.setNumberPhone("444555666");
		client.setRegistrationData(regdata);
		client.setDeleted(null);

		Long id = clientService.save(client);
		LOGGER.info("Client after update: " + client.toString());


		Assert.assertNotNull(id);

		Client clientFromDb = clientService.getById(id);

		Assert.assertEquals(client.getNameClient(), clientFromDb.getNameClient());

	}

	@Test
	public void deleteTest() {

		Role role = roleService.getById(4l);

		RegistrationData registrationData = new RegistrationData();
		registrationData.setEmail("client" + String.valueOf(registrationDataService.getSequence() + 1) + "1@mail.ru");
		registrationData.setPassword("123");
		registrationData.setRole(role); // ???
		registrationData.setRoleId(4l);
		Long registrationDataId = registrationDataService.save(registrationData);
		registrationData.setId(registrationDataId); // ?

		Client client = new Client();
		client.setNameClient("client" + String.valueOf(clientService.getSequence() + 1));
		client.setAddress("советская 3");
		client.setNumberPhone("444555666");
		client.setRegistrationData(registrationData);
		client.setRegistrationDataId(registrationDataId);

		Long id = clientService.save(client);

		if (id != null && registrationDataId != null) {

			clientService.delete(id);
			registrationDataService.delete(registrationDataId);

			LOGGER.info("Client to delete: " + id + " with registration data: " + registrationDataId);
		}

		// Assert.assertNull(clientService.getById(id));
		// Assert.assertNull(registrationDataService.getById(registrationDataId));
	}

	@Test
	public void deletedTest() {

		Date date = new Date();
		// System.out.println(new Timestamp(date.getTime()));

		clientService.deleted(1l, new Timestamp(date.getTime()));

		Assert.assertNotNull(clientService.getById(1l).getDeleted());
	}
	
	@Test
	public void findByNameTest() {
		
	}

}
