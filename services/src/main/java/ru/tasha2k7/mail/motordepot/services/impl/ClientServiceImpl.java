package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daoapi.IClientDao;
import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Inject
	private IClientDao clientDao;

	@Override
	public Client getById(Long id) {
		//LOGGER.info("Get client by " + id + ".");
		return clientDao.getById(id);
	}

	@Override
	public Long save(Client client) {
		if (client.getId() == null) {
			Long id = clientDao.insert(client);
			LOGGER.info("Client created: " + client.toString());
			return id;
		} else {
			clientDao.update(client);
			LOGGER.info("Client update: " + client.toString());
			return client.getId();
		}
	}

	@Override
	public void saveAll(List<Client> clients) {
		for (Client client : clients) {
			save(client);
			LOGGER.info("Saved all clients: " + client.toString());
		}
	}

	@Override
	public List<Client> getAll() {
		//LOGGER.info("Get all clients.");
		return clientDao.getAll();
		
	}

	@Override
	public void delete(Long id) {
		clientDao.delete(id);
		LOGGER.info("Client delete."); 
	}

	@Override
	public Long findTotalRecords() {
		return clientDao.findTotalRecords();
	}

	@Override
	public Long getSequence() {
		return clientDao.getSequence();
	}

	@Override
	public void deleted(Long id, Date date) {
		LOGGER.info("Client " +  id + " deleted " + date);
		clientDao.deleted(id, date);

	}

	@Override
	public Client findByName(String name) {
		return clientDao.findByName(name);
	}

}
