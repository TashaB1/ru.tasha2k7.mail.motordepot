package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ApplicationServiceTest {
	
	@Inject
	private ApplicationService applicationService;
	
	
}
