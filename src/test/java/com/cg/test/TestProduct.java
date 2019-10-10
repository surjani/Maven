package com.cg.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Product;

public class TestProduct {
	private EntityManager mgr;
	
	@Before
	public void setup() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		mgr = factory.createEntityManager();
	
	}// To initiate entitymanager
	
	@After
	public void tearDown() {
		mgr.close();
	}
	
	
	@Test
	public void testSaveProduct() {
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = new Product();
		p.setName("iPhone");
		p.setPrice(19999.99);
		p.setStock(25);
		mgr.persist(p);
		txn.commit();
		
	}
	@Test
	public void testDetached() {
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = (Product) mgr.find(Product.class, 2);
		//p.setStock(50); //database updated
		txn.commit();
		txn.begin();
		p.setStock(60); //detached state(change only in memory state, not in database
		                //if begin and commit is not present
		txn.commit();
	}
	
	@Test
	public void testFetchProducts() {
		//Query que = mgr.createQuery("from Product where price>5000");
		Query que = mgr.createQuery("from Product where price>:pr");
		que.setParameter("pr", 5000.00);
		List<Product> products = que.getResultList();
		for (Product p : products) {
			System.out.println(p.getName());
		}
	}
	
	
	@Test
	public void testNamedQuery() {
		Query que =  mgr.createNamedQuery("stockQuery");
		que.setParameter("st", 10);
		List<Product> products = que.getResultList();
		for (Product p : products) {
			System.out.println(p.getName());
		}
		
	}
	
	
	

}
