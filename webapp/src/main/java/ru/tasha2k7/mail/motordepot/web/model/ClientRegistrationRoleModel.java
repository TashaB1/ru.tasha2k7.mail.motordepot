package ru.tasha2k7.mail.motordepot.web.model;

public class ClientRegistrationRoleModel {

	private RegistrationDataModel registrationDataModel;
	private ClientModel clientModel;
	private RoleModel roleModel;

	public RegistrationDataModel getRegistrationDataModel() {
		return registrationDataModel;
	}

	public void setRegistrationDataModel(RegistrationDataModel registrationDataModel) {
		this.registrationDataModel = registrationDataModel;
	}

	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	@Override
	public String toString() {
		return "ClientRegistrationRoleModel [registrationDataModel=" + registrationDataModel + ", clientModel="
				+ clientModel + ", roleModel=" + roleModel + "]";
	}

}
