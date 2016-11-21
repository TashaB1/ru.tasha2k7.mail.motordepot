package ru.tasha2k7.mail.motordepot.daodb;

import ru.tasha2k7.mail.motordepot.datamodel.Car;

public interface CarDao extends GenericDao<Car, Long> {
	
	Car SpecificationsVehicle(Long id);
	
	Boolean getcondition(Long id);

}
