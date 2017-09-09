package com.rahul.clothes4ubackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.clothes4ubackend.dao.ProductDao;
import com.rahul.clothes4ubackend.model.Product;

@Repository(value="productDAO")  //it is the sub class of component its bean wld b found everywhere
@Transactional //org vala
public class ProductDAOImpl implements ProductDao{
	
	@Autowired  
	SessionFactory sessionFactory;

	public boolean saveProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
	
			e.printStackTrace();
			return false;
		}
		
	}

	public Product getProductById(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from product").list();
	}

}
