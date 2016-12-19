package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Application;

public interface ApplicationService extends AbstractService<Application> {

	Boolean MatchingSpecificationsVehicle(Long appId, Long carId); // соответствие
																	// параметров
																	// груза
																	// характеристикам
																	// авто

	@Transactional
	void appoint(Long appId, Long driverId, Long dispatcherId); // назначить
																// заявку

//	@Transactional
//	void canceled(Long id); // отменить заявку

	@Transactional
	void changeStatus(String status, Long id); // отменить заявку "canceled"

	List<Application> getAll(String status); // для проверки

}
