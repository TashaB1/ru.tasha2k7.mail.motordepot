package ru.tasha2k7.mail.motordepot.daodb;

import java.util.List;

import ru.tasha2k7.mail.motordepot.datamodel.Application;

public interface ApplicationDao extends GenericDao<Application, Long> {

	List<Application> getAllByClientId(Long clientId);

	List<Application> getAllByDriverId(Long driverId);

	List<Application> getAllByDispatcherId(Long dispatcherId);

	List<Application> getAllByTripId(Long tripId);

	Application SpecificationsCargo(Long Id);

	List<Application> getAllByStatusApplication(Application.ApplicationStatus status); // получить
																						// заявки
																						// с
																						// определенным
																						// статусом

	List<Application> getAll(String status);
	
	void changeStatus(String status, Long appId);
	
	List<Long> getAllIdAppointedDriver(String status);  // id назначенных водителей

	void appointApplication(Long appId, Long driverId, Long dispatcherId, String status);
}