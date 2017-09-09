package com.rahul.clothes4ubackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity    //to be autocreated in database as table
@Component //object can be found anywhere of bean class
@Table(name="rahul")  //to create a diff table name
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  //we need not give the value of primary key..it will do itself
	@Column(name="Product_ID") //to set name of column of the id 
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
