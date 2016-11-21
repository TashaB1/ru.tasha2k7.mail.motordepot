package ru.tasha2k7.mail.motordepot.daodb.impl;

import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.daodb.RoleDao;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class, "role");
	}

}
