package com.prueba.bitbox.dto;

public class DesactivationDTO {
	
	private Integer idDesactivation;
	private String reason;
	private Integer idItem;
	private Integer idUser;
	
	
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
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	
	
	
}
