package com.rahul.clothes4ubackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.clothes4ubackend.dao.CategoryDAO;
import com.rahul.clothes4ubackend.model.Category;

@Repository(value="categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return false;
	}

	public boolean updateCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(HibernateException excpetion){
			excpetion.printStackTrace();
		}
		return false;
	}

	public Category getCategoryById(int categoryId) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
		return category;
	}

	public boolean deleteCategory(Category category) {
		try{
			category = (Category) sessionFactory.getCurrentSession().load(Category.class, category.getCategoryId());
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

}
