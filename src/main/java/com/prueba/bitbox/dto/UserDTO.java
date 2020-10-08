package com.prueba.bitbox.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
	
	private Integer idUser;
	private String userName;
	private String Password;
	private Set<String> roles = new HashSet<>();
	
	
	//Getters - Setters
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	
}
