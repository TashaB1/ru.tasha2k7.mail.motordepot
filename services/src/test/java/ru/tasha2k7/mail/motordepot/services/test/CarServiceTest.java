package ru.tasha2k7.mail.motordepot.services.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.services.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class CarServiceTest {

	@Inject
	private CarService carService;

	@Test
	public void deletedTest() {
		Date date = new Date();
		carService.deleted(2l, new Timestamp(date.getTime()));
		Assert.assertNotNull(carService.getById(1l).getDeleted());
	}

	@Test
	public void insertTest() {
		
		Date date = new Date();

		Car car = new Car();
		car.setMakeModel("MAN");
		car.setNumberRegistration("AA5667-4 "+ String.valueOf(carService.getSequence()));
		car.setCapacityCarryingKg(7000.0);
		car.setLengthDimensionsM(13.6);
		car.setWidthDimensionsM(2.45);
		car.setHeigthDimensionsM(2.45);
		car.setConditionVehical(true);
		car.setInspectionDate(new Timestamp(date.getTime()));
		car.setDeleted(null);
		
		Long id = carService.save(car);
		
		Assert.assertNotNull(id);
		
		Car carFromDb = carService.getById(id);
		
		Assert.assertEquals(car.getNumberRegistration(),carFromDb.getNumberRegistration());

	}
	
	@Test
	public void updateTest() {
		
		Date date = new Date();
		
		Long idUpdate = 5l;
		
		Car car = new Car();
		car.setId(idUpdate);
		car.setMakeModel("Honda");
		car.setNumberRegistration("AA2754-4");
		car.setCapacityCarryingKg(7000.0);
		car.setLengthDimensionsM(13.6);
		car.setWidthDimensionsM(2.45);
		car.setHeigthDimensionsM(2.45);
		car.setConditionVehical(true);
		car.setInspectionDate(new Timestamp(date.getTime()));
		car.setDeleted(null);
		
		Long id = carService.save(car);
		
		Assert.assertNotNull(id);
		
		Car carFromDb = carService.getById(id);
		
		Assert.assertEquals(car.getNumberRegistration(),carFromDb.getNumberRegistration());

	}
	
	@Test
	public void getByIdTest() {
		Car car = carService.getById(1l);

		Assert.assertNotNull(car);
		Assert.assertEquals(new Long(1), car.getId());
	}

	@Test
	public void getAllTest() {
		List<Car> car = carService.getAll();		
		Assert.assertNotNull(car);
	}
}
