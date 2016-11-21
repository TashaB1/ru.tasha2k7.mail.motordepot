package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;

@DBTableName(name = "application")
public class Application extends AbstractModel {

	public enum ApplicationStatus {
		distributed, // распределена
		notDistributed, // нераспределена
		executed, // исполнена
		notExecuted, // неисполнена
		canceled // отменена
	}

	private Long numberApplication;
	private Date dateApplication;
	private Long clientId;
	private Long tripId;
	private Double weightCargoKg;
	private Double lengthCargoM;
	private Double widthCargoM;
	private Double heigthCargoM;
	private Date beginningTripMark;
	private Date deliveryCargoMark;
	private Date endingTripMark;
	private Long dispatcherId;
	private Long driverId;
	private String note;
	private ApplicationStatus status;

	private Client client;
	private Trip trip;
	private Employee employee;

	public Long getNumberApplication() {
		return numberApplication;
	}

	public void setNumberApplication(Long numberApplication) {
		this.numberApplication = numberApplication;
	}

	public Date getDateApplication() {
		return dateApplication;
	}

	public void setDateApplication(Date dateApplication) {
		this.dateApplication = dateApplication;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Double getWeightCargoKg() {
		return weightCargoKg;
	}

	public void setWeightCargoKg(Double weightCargoKg) {
		this.weightCargoKg = weightCargoKg;
	}

	public Double getLengthCargoM() {
		return lengthCargoM;
	}

	public void setLengthCargoM(Double lengthCargoM) {
		this.lengthCargoM = lengthCargoM;
	}

	public Double getWidthCargoM() {
		return widthCargoM;
	}

	public void setWidthCargoM(Double widthCargoM) {
		this.widthCargoM = widthCargoM;
	}

	public Double getHeigthCargoM() {
		return heigthCargoM;
	}

	public void setHeigthCargoM(Double heigthCargoM) {
		this.heigthCargoM = heigthCargoM;
	}

	public Date getBeginningTripMark() {
		return beginningTripMark;
	}

	public void setBeginningTripMark(Date beginningTripMark) {
		this.beginningTripMark = beginningTripMark;
	}

	public Date getDeliveryCargoMark() {
		return deliveryCargoMark;
	}

	public void setDeliveryCargoMark(Date deliveryCargoMark) {
		this.deliveryCargoMark = deliveryCargoMark;
	}

	public Date getEndingTripMark() {
		return endingTripMark;
	}

	public void setEndingTripMark(Date endingTripMark) {
		this.endingTripMark = endingTripMark;
	}

	public Long getDispatcherId() {
		return dispatcherId;
	}

	public void setDispatcherId(Long dispatcherId) {
		this.dispatcherId = dispatcherId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
