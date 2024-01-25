package com.saneer.SpringBoot.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")

public class Product {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	
	private String brand;
	
	private double price;
	
	public Product() {
		
	}

	public Product( String brand, double price) {
		super();
		
		this.brand = brand;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}
	

}
