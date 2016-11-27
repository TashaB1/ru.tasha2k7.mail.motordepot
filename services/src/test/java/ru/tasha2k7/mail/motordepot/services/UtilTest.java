package ru.tasha2k7.mail.motordepot.services;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.tasha2k7.mail.motordepot.daodb.util.CreateDropNewSchema;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class UtilTest {
	
	@Inject
	private CreateDropNewSchema createDropNewSchema;
	
	@Test
	public void CreateSchemaTest() {
		createDropNewSchema.CreateSchema("motordepot_postgres_create_test.sql");
	}
}
