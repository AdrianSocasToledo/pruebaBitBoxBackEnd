package com.prueba.bitbox.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.prueba.bitbox.security.enums.RoleName;

@Entity(name="Roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRole;
	
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public Role() {
		
	}
	
	public Role(RoleName roleName) {
		this.roleName = roleName;
	}

	
	//GETTERS - SETTERS
	
	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
	
}	
