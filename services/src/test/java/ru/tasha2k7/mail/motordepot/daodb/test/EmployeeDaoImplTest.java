package ru.tasha2k7.mail.motordepot.daodb.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.tasha2k7.mail.motordepot.daoapi.IEmployeeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class EmployeeDaoImplTest {

	@Inject
	private IEmployeeDao employeeDao;

	@Test
	public void getAllByPositionTest() {
		employeeDao.getAllByPosition("driver");
		System.out.println(employeeDao.getAllByPosition("driver").toString());
	}

	@Test
	public void getAllIdByPositionTest() {
		employeeDao.getAllIdByPosition("driver");
		System.out.println(employeeDao.getAllIdByPosition("driver").toString());
	}
}
