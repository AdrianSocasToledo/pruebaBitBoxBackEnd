package com.prueba.bitbox.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="PriceReductions")
public class PriceReduction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPriceReduction;
	
	@Column
	private Integer reducedPrice;
	
	@Column
	private LocalDate startDate;
	
	@Column
	private LocalDate endDate;
	
	public PriceReduction() {
		
	}
	
	

	//Gettes - Setters


	public PriceReduction(Integer reducedPrice, LocalDate startDate, LocalDate endDate) {
		super();
		this.reducedPrice = reducedPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}



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
