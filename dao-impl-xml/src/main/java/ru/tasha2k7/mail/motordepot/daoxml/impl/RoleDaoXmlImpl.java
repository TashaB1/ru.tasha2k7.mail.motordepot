package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.thoughtworks.xstream.XStream;

import ru.tasha2k7.mail.motordepot.daoapi.IGenericDao;
import ru.tasha2k7.mail.motordepot.daoapi.IRoleDao;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;

@Repository
public class RoleDaoXmlImpl implements IRoleDao, IGenericDao<Role, Long> {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("role", Role.class);

		file = new File(basePath + "/role.xml");
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(),
					new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8")));
		}
	}

	@SuppressWarnings("unchecked")
	private List<Role> readCollection() {
		return (List<Role>) xstream.fromXML(file);
	}

	private void writeCollection(List<Role> newList) {
		try {
			xstream.toXML(newList, new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8")));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Role> allT) {
		return allT.isEmpty() ? 1l : allT.get(allT.size() - 1).getId() + 1;
	}

	@Override
	public List<RegistrationData> getAll(String role) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RegistrationData> getAll(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Role getById(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long insert(Role role) {
		List<Role> allRole = readCollection();
		Long id = getNextId(allRole);

		allRole.add(role);

		role.setId(new Long(id));

		writeCollection(allRole);
		return id;
	}

	@Override
	public void update(Role obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(Role obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Role> getAll() {
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

	@Override
	public Long getIdByNameRole(String role) {
		throw new UnsupportedOperationException();
	}

}
