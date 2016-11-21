package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.ClientDao;
import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Inject
    private ClientDao clientDao;

    @Override
    public Client getById(Long id) {
        return clientDao.getById(id);
    }

	@Override
	public Long Registration(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long save(Client client) {
		if (client.getId() == null) {
			Long id = clientDao.insert(client);
			LOGGER.info("Client created."); // id={}, ... ",
													// application.getId(), ...
													// );
			return id;
		} else {
			clientDao.update(client);
			return client.getId();
		}
	}

	@Override
	public void saveAll(List<Client> clients) {
		for (Client client : clients) {
			save(client);
		}
	}
}
