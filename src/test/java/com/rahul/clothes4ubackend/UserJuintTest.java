package com.rahul.clothes4ubackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.rahul.clothes4ubackend.dao.UserDAO;
import com.rahul.clothes4ubackend.model.User;

public class UserJuintTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;
	
//	//the method in before class will get executed before execution of the whole program
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.rahul.clothes4ubackend");
		context.refresh();
		user=(User) context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	
	@Ignore
	@Test  //this annotation takes the said method as test method
	public void testToAddUser()
	{
		user.setUsername("rishna");
		user.setAddress("krishna nagar");
		user.setEmail("krishna@gmail.com");
		user.setActive(true);
		user.setRole("seller");
		user.setPassword("123456");
		assertEquals(true, userDAO.saveUser(user));
	}
	@Ignore
	@Test
	public void testToAddUser2()
	{
		user.setUsername("krish");
		user.setAddress("krishna nagar");
		user.setEmail("krishna@gmail.com");
		user.setActive(true);
		user.setRole("seller");
		user.setPassword("123456");
		assertEquals(true, userDAO.saveUser(user));
	}
	
	@Ignore
	@Test
	public void testToDeleteUser()
	{
		
		assertEquals(true, userDAO.deleteUser(user));
	}
	
	
	@Test
	public void testToUpdateUser()
	{
		user.setUsername("rishna");
		user.setAddress("JJ Colony");
		user.setEmail("krisa@gmail.com");
		user.setActive(true);
		user.setRole("user");
		user.setPassword("123456");
		assertEquals(true, userDAO.UpdateUser(user));
	}
	
	@Test
	public void testToValidateUser()
	{
		
	}
	
	
	

}
