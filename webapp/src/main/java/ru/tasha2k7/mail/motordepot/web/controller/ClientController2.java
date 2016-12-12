package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.List;
import javax.inject.Inject;
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
//@RequestMapping(value = "/auth/")
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
	
}
