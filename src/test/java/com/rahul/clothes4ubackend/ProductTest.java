package com.rahul.clothes4ubackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.clothes4ubackend.dao.ProductDao;
import com.rahul.clothes4ubackend.model.Product;

public class ProductTest {
	public static void main(String[] args)
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//easily bean class can be refresh and used
		context.scan("com.rahul.clothes4ubackend");
		
		context.refresh();
		
		Product product = (Product) context.getBean("product"); //"product" is the bean 
		product.setName("A collection O");
		product.setPrice(5000);
		product.setQuantity(100);
		product.setDescription("The best collection of ");
		
		
		ProductDao dao= (ProductDao)context.getBean("productDao");
		if(dao.saveProduct(product)==true)
		System.out.println("The product was saved!!");
		else
		System.out.println("Unsaved Product");
		
		//Now we check whether the methods in DAO IMPL are being called correctly or not
		context.close();		
	
	}

}