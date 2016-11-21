package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

public interface RegistrationDataService {

	@Transactional
	Long save(RegistrationData registrationData);

	@Transactional
	void saveAll(List<RegistrationData> registrationData);
}
