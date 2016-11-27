package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.RoleDao;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Inject
	private RoleDao roleDao;

	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public Long save(Role role) {
		if (role.getId() == null) {
			Long id = roleDao.insert(role);
			LOGGER.info("Role created."); // id={}, ... ",
											// application.getId(), ...
											// );
			return id;
		} else {
			roleDao.update(role);
			return role.getId();
		}
	}

	@Override
	public void saveAll(List<Role> roles) {
		for (Role role : roles) {
			save(role);
		}
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}


	
	

}
