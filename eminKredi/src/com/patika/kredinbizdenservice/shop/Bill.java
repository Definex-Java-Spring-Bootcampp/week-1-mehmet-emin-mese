package com.patika.kredinbizdenservice.shop;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	private int amount;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<Product> productList=new ArrayList<Product>();
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Bill(int amount,String name) {
		this.amount = amount;
		this.productList=com.patika.kredinbizdenservice.shop.Consumer.productList;
		this.name=name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
