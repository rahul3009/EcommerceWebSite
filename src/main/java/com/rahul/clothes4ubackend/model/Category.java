package com.rahul.clothes4ubackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="categories")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	
	@Column(unique=true)
	private String categoryName;
	
	private String categoryDescription;
	
	//private image;
	
	private boolean isActive;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this == null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		else{
			Category actual = (Category) obj;
			if(this.categoryId != actual.getCategoryId())
				return false;
			if(!this.categoryName.equals(actual.getCategoryName()))
				return false;
			if(!this.categoryDescription.equals(actual.getCategoryDescription()))
				return false;
			if(this.isActive!=actual.isActive())
				return false;
		}
		return true;

	}
}
