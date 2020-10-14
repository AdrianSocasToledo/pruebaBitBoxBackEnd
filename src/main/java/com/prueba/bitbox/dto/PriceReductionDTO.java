package com.prueba.bitbox.dto;

import java.time.LocalDate;

public class PriceReductionDTO {
	
	private Integer idPriceReduction;
	private Integer reducedPrice;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	
	public PriceReductionDTO(Integer idPriceReduction, Integer reducedPrice,LocalDate startDate, LocalDate endDate) {
		super();
		this.idPriceReduction = idPriceReduction;
		this.reducedPrice = reducedPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}
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

	public Integer getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Integer reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	
	
}
