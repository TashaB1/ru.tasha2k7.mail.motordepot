package ru.tasha2k7.mail.motordepot.web.model;

public class RegistrationDataModel {
	private Long id;
	private String email;
	private String password;
	private Long roleId;

	private RoleModel roleModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	@Override
	public String toString() {
		return "RegistrationDataModel [id=" + id + ", email=" + email + ", password=" + password + ", roleId=" + roleId
				+ ", roleModel=" + roleModel + "]";
	}

}
