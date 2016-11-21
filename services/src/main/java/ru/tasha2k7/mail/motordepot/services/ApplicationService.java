package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Application;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

public interface ApplicationService {
	
	@Transactional
	Long save(Application application);
	
	@Transactional
    void saveAll(List<Application> applications);
	
	Boolean MatchingSpecificationsVehicle(Long appId, Long carId);
	
	void appoint(Employee employee);  //назначить
	
	void canceled(Long id);		//отменить		
		
}
