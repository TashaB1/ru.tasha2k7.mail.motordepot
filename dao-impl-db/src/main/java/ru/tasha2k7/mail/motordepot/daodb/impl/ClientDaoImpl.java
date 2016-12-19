package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daoapi.IClientDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.ClientMapper;
import ru.tasha2k7.mail.motordepot.daodb.mapper.RegistrationDataMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements IClientDao {

	public ClientDaoImpl() {
		super(Client.class, "client", ClientMapper.class);
	}

	@Inject
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public void deleted(Long id, Date date) {
		jdbcTemplate.update("update client set deleted=? where id=?", date, id);		
	}


	@Override
	public Client findByName(String name) {
		return jdbcTemplate.queryForObject("select * from client where name_client = ?", new Object[] { name },
				new ClientMapper());
	}

}
