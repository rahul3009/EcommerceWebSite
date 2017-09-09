package com.rahul.clothes4ubackend.dao.impl;

import java.util.List;



import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.clothes4ubackend.dao.UserDAO;
import com.rahul.clothes4ubackend.model.Product;
import com.rahul.clothes4ubackend.model.User;

@Repository(value="userDAO")
@Transactional
public class UserDaoImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean UpdateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public User getUserByUsername(String username) {
		
		return sessionFactory.getCurrentSession().get(User.class, username);
	}

	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from user").list();
		
	}

	public boolean validateUser(String username, String password) {
		String hql="from User where username='"+username+"' and password='"+password+"'";
		Query<User> query=sessionFactory.getCurrentSession().createQuery(hql);
		User user=query.uniqueResult();
		if(user !=null)
			return true;
		else
			return false;
	}

}
