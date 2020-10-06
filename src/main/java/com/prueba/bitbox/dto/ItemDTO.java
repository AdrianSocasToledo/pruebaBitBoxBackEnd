package com.prueba.bitbox.dto;

import java.time.LocalDate;

public class ItemDTO {
	
	private Integer idItem;
	private String itemCode;
	private String description;
	private float price;
	private String state;
	private LocalDate creationDate;
	private Integer creator;
	private Integer supplier;
	private Integer priceReduction;
	
	
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
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getSupplier() {
		return this.supplier;
	}
    public void setSupplier(Integer supplier) {
    	this.supplier= supplier;
    }
	public Integer getPriceReduction() {
		return priceReduction;
	}
	public void setPriceReduction(Integer priceReduction) {
		this.priceReduction = priceReduction;
	}
	
	
}
