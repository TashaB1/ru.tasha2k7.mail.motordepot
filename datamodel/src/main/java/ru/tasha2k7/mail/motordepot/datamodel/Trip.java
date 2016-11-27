package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.List;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;

@DBTableName(name = "trip")
public class Trip extends AbstractModel {

	private String pointDeparture;
	private String destination;
	private Double mileageKm;

	private List<Application> application;

	public String getPointDeparture() {
		return pointDeparture;
	}

	public void setPointDeparture(String pointDeparture) {
		this.pointDeparture = pointDeparture;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getMileageKm() {
		return mileageKm;
	}

	public void setMileageKm(Double mileageKm) {
		this.mileageKm = mileageKm;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Trip [pointDeparture=" + pointDeparture + ", destination=" + destination + ", mileageKm=" + mileageKm
				+ "]";
	}
	
	

}
