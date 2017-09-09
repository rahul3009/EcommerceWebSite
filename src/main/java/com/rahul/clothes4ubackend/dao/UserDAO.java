package com.rahul.clothes4ubackend.dao;

import com.rahul.clothes4ubackend.model.User;

import java.util.List;

public interface UserDAO {
	public boolean saveUser(User user);
	public boolean UpdateUser(User user);
	public User getUserByUsername(String username);
	public boolean deleteUser(User user);
	public List<User> getAllUsers();
	public boolean validateUser(String username,String password);
}
