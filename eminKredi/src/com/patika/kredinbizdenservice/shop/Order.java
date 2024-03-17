package com.patika.kredinbizdenservice.shop;

import java.util.List;

public class Order {
	private List<Product> productList;
	private Bill bill;
	public Order(Bill bill) {
		this.bill = bill;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void addProductList(Product product) {
		productList.add(product);
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
}
