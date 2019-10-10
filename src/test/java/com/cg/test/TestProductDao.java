package com.cg.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoImpl;
import com.cg.entity.Product;

public class TestProductDao {
private ProductDao dao;
	
	@Before
	public void init() {
		dao = new ProductDaoImpl();
	}
	
	@After
	public void destroy() {
		dao = null;
	}
	
	
	@Test
	public void testSave() {
		Product p = new Product();
		p.setName("Oppo");
		p.setPrice(17009.99);
		p.setStock(50);
		dao.save(p);


		
	}
	
	@Test
	public void testSearch() {
		Product p = dao.fetch(3);
		System.out.println(p.toString());
	}
	
	@Test
	public void testDelete() {
		boolean p = dao.delete(4);
		assertEquals(true, p);
		
	}
	

	
}



