package ru.tasha2k7.mail.motordepot.services;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

public interface RegistrationDataService extends AbstractService<RegistrationData> {

	RegistrationData findByEmail(String email);

	RegistrationData getRegistrationData(Long id);
	
	boolean validateEmailPassword(String email, String password);
	
	String getRoleName(String email);

}
