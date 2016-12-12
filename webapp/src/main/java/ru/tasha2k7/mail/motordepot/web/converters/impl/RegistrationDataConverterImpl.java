package ru.tasha2k7.mail.motordepot.web.converters.impl;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.web.converters.Converters;
import ru.tasha2k7.mail.motordepot.web.model.RegistrationDataModel;


public class RegistrationDataConverterImpl implements Converters<RegistrationData, RegistrationDataModel>{

	@Override
	public RegistrationData model2entity(RegistrationDataModel registrationDataModel) {
		RegistrationData e = new RegistrationData();
		e.setId(registrationDataModel.getId());
		e.setEmail(registrationDataModel.getEmail());
		e.setPassword(registrationDataModel.getPassword());
		return e;
	}

	@Override
	public RegistrationDataModel entity2model(RegistrationData registrationData) {
		RegistrationDataModel e = new RegistrationDataModel();
		e.setId(registrationData.getId());
		e.setEmail(registrationData.getEmail());
		e.setPassword(registrationData.getPassword());		
		return e;
	}

}
