package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.EmployeeDao;
import ru.tasha2k7.mail.motordepot.daodb.RegistrationDataDao;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;
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
														// application.getId(),
														// ...
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

	@Override
	public RegistrationData findByEmail(String email) {
		return registrationDataDao.findByEmail(email);
	}

	@Override
	public RegistrationData getRegistrationData(Long id) {
		return registrationDataDao.getRegistrationData(id);
	}

	@Override
	public RegistrationData getById(Long id) {
		return registrationDataDao.getById(id);
	}

	@Override
	public List<RegistrationData> getAll() {
		return registrationDataDao.getAll();
	}

	@Override
	public void delete(Long id) {
		registrationDataDao.delete(id);
	}

	@Override
	public boolean validateEmailPassword(String email, String password) {

		RegistrationData registrationData = registrationDataDao.findByEmail(email);

		if (registrationData != null) {
			if (password.equals(registrationData.getPassword())) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	@Override
	public String getRoleName(String email) {
		return registrationDataDao.getRoleName(email);
	}

}
