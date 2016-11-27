package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ApplicationServiceTest {

	@Inject
	private ApplicationService applicationService;

	@Test
	// @Ignore
	public void getAllTest() {
		applicationService.getAll();
		System.out.println(applicationService.getAll().toString());
	}

	@Test
	public void getByStatusTest() {
		applicationService.getAll("distributed");
		System.out.println(applicationService.getAll("distributed").toString());
	}

	@Test
	public void getAllByStatusApplicationTest() {
		applicationService.getAll("distributed");
		System.out.println(applicationService.getAll("distributed").toString());
	}

	@Test
	public void canceledTest() {
		applicationService.canceled(2l);
	}

	@Test
	public void appointTest() {
		applicationService.appoint(1l, 2l, 1l);
	}
	
	
	@Test
	public void MatchingSpecificationsVehicleTest() {
		Boolean answer = applicationService.MatchingSpecificationsVehicle(1l, 1l);
		System.out.println(answer);
	}

}
