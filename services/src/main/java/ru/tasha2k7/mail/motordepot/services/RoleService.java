package ru.tasha2k7.mail.motordepot.services;

import ru.tasha2k7.mail.motordepot.datamodel.Role;

public interface RoleService extends AbstractService<Role>{
	
	Long getIdByNameRole(String role);
}
