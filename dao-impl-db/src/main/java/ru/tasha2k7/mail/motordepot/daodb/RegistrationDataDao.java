package ru.tasha2k7.mail.motordepot.daodb;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

public interface RegistrationDataDao extends GenericDao<RegistrationData, Long> {

	RegistrationData findByEmail(String email);
	
	RegistrationData getRegistrationData(Long id);

}
