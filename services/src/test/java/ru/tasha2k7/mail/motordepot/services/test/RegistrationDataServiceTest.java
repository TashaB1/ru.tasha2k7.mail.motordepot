package ru.tasha2k7.mail.motordepot.services.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.services.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RegistrationDataServiceTest {
	@Inject
	private RegistrationDataService registrationDataService;

	@Inject
	private RoleService roleService;

	@Test
	public void saveTest() {
		RegistrationData registrationData = new RegistrationData();
		registrationData.setEmail("client" + String.valueOf(registrationDataService.getSequence()+1));
		registrationData.setPassword("123");
		registrationData.setRole(roleService.getById(4l)); // ???
		Long id = registrationDataService.save(registrationData);

		Assert.assertNotNull(id);

		RegistrationData registrationDataFromDb = registrationDataService.getById(id);

		Assert.assertEquals(registrationData.getEmail(), registrationDataFromDb.getEmail());

	}

	@Test
	public void getAllTest() {

	}

}
