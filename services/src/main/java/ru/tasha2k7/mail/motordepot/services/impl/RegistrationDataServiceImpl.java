package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.RegistrationDataDao;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;

@Service
public class RegistrationDataServiceImpl implements RegistrationDataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDataServiceImpl.class);

	@Inject
	private RegistrationDataDao registrationDataDao;

	@Override
	public Long save(RegistrationData registrationData) {
		if (registrationData.getId() == null) {
			Long id = registrationDataDao.insert(registrationData);
			LOGGER.info("Registration data created."); // id={}, ... ",
													// application.getId(), ...
													// );
			return id;
		} else {
			registrationDataDao.update(registrationData);
			return registrationData.getId();
		}
	}

	@Override
	public void saveAll(List<RegistrationData> registrationDataAll) {
		for (RegistrationData registrationData : registrationDataAll) {
			save(registrationData);
		}
	}

}
