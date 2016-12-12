package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceTest {

	@Inject
	private ClientService clientService;
	
	@Inject
	private RegistrationDataService registrationDataService;

	@Test		
	public void getByIdTest() {
		Client client = clientService.getById(1l);

		Assert.assertNotNull("book for id=1 should not be null", client);
		Assert.assertEquals(new Long(1), client.getId());
	}
	
	@Transactional
	@Test
	public void saveTest() {
		
		RegistrationData registrationData = new RegistrationData();
		registrationData.setEmail("client" + String.valueOf((int)(Math.random()*100))+ "@mail.ru");
		registrationData.setPassword("123");
		Long registrationDataId = registrationDataService.save(registrationData);
		registrationData.setId(registrationDataId); //?
		
		Client client = new Client();
        client.setNameClient("client" + String.valueOf((int)(Math.random()*100)));
        client.setAddress("советская 3");
        client.setNumberPhone("444555666");
        client.setRegistrationData(registrationData);
        
        Long id = clientService.save(client);

        Assert.assertNotNull(id);

        Client clientFromDb = clientService.getById(id);

        Assert.assertEquals(client.getNameClient(), clientFromDb.getNameClient());
        
	}
}
