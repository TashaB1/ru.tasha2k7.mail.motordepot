package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;
import ru.tasha2k7.mail.motordepot.datamodel.Role;

public interface ApplicationService {

	@Transactional
	Long save(Application application);

	@Transactional
	void saveAll(List<Application> applications);

	Boolean MatchingSpecificationsVehicle(Long appId, Long carId); // соответствие
																	// параметров
																	// груза
																	// характеристикам
																	// авто

	@Transactional
	void appoint(Long appId, Long driverId, Long dispatcherId); // назначить
																// заявку

	@Transactional
	void canceled(Long id); // отменить заявку

	List<Application> getAll(); // для проверки

	List<Application> getAll(String name); // для проверки

}
