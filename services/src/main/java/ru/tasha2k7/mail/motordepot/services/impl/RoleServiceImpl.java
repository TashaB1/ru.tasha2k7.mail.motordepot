package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daoapi.IRoleDao;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Inject
	private IRoleDao roleDao;

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

	@Override
	public void delete(Long id) {
		roleDao.delete(id);

	}

	@Override
	public Long findTotalRecords() {
		return roleDao.findTotalRecords();
	}

	@Override
	public Long getSequence() {
		return roleDao.getSequence();
	}

	@Override
	public Long getIdByNameRole(String role) {
		return roleDao.getIdByNameRole(role);
	}

}
