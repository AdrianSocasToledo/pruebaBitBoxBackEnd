package com.prueba.bitbox.dto;

import java.time.LocalDate;

public class PriceReductionDTO {
	
	private Integer idPriceReduction;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer idItem;
	private Integer idUser;
	
	
	
	//Getters - Setters
	
	public Integer getIdPriceReduction() {
		return idPriceReduction;
	}
	public void setIdPriceReduction(Integer idPriceReduction) {
		this.idPriceReduction = idPriceReduction;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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
