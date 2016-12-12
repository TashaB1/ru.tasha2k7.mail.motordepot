package ru.tasha2k7.mail.motordepot.services;

import ru.tasha2k7.mail.motordepot.datamodel.Client;

public interface ClientService extends AbstractService<Client>{

	Long Registration(Client client);
	
}
