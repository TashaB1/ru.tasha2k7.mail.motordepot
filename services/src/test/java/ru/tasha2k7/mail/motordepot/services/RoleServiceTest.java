package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RoleServiceTest {
	@Inject
	private RoleService roleService;

	@Test
	@Ignore
	public void saveTest() {
		Role role = new Role();
		role.setNameRole("proba");
		Long id = roleService.save(role);
		role.setId(id);
		
		Assert.assertNotNull(id);

		Role roleFromDb = roleService.getById(id);

		Assert.assertEquals(role.getNameRole(), roleFromDb.getNameRole());

	}
	
	
	@Test
	@Ignore
	public void getAllTest() {
		roleService.getAll();
		System.out.println(roleService.getAll().toString());
	}
	
	

}
