package ru.tasha2k7.mail.motordepot.services;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Client;

public interface ClientService extends AbstractService<Client> {

	@Transactional
	void deleted(Long id, Date date);
	
	Client findByName(String name);
}
