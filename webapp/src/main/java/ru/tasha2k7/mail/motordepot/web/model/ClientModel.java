package ru.tasha2k7.mail.motordepot.web.model;

import java.util.Date;

public class ClientModel {
	private Long id;
	private String nameClient;
	private String address;
	private String numberPhone;
	private Long registrationDataId;
	private Date deleted;

	private RegistrationDataModel registrationDataModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Long getRegistrationDataId() {
		return registrationDataId;
	}

	public void setRegistrationDataId(Long registrationDataId) {
		this.registrationDataId = registrationDataId;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public RegistrationDataModel getRegistrationDataModel() {
		return registrationDataModel;
	}

	public void setRegistrationDataModel(RegistrationDataModel registrationDataModel) {
		this.registrationDataModel = registrationDataModel;
	}

	@Override
	public String toString() {
		return "ClientModel [nameClient=" + nameClient + ", address=" + address + ", numberPhone=" + numberPhone
				+ ", registrationDataId=" + registrationDataId + ", deleted=" + deleted + "]";
	}

}
