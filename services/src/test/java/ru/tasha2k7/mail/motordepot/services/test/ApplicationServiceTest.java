package ru.tasha2k7.mail.motordepot.services.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;
import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;
import ru.tasha2k7.mail.motordepot.services.ApplicationService;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.TripService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ApplicationServiceTest {

	@Inject
	private ApplicationService applicationService;
	
	@Inject
	private ClientService clientService;
	
	@Inject
	private TripService tripService;
		
	/**
	 * 
	 */
	
	@Test
	public void insertTest() {		
		
		Date date = new Date();
		
		Application application = new Application();
		application.setNumberApplication(applicationService.getSequence()+1);
		application.setDateApplication(new Timestamp(date.getTime()));
		application.setClient(clientService.getById(1l));		
		application.setTrip(tripService.getById(1l));
		application.setWeightCargoKg(500.0);
		application.setLengthCargoM(6.0);
		application.setWidthCargoM(3.0);
		application.setHeigthCargoM(5.0);
		application.setBeginningTripMark(null);
		application.setDeliveryCargoMark(null);
		application.setEndingTripMark(null);
		application.setDispatcherId(null);
		application.setDriverId(null);
		application.setNote(null);
		application.setStatus(ApplicationStatus.notDistributed);
		
		Long id = applicationService.save(application);

		
		Assert.assertNotNull(id);
		Application applicationFromDb = applicationService.getById(id);
		Assert.assertEquals(application.getNumberApplication(), applicationFromDb.getNumberApplication());
	}	
	
	@Test
	public void updateTest() {		
		
		Date date = new Date();
		Long idUpdate = 3l;
		
		Application oldApplication = applicationService.getById(idUpdate);		
		
		Application application = new Application();
		application.setId(idUpdate);
		application.setNumberApplication(idUpdate);
		application.setDateApplication(new Timestamp(date.getTime()));
		application.setClient(clientService.getById(oldApplication.getClientId()));		
		application.setTrip(tripService.getById(oldApplication.getTripId()));
		application.setWeightCargoKg(500.0);
		application.setLengthCargoM(6.0);
		application.setWidthCargoM(3.0);
		application.setHeigthCargoM(5.0);
		application.setBeginningTripMark(null);
		application.setDeliveryCargoMark(null);
		application.setEndingTripMark(null);
		application.setDispatcherId(null);
		application.setDriverId(null);
		application.setNote(null);
		application.setStatus(ApplicationStatus.notDistributed);
		
		Long id = applicationService.save(application);
		
		Assert.assertNotNull(id);
		Application applicationFromDb = applicationService.getById(id);
		Assert.assertEquals(application.getNumberApplication(), applicationFromDb.getNumberApplication());
	}	
	
	@Test
	public void getAllTest() {
		List<Application> applications = applicationService.getAll();		
		Assert.assertNotNull(applications);
	}

	@Test
	public void getAllByStatusTest() {
		List<Application> applicationsByStatus = applicationService.getAll(ApplicationStatus.distributed.name());
		//System.out.println(applicationService.getAll("distributed").toString());
		
		Assert.assertNotNull(applicationsByStatus);
	}

	@Test
	public void changeStatusTest() {
		applicationService.changeStatus(ApplicationStatus.canceled.name(), 2l);
		
		Application applicationFromDb = applicationService.getById(2l);
		
		Assert.assertEquals(ApplicationStatus.canceled, applicationFromDb.getStatus());
	}

	@Test
	public void appointTest() {
		applicationService.appoint(1l, 2l, 1l);
		
		Application applicationFromDb = applicationService.getById(1l);
		
		Assert.assertNotNull(applicationFromDb.getDriverId());
		Assert.assertNotNull(applicationFromDb.getDispatcherId());
	}
	
	
	@Test
	public void MatchingSpecificationsVehicleTest() {
		Boolean answer = applicationService.MatchingSpecificationsVehicle(1l, 1l);
		
		Assert.assertTrue(answer);
	}

}
