package ru.tasha2k7.mail.motordepot.services.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.services.ApplicationService;
import ru.tasha2k7.mail.motordepot.services.CarService;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.services.RoleService;
import ru.tasha2k7.mail.motordepot.services.TripService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class GeneralServiceTest {

	@Inject
	private ApplicationService applicationService;	
	
	@Inject
	private EmployeeService employeeService;
	
	@Inject
	private ClientService clientService;

	@Inject
	private RegistrationDataService registrationDataService;

	@Inject
	private RoleService roleService;
	
	@Inject
	private CarService carService;
	
	@Inject
	private TripService tripService;
	
	
	@Test   //добавляем диспетчера
	public void Test() {
		
		
		
	}
	
	
	
}
