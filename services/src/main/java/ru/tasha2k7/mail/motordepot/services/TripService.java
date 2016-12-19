package ru.tasha2k7.mail.motordepot.services;

import ru.tasha2k7.mail.motordepot.datamodel.Trip;

public interface TripService extends AbstractService<Trip> {
	
	Boolean findRoute(String departure, String destination);
}
