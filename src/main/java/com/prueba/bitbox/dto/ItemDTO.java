package com.prueba.bitbox.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDTO {
	
	private Integer idItem;
	private String itemCode;
	private String description;
	private float price;
	private String state;
	private LocalDate creationDate;
	private UserDTO creator;
	private Set<SupplierDTO> suppliers = new HashSet<>();
	private Set<PriceReductionDTO> priceReduction = new HashSet<>();
	
	
	//Getters - Setters
	
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public UserDTO getCreator() {
		return creator;
	}
	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}
	public Set<SupplierDTO> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(Set<SupplierDTO> suppliers) {
		this.suppliers = suppliers;
	}
	public Set<PriceReductionDTO> getPriceReduction() {
		return priceReduction;
	}
	public void setPriceReduction(Set<PriceReductionDTO> priceReduction) {
		this.priceReduction = priceReduction;
	}
	
	
}
