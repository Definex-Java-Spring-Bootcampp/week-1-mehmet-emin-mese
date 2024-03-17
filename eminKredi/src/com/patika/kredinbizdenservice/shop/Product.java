package com.patika.kredinbizdenservice.shop;

public class Product {
	private String category;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String name;
	private int stock;
	private Consumer consumer;
	public Product(String category,int price, String name, int stock,Consumer consumer) {
		this.category = category;
		this.price = price;
		this.name = name;
		this.stock = stock;
		this.consumer=consumer;
		//this.bill=bill;
	}
	/*public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}*/
	public Consumer getConsumer() {
		return consumer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
