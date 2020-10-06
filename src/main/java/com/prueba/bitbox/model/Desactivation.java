package com.prueba.bitbox.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Desactivation")
public class Desactivation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDesactivation;
	
	@Column
	private String reason;
	
	@ManyToOne(optional=false, cascade = CascadeType.ALL)
	@JoinColumn(name="idItem")
	private Item item;
	
	@ManyToOne(optional=false, cascade = CascadeType.ALL)
	@JoinColumn(name="idUser")
	private User user;
	
	
	
	//Getters - Setters

	public Integer getIdDesactivation() {
		return idDesactivation;
	}

	public void setIdDesactivation(Integer idDesactivation) {
		this.idDesactivation = idDesactivation;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
