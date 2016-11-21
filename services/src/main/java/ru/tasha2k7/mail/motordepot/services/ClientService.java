package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import ru.tasha2k7.mail.motordepot.datamodel.Client;

public interface ClientService {

	@Transactional
	Long save(Client client);
	
	@Transactional
    void saveAll(List<Client> client);
	
	Long Registration(Client client);
	
	Client getById(Long id);

	
}
