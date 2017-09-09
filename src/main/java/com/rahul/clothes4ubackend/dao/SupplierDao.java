package com.rahul.clothes4ubackend.dao;

import java.util.List;

import com.rahul.clothes4ubackend.model.Supplier;

public interface SupplierDao {

	public boolean saveSupplier(Supplier supplier);
	public boolean UpdateSupplier(Supplier supplier);
	public Supplier getSupplierBysupplierid(int supplierid);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getAllSuppliers();
	
}
