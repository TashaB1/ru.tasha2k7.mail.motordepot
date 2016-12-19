package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import com.thoughtworks.xstream.XStream;
import ru.tasha2k7.mail.motordepot.annotation.analyzer.DBTableNameAnalyzer;
import ru.tasha2k7.mail.motordepot.daoapi.IGenericDao;

public abstract class GenericDaoXmlImpl<T, PK extends Serializable> implements IGenericDao<T, PK> {

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	private String dbTableName = new DBTableNameAnalyzer().getDBTableName(this.getGenericEntityClass());

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct        
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias(dbTableName, this.getGenericEntityClass()); 

		file = new File(basePath + "/" + dbTableName + ".xml");  
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private List<T> readCollection() {
        return (List<T>) xstream.fromXML(file);
    }

    @SuppressWarnings("unused")
	private void writeCollection(List<T> newList) {
        try {
            xstream.toXML(newList, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);// TODO custom exception
        }
    }

//    private long getNextId(List<T> allT) {
//        return allT.isEmpty() ? 1l : allT.get(allT.size() - 1).getId() + 1;
//    }    
    

	@Override
	public T getById(PK id) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK insert(T obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(T obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(PK id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(T obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> getAll() {
		return readCollection();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK findTotalRecords() {
		throw new UnsupportedOperationException();
	}

}
