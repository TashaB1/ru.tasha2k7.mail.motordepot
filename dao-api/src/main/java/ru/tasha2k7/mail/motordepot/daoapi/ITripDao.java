package ru.tasha2k7.mail.motordepot.daoapi;

import ru.tasha2k7.mail.motordepot.datamodel.Trip;

public interface ITripDao extends IGenericDao<Trip, Long>{

	//расчет километража автоматически при помощи gps, gps-глонасс,  Google Map API
	
	Trip findRoute(String departure, String destination);  //поиск маршрута в базе
}
