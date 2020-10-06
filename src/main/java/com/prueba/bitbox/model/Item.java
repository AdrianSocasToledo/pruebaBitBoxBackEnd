package com.prueba.bitbox.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name ="Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	
	@Column
	private String itemCode;
	
	@Column
	private String description;
	
	@Column 
	private float price;
	
	@Column
	private String state;
	
	@Column
	private LocalDate creationDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
	private List<PriceReduction> priceReduction; 
	
	@ManyToOne(optional=false, cascade = CascadeType.ALL)
	@JoinColumn( name = "idUser")
	private User creator;
	
	@JoinTable(
			name = "rel_items_suppliers",
			joinColumns = @JoinColumn(name="itemCode",nullable=false),
			inverseJoinColumns = @JoinColumn(name="idSupplier",nullable = false) 
	)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Supplier> suppliers;

	
	//Getters - Setters
	
	public String getItemCode() {
		return itemCode;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
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

	
	public List<PriceReduction> getPriceReduction() {
		return priceReduction;
	}

	public void setPriceReduction(List<PriceReduction> priceReduction) {
		this.priceReduction = priceReduction;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	
	
	

}
