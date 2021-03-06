package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daoapi.ITripDao;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;
import ru.tasha2k7.mail.motordepot.services.TripService;

@Service
public class TripServiceImpl implements TripService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripServiceImpl.class);

	@Inject
	private ITripDao tripDao;

	@Override
	public Long save(Trip trip) {

		Trip existingTrip = tripDao.findRoute(trip.getPointDeparture(), trip.getDestination());

		if (existingTrip != null) {
			return existingTrip.getId();
		} else {
			if (trip.getId() == null) {
				Long id = tripDao.insert(trip);
				LOGGER.info("Trip created."); // id={}, ... ",
												// trip.getId(), ...
												// );
				return id;
			} else {
				tripDao.update(trip);
				return trip.getId();
			}
		}
	}

	@Override
	public void saveAll(List<Trip> trips) {
		for (Trip trip : trips) {
			save(trip);
		}
	}

	@Override
	public Trip getById(Long id) {
		return tripDao.getById(id);
	}

	@Override
	public List<Trip> getAll() {
		return tripDao.getAll();
	}

	@Override
	public void delete(Long id) {
		tripDao.delete(id);
	}

	@Override
	public Long findTotalRecords() {
		return tripDao.findTotalRecords();
	}

	@Override
	public Long getSequence() {
		return tripDao.getSequence();
	}

	@Override
	public Boolean findRoute(String departure, String destination) {

		Trip trip = tripDao.findRoute(departure, destination);

		if (trip != null) {
			return true;
		}
		return false;
	}

}
