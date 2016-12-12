package ru.tasha2k7.mail.motordepot.web.model;

public class ClientRegistrationModel {
	
	private RegistrationDataModel registrationDataModel;
	private ClientModel clientModel;

	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	public RegistrationDataModel getRegistrationDataModel() {
		return registrationDataModel;
	}

	public void setRegistrationDataModel(RegistrationDataModel registrationDataModel) {
		this.registrationDataModel = registrationDataModel;
	}

	@Override
	public String toString() {
		return "ClientRegistrationModel [registrationDataModel=" + registrationDataModel + ", clientModel="
				+ clientModel + "]";
	}

}
