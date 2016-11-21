package ru.tasha2k7.mail.motordepot.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.tasha2k7.mail.motordepot.daodb.TripDao;
import ru.tasha2k7.mail.motordepot.datamodel.Trip;
import ru.tasha2k7.mail.motordepot.services.TripService;

@Service
public class TripServiceImpl implements TripService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripServiceImpl.class);

	@Inject
	private TripDao tripDao;

	@Override
	public Long save(Trip trip) {
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

	@Override
	public void saveAll(List<Trip> trips) {
		for (Trip trip : trips) {
			save(trip);
		}
	}

}
