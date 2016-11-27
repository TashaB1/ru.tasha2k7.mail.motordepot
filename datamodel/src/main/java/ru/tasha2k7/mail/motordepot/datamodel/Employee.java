package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.Date;
import java.util.List;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;
import ru.tasha2k7.mail.motordepot.annotation.DaoMetadata;

@DBTableName(name = "employee")
@DaoMetadata(entity = Employee.class)
public class Employee extends AbstractModel {

	private String firstname;
	private String lastname;
	private String surname;
	private Date birthday;
	private String numberDriverLicense;
	private String categoryDriverLicense;
	private String position;
	private Long registrationDataId;
	private Long carId;
	private Date deleted;

	private List<Application> applications;
	private Car car;
	private RegistrationData registrationData;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNumberDriverLicense() {
		return numberDriverLicense;
	}

	public void setNumberDriverLicense(String numberDriverLicense) {
		this.numberDriverLicense = numberDriverLicense;
	}

	public String getCategoryDriverLicense() {
		return categoryDriverLicense;
	}

	public void setCategoryDriverLicense(String categoryDriverLicense) {
		this.categoryDriverLicense = categoryDriverLicense;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getRegistrationDataId() {
		return registrationDataId;
	}

	public void setRegistrationDataId(Long registrationDataId) {
		this.registrationDataId = registrationDataId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public RegistrationData getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(RegistrationData registrationData) {
		this.registrationData = registrationData;
	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", surname=" + surname + ", birthday="
				+ birthday + ", numberDriverLicense=" + numberDriverLicense + ", categoryDriverLicense="
				+ categoryDriverLicense + ", position=" + position + ", registrationDataId=" + registrationDataId
				+ ", deleted=" + deleted + ", applications=" + applications + ", car=" + car + ", registrationData="
				+ registrationData + "]";
	}
	
	

}
