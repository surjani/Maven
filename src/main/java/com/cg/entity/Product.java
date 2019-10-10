package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prod_master") //which table to be mapped
@NamedQuery(name = "stockQuery", query = "from Product where stock>:st")
public class Product {
	@Id
	@GeneratedValue //to give autogen
	private int code;
	@Column(name = "prod_name", length = 30) //to change string variable's column name and length from default to 30
	private String name;
	private double price;
	private int stock;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
