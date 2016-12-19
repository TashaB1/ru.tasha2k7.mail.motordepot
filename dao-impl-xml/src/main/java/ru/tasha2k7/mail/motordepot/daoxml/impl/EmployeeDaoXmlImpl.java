package ru.tasha2k7.mail.motordepot.daoxml.impl;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tasha2k7.mail.motordepot.daoapi.IEmployeeDao;
import ru.tasha2k7.mail.motordepot.datamodel.Employee;

@Repository
public class EmployeeDaoXmlImpl extends GenericDaoXmlImpl<Employee, Long> implements IEmployeeDao {

	@Override
	public List<Employee> getAllByPosition(String position) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Long> getAllIdByPosition(String position) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void appointCar(Long driverId, Long carId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getCarIdByDriverId(Long driverId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getSequence() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleted(Long id, Date date) {
		throw new UnsupportedOperationException();

	}

}
