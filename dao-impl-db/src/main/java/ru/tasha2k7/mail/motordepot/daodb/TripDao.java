package ru.tasha2k7.mail.motordepot.daodb;

import ru.tasha2k7.mail.motordepot.datamodel.Trip;

public interface TripDao extends GenericDao<Trip, Long>{

	//расчет километража автоматически при помощи gps, gps-глонасс
	
}
