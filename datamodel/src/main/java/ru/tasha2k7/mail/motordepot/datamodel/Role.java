package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.List;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;

@DBTableName(name = "role")
public class Role extends AbstractModel {

	private String nameRole;

	private List<RegistrationData> registrationData;

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<RegistrationData> getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(List<RegistrationData> registrationData) {
		this.registrationData = registrationData;
	}

	@Override
	public String toString() {
		return "Role [nameRole=" + nameRole + "]";
	}

}
