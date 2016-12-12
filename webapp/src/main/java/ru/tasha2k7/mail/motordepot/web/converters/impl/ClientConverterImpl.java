package ru.tasha2k7.mail.motordepot.web.converters.impl;



import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.web.converters.Converters;
import ru.tasha2k7.mail.motordepot.web.converters.RegistrationDataConverter;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;


public class ClientConverterImpl implements Converters<Client, ClientModel>{

	RegistrationDataConverter registrationDataConverter;
	
	@Override
	public Client model2entity(ClientModel clientModel) {
		Client e = new Client();
		e.setId(clientModel.getId());
		e.setNameClient(clientModel.getNameClient());
		e.setAddress(clientModel.getAddress());
		e.setNumberPhone(clientModel.getNumberPhone());
		e.setRegistrationData(registrationDataConverter.model2entity(clientModel.getRegistrationDataModel()));// e.setRegistrationData(clientModel.getRegistrationDataModel().getId());
		e.setDeleted(clientModel.getDeleted());
		return e;
	}

	@Override
	public ClientModel entity2model(Client client) {
		ClientModel e = new ClientModel();
		e.setId(client.getId());
		e.setNameClient(client.getNameClient());
		e.setAddress(client.getAddress());
		e.setNumberPhone(client.getNumberPhone());
		e.setRegistrationDataModel(registrationDataConverter.entity2model(client.getRegistrationData()));
		e.setDeleted(client.getDeleted());
		return e;
	}

}
