package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tasha2k7.mail.motordepot.datamodel.Client;
import ru.tasha2k7.mail.motordepot.datamodel.Role;
import ru.tasha2k7.mail.motordepot.services.ClientService;
import ru.tasha2k7.mail.motordepot.services.RoleService;
import ru.tasha2k7.mail.motordepot.web.model.ClientModel;

@Controller
public class ClientController2 {
	@Inject
	private ClientService clientService;
	
	@Inject
	private RoleService roleService;
	
	@Inject
	private MethodController methodController;
	
	@RequestMapping(value = "/client" ,method = RequestMethod.GET)
	public String  getAll(Model model){
		
		List<ClientModel> converted = methodController.getAll();
		
        model.addAttribute("listClients", converted);
		return "client";
	}
	

	@RequestMapping(value = "/client/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("client") Client client) {
        if (client.getId() == 0) {
            this.clientService.save(client);
        } else {
            this.clientService.save(client);
        }
        return "redirect:/clientAll";
	}
	
	
	@RequestMapping(value = "/admin" ,method = RequestMethod.GET)
	public String  getAdmin(Model model){		
		return "admin";
	}
	
	@RequestMapping(value = "/driver" ,method = RequestMethod.GET)
	public String  getDriver(Model model){		
		return "driver";
	}
	
	@RequestMapping(value = "/dispatcher" ,method = RequestMethod.GET)
	public String  getDispatcher(Model model){		
		return "dispatcher";
	}
	
	
	private ClientModel entity2model(Client client) {
		ClientModel e = new ClientModel();
		e.setId(client.getId());
		e.setNameClient(client.getNameClient());
		e.setAddress(client.getAddress());
		e.setNumberPhone(client.getNumberPhone());
		e.setRegistrationDataId(client.getRegistrationDataId());
		e.setDeleted(client.getDeleted());
		return e;
	}


	@RequestMapping(value = "/role",method = RequestMethod.GET)
	public String  getAllRole(Model model){	
		model.addAttribute("role", new Role());
        model.addAttribute("list", this.roleService.getAll());
		return "role";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "login1";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
}
