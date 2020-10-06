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
	private LocalDate startDate;
	
	@Column
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = " idItem")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = " idUser")
	private User creator;
	
	
	//Gettes - Setters

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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
	
	
}
