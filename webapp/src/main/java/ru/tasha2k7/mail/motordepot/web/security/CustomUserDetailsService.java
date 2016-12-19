package ru.tasha2k7.mail.motordepot.web.security;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.tasha2k7.mail.motordepot.daoapi.IRegistrationDataDao;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Role;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	private IRegistrationDataDao registrationDataDao;
	
	@PostConstruct
	protected void init(){
		System.out.println();
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		RegistrationData registrationData = registrationDataDao.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

       // for (Role role : registrationData.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+registrationDataDao.getRoleName(email).toUpperCase()));
      //  }
        return new org.springframework.security.core.userdetails.User(registrationData.getEmail(), 
        		registrationData.getPassword(), grantedAuthorities);
	}

}
