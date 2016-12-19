package ru.tasha2k7.mail.motordepot.web.model;

public class RegistrationRoleModel {
	
	private RegistrationDataModel registrationDataModel;
	private RoleModel roleModel;

	
	public RegistrationDataModel getRegistrationDataModel() {
		return registrationDataModel;
	}

	public void setRegistrationDataModel(RegistrationDataModel registrationDataModel) {
		this.registrationDataModel = registrationDataModel;
	}

	
	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	@Override
	public String toString() {
		return "ClientRegistrationRoleModel [registrationDataModel=" + registrationDataModel + ", roleModel=" + roleModel + "]";
	}

	

}
