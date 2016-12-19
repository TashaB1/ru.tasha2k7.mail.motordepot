package ru.tasha2k7.mail.motordepot.web.model;

import java.util.List;

public class RoleModel {
	private Long id;
	private String nameRole;

	private List<RegistrationDataModel> registrationDataModel;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<RegistrationDataModel> getRegistrationDataModel() {
		return registrationDataModel;
	}

	public void setRegistrationDataModel(List<RegistrationDataModel> registrationDataModel) {
		this.registrationDataModel = registrationDataModel;
	}

	@Override
	public String toString() {
		return "RoleModel [nameRole=" + nameRole + ", registrationDataModel=" + registrationDataModel + "]";
	}

}
