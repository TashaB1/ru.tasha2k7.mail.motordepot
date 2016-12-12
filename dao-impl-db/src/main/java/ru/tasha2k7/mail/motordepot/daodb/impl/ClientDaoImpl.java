package ru.tasha2k7.mail.motordepot.daodb.impl;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.ClientDao;
import ru.tasha2k7.mail.motordepot.daodb.mapper.ClientMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao{

	public ClientDaoImpl() {
		super(Client.class, "client", ClientMapper.class);
	}
	
	

}
