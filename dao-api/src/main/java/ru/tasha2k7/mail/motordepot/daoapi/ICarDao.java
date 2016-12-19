package ru.tasha2k7.mail.motordepot.daoapi;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.datamodel.Car;

public interface ICarDao extends IGenericDao<Car, Long> {
	
	Car SpecificationsVehicle(Long id);
	
	Boolean getcondition(Long id);
	
	void deleted(Long id, Date date);
	
	//не назначенные авто сделать!

}
