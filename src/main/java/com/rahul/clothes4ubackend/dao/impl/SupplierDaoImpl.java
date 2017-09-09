package com.rahul.clothes4ubackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.clothes4ubackend.dao.SupplierDao;

import com.rahul.clothes4ubackend.model.Supplier;

@Repository(value = "supplierDAO")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionfactory;

	public boolean saveSupplier(Supplier supplier) {

		try {
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	public Supplier getSupplierBysupplierid(int supplierid) {
		return sessionfactory.getCurrentSession().get(Supplier.class, supplierid);
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public List<Supplier> getAllSuppliers() {
		return sessionfactory.getCurrentSession().createQuery("from supplier").list();
	}

}
