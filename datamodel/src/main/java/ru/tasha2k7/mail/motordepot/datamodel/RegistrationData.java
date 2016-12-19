package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.List;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;
import ru.tasha2k7.mail.motordepot.annotation.DaoMetadata;

@DBTableName(name = "registrationdata")
@DaoMetadata(mapper = RegistrationData.class)
public class RegistrationData extends AbstractModel {

	private String email;
	private String password;
	private Long roleId;

	private Employee employee;
	private Client client;
	private Role role; 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegistrationData [email=" + email + ", password=" + password + ", roleId=" + roleId + ", employee="
				+ employee + ", client=" + client + ", role=" + role + "]";
	}

	

}
