package ru.tasha2k7.mail.motordepot.daodb.util;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateDropNewSchema {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public void CreateSchema(String sqlFile){
	/*ProcessBuilder pb = new ProcessBuilder("C:/Program Files/PostgreSQL/9.3/bin/psql.exe", "-h", "localhost", "-p", "5432" , "-U", "postgres", "-d", "motordepot", "-f", sqlFile);
		try {
			pb.start();
		} catch (IOException e) {
			System.out.println("не создана!");
			e.printStackTrace();
		}*/
		
	jdbcTemplate.execute(sqlFile);
	}
}
