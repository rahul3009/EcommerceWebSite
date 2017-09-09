package com.rahul.clothes4ubackend.dao;

import java.util.List;

import com.rahul.clothes4ubackend.model.Product;



public interface ProductDao {
	
	public boolean saveProduct(Product product); //to save the object of product
	public Product getProductById(int id); //to fetch product by id
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product prodct);
	public List<Product> getAllProducts();

}
