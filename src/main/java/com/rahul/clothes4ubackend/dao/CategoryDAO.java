package com.rahul.clothes4ubackend.dao;

import java.util.List;

import com.rahul.clothes4ubackend.model.Category;

public interface CategoryDAO {
	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategoryById(int categoryId);
	public boolean deleteCategory(Category category);
	public List<Category> getAllCategories();
}
