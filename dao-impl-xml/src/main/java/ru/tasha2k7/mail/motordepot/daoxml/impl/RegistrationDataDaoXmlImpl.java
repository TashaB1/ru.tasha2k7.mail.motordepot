package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thoughtworks.xstream.XStream;

import ru.tasha2k7.mail.motordepot.daoapi.IGenericDao;
import ru.tasha2k7.mail.motordepot.daoapi.IRegistrationDataDao;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

@Repository
public class RegistrationDataDaoXmlImpl 
		implements IRegistrationDataDao,IGenericDao<RegistrationData, Long> {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("registration", RegistrationData.class);

		file = new File(basePath + "/registrationdata.xml");
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@SuppressWarnings("unchecked")
	private List<RegistrationData> readCollection() {
		return (List<RegistrationData>) xstream.fromXML(file);
	}

	private void writeCollection(List<RegistrationData> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<RegistrationData> allT) {
		return allT.isEmpty() ? 1l : allT.get(allT.size() - 1).getId() + 1;
	}
	
	
	
	@Override
	public RegistrationData findByEmail(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RegistrationData getRegistrationData(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RegistrationData getAllRegistrationData(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getRoleName(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RegistrationData getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(RegistrationData registrationData) {
		List<RegistrationData> allRegistration = readCollection();
		Long id = getNextId(allRegistration);

		allRegistration.add(registrationData);

		registrationData.setId(new Long(id));

		writeCollection(allRegistration);
		return id;
	}

	@Override
	public void update(RegistrationData obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(RegistrationData obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RegistrationData> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long findTotalRecords() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getSequence() {
		throw new UnsupportedOperationException();
	}

}
