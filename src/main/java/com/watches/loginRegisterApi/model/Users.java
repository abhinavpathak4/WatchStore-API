package com.watches.loginRegisterApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	String email;
	String name ;
	String password;
	Boolean admin;
	public Users(String email, String name, String password, Boolean admin) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.admin = admin;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
