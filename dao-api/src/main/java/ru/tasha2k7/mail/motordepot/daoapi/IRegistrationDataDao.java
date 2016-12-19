package ru.tasha2k7.mail.motordepot.daoapi;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

public interface IRegistrationDataDao extends IGenericDao<RegistrationData, Long> {

	RegistrationData findByEmail(String email);
	
	RegistrationData getRegistrationData(Long id);
	
	RegistrationData getAllRegistrationData(String email);
	
	String getRoleName(String email);

}
