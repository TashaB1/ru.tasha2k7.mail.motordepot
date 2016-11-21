package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Role;

public interface RoleService {
	@Transactional
	Long save(Role role);
	
	@Transactional
    void saveAll(List<Role> role);
	
	Role getById(Long id);
}
