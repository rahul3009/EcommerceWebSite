package com.rahul.clothes4ubackend;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.clothes4ubackend.dao.SupplierDao;
import com.rahul.clothes4ubackend.model.Supplier;

public class SupplierJunitTest {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDao supplierDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.clothes4ubackend");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDao) context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void testForAddingSupplierPass(){
		supplier.setCompanyName("second company");
		supplier.setCompanyAdress("some address");
		supplier.setActive(true);
		supplier.setCompanyEmail("new email");
		assertTrue(supplierDAO.saveSupplier(supplier));
	}
	
	@Test(expected=PersistenceException.class)
	public void testForAddingSupplierFail(){
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		supplierList.forEach((tempSupplier)->{
			assertFalse(supplierDAO.saveSupplier(tempSupplier));
		});
	}
	
	@Test
	public void testForUpdatingSupplierPass(){
		supplier = supplierDAO.getAllSuppliers().get(0);
		supplier.setActive(!supplier.isActive());
		assertTrue(supplierDAO.UpdateSupplier(supplier));
	}
	
	@Test(expected=PersistenceException.class)
	public void testForUpdatingSupplierFail(){
		supplier = supplierDAO.getAllSuppliers().get(0);
		supplier.setSupplierID(25014264);
		assertFalse(supplierDAO.UpdateSupplier(supplier));
	}
	
	@Test
	public void testForGetSupplierByIdPass(){
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		supplierList.forEach((temp)->{
			assertEquals(temp, supplierDAO.getSupplierBysupplierid(temp.getSupplierID()));
		});
	}
	
	@Test
	public void testForGetSupplierByIdFail(){
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		supplierList.forEach((temp)->{
			assertNotEquals(temp, supplierDAO.getSupplierBysupplierid(temp.getSupplierID()+10));
		});
	}
	
	@Test
	public void testForGetAllSuppliers(){
		assertNotNull(supplierDAO.getAllSuppliers());
	}
	
	@Ignore
	@Test
	public void testForDeleteSupplierPass(){
		supplier = supplierDAO.getAllSuppliers().get(0);
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testForDeleteSupplierFail(){
		supplier.setSupplierID(254789542);
		assertFalse(supplierDAO.deleteSupplier(supplier));
	}
	
}