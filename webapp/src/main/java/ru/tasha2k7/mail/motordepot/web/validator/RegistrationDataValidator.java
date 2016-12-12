package ru.tasha2k7.mail.motordepot.web.validator;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;

public class RegistrationDataValidator implements Validator{
	
	@Inject
	private RegistrationDataService registrationDataService;
	
	@Override
    public boolean supports(Class<?> aClass) {
        return RegistrationData.class.equals(aClass);
    }

	@Override
	public void validate(Object obj, Errors errors) {
		RegistrationData registrationData = (RegistrationData) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (registrationData.getEmail().length() < 8 || registrationData.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }

        if (registrationDataService.findByEmail(registrationData.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (registrationData.getPassword().length() < 8 || registrationData.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        /*if (!registrationData.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }*/
		
	}
}
