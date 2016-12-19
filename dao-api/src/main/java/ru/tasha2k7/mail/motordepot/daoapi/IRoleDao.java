package ru.tasha2k7.mail.motordepot.daoapi;

import java.util.List;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

public interface IRoleDao extends IGenericDao<Role, Long> {
	
	List<RegistrationData> getAll(String role);

	List<RegistrationData> getAll(Long id);
	
	Long getIdByNameRole(String role);

}
