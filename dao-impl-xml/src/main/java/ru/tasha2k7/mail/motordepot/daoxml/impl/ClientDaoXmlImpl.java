package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.thoughtworks.xstream.XStream;

import ru.tasha2k7.mail.motordepot.daoapi.IClientDao;
import ru.tasha2k7.mail.motordepot.daoapi.IGenericDao;
import ru.tasha2k7.mail.motordepot.datamodel.Client;

@Repository
public class ClientDaoXmlImpl implements IGenericDao<Client, Long>, IClientDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("client", Client.class);

		file = new File(basePath + "/client.xml");
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
		}
	}

	@SuppressWarnings("unchecked")
	private List<Client> readCollection() {
		return (List<Client>) xstream.fromXML(file);
	}

	private void writeCollection(List<Client> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Client> allT) {
		return allT.isEmpty() ? 1l : allT.get(allT.size() - 1).getId() + 1;
	}

	// -----
	public Long insert(Client client) {
		List<Client> allClient = readCollection();
		Long id = getNextId(allClient);

		allClient.add(client);

		client.setId(new Long(id));

		writeCollection(allClient);
		return id;
	}

	public List<Client> getAll() {
		return readCollection();
	}

	@Override
	public Client getById(Long id) {
		List<Client> allClient = readCollection();

		for (Client book : allClient) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void update(Client client) {
		List<Client> allClient = readCollection();
		int index = allClient.indexOf(client);

		if (index != -1) {
			allClient.set(index, client);
		}
		writeCollection(allClient);
	}

	@Override
	public void delete(Long id) {
		List<Client> allClient = readCollection();

		List<Client> newList = new ArrayList<>();
		// TODO: don't iterate whole collection
		for (Client client : allClient) {
			if (!client.getId().equals(id)) {
				newList.remove(client);
			}
		}
		writeCollection(newList);
	}

	@Override
	public void deleteAll(Client client) {
		List<Client> allClient = readCollection();
		allClient.clear();
		writeCollection(allClient);
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
	public void deleted(Long id, Date date) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Client findByName(String name) {
		throw new UnsupportedOperationException();
	}

}
