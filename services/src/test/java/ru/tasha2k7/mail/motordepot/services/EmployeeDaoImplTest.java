package ru.tasha2k7.mail.motordepot.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.daodb.ApplicationDao;
import ru.tasha2k7.mail.motordepot.daodb.EmployeeDao;
import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class EmployeeDaoImplTest {

	@Inject
	private EmployeeDao employeeDao;

	@Inject
	private ApplicationDao applicationDao;

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
