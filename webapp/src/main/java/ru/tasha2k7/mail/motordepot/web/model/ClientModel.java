package ru.tasha2k7.mail.motordepot.web.model;

import java.util.Date;

public class ClientModel {
	private String nameClient;
	private String address;
	private String numberPhone;
	private Long registrationDataId;
	private Date deleted;

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

	@Override
	public String toString() {
		return "ClientModel [nameClient=" + nameClient + ", address=" + address + ", numberPhone=" + numberPhone
				+ ", registrationDataId=" + registrationDataId + ", deleted=" + deleted + "]";
	}

}
