package ru.tasha2k7.mail.motordepot.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.tasha2k7.mail.motordepot.datamodel.Trip;


public interface TripService {
	@Transactional
	Long save(Trip trip);
	
	@Transactional
    void saveAll(List<Trip> trip);

}
