package ru.tasha2k7.mail.motordepot.daoapi;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.datamodel.Client;

public interface IClientDao extends IGenericDao<Client, Long> {
	
	void deleted(Long id, Date date);
	
	Client findByName(String name);

}
