package com.prueba.bitbox.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.sun.istack.NotNull;


@Entity(name ="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	@NotNull
	@Column
	private String userName;
	@NotNull
	@Column
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rel_user_role", joinColumns = @JoinColumn(name = "idUser"),
    inverseJoinColumns = @JoinColumn(name = "idRole"))
    private Set<Role> roles = new HashSet<>();
	
	public User(String userName,String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
