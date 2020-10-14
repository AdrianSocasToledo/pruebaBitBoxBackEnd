package com.prueba.bitbox.dto;

public class SupplierDTO {
	
	private Integer idSupplier;
	private String name;
	private String country;
	
public SupplierDTO(Integer idSupplier, String name, String country) {
		super();
		this.idSupplier = idSupplier;
		this.name = name;
		this.country = country;
	}
	//Getters - Setters
	
	public Integer getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(Integer idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
