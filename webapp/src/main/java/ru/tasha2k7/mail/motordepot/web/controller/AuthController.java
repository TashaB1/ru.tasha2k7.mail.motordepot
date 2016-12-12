package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRegistry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.tasha2k7.mail.motordepot.datamodel.Employee;
import ru.tasha2k7.mail.motordepot.datamodel.RegistrationData;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.EmployeeService;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;

@Controller
public class AuthController {
	@Inject
	private ClientService clientService;

	@Inject
	private EmployeeService employeeService;

	@Inject
	private RegistrationDataService registrationDataService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String getPage(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("трям");

		if (registrationDataService.findByEmail(email) != null) {
			switch (registrationDataService.getRoleName(email)) {
			case "admin":
				return "admin";
			case "driver":
				return "driver";
			case "dispatcher":
				return "dispatcher";
			case "client":
				return "client";
			}
		} else {

			return "login";
		}
		return "index";
	}

	@RequestMapping(value = "/auth/registration", method = RequestMethod.GET)
	public String getRegistration() {
		return "registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
}
