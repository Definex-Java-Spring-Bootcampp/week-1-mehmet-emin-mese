package com.patika.kredinbizdenservice.shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Consumer {
	private List<Order> orderList=new ArrayList<Order>();;
	public static List<Consumer> consumerList=new ArrayList<Consumer>();
	//public static List<Product> staticProductList=new ArrayList<Product>();
	public static List<Product> productList=new ArrayList<Product>();
	public static List<Bill> billList=new ArrayList<Bill>();

	private String name;
	private String surname;
	private String  email;
	private String password;
	private String telephoneNumber;
	private LocalDateTime birthDate;
	public Consumer( String name, String surname, String email, String password,
			String telephoneNumber, LocalDateTime birthDate) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.telephoneNumber = telephoneNumber;
		this.birthDate = birthDate;
	}
	public long getAge() {
		long age=-1*ChronoUnit.YEARS.between(LocalDate.now(),birthDate);
		return age;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public static void addConsumerList(Consumer consumer) {
		consumerList.add(consumer);
	}
	public void addProductList(Product product) {
		productList.add(product);
	}
	public void addBillList(Bill bill) {
		billList.add(bill);
	}
	public List<Consumer> getConsumerList() {
		return consumerList;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void addOrderList(Order order) {
		orderList.add(order);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public static void listSpecificUsersBill(List<Bill>billList,String name) {
		List<Product> productBill=new ArrayList<Product>();
		List<Product> productBillFilter=new ArrayList<Product>();
		for(Bill bill:billList) {
			productBill=bill.getProductList();
			for(Product product:productList) {
				productBillFilter=productBill.stream().filter(entry->name.equals(entry.getConsumer().getName())).toList();
			}
		}
		System.out.println(name+" adlı kullanıcıların aldıkları ürün sayısı "+ productBillFilter.size());
}
	public static void listSpecificUserwithAge(List<Bill>billList,String name) {
		int sum=0;
		List<Product> productBillFilter=new ArrayList<Product>();
		List<Product> productBill=new ArrayList<Product>();
		for(Bill bill:billList) {
			productBill=bill.getProductList();
			for(Product product:productList) {
				productBillFilter=productBill.stream().filter(entry->name.equals(entry.getConsumer().getName())).toList();
			}
		}
		for(Product productFilter:productBillFilter)
			if(productFilter.getConsumer().getAge()>25 && productFilter.getConsumer().getAge()<30) {
				sum+=productFilter.getPrice();
			}
		/*List<Product> productUserList=productList.stream().filter(entry->name.equals(entry.getConsumer().getName())).toList();
		int sum=0;
		for(Product product:productUserList) {
			if(product.getConsumer().getAge()>25 && product.getConsumer().getAge()<30) {
				sum+=product.getBill().getAmount();
			}
		}*/
		System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı -----> "+sum);
	}
	public static void billAboveSpecificValue(int value) {
		for(Bill bill:billList) {
			if(bill.getAmount()>1500) {
				System.out.println("1500 tl üzeri faturalar "+bill.getName());
			}
		}
	}
	/*public static void listSpecificUsersProduct(List<Product>productList,String name) {
			List<Product> productUserList=productList.stream().filter(entry->name.equals(entry.getConsumer().getName())).toList();
		
				System.out.println(name+" adlı kullanıcıların aldıkları ürün sayısı "+ productUserList.size());
	}
	public static void listSpecificUserwithAge(List<Product>productList,String name) {
		List<Product> productUserList=productList.stream().filter(entry->name.equals(entry.getConsumer().getName())).toList();
		int sum=0;
		for(Product product:productUserList) {
			if(product.getConsumer().getAge()>25 && product.getConsumer().getAge()<30) {
				sum+=product.getBill().getAmount();
			}
		}
		System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı -----> "+sum);
	}
	private static void billAboveSpecificValue(int value) {
		int sum=0;
		for(Product product:productList) {
			sum+=product.getBill().getAmount();
		}
		if(sum>1500) {
			System.out.println("1500 tl üzeri faturalar");
		}
	}*/
}

