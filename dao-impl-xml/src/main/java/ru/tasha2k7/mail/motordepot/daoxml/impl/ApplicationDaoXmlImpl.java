package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.thoughtworks.xstream.XStream;
import ru.tasha2k7.mail.motordepot.daoapi.IApplicationDao;
import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Application.ApplicationStatus;

@Repository
public class ApplicationDaoXmlImpl extends GenericDaoXmlImpl<Application, Long> implements IApplicationDao {

//	 private XStream xstream;
//	 private File file;
//
//	 @Value("${basePath}")
//	 private String basePath;
//	 
//	 @PostConstruct
//	    private void intialize() throws IOException {
//	        // TODO move to the parent class
//	        // TODO refactoring: use classname instead of hardcoded filename
//	        xstream = new XStream();
//	        xstream.alias("application", Application.class);
//
//	        file = new File(basePath + "/Applications.xml");
//	        if (!file.exists()) {
//	            FileUtils.forceMkdir(file.getParentFile());
//	            file.createNewFile();
//	            xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
//	        }
//	    }
	
	@Override
	public List<Application> getAllByClientId(Long clientId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Application> getAllByDriverId(Long driverId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Application> getAllByDispatcherId(Long dispatcherId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Application> getAllByTripId(Long tripId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Application> getAllByStatusApplication(String status) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Application SpecificationsCargo(Long Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Application> getAll(String status) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changeStatus(String status, Long appId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Long> getAllIdAppointedDriver(String status) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void appointApplication(Long appId, Long driverId, Long dispatcherId, String status) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Long getSequence() {
		throw new UnsupportedOperationException();
	}

}
