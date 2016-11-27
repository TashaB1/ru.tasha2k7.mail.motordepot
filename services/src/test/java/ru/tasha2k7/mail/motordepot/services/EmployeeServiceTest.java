package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class EmployeeServiceTest {
	@Inject
	private EmployeeService employeeService;

	@Test		
	public void appointedCarTest() {
		Boolean answer = employeeService.appointedCar(2l);
		System.out.println(answer);
	}
	
	
	@Test		
	public void emptyDriverTest() {
		Boolean answer = employeeService.emptyDriver(2l);
		System.out.println(answer);
	}
}
