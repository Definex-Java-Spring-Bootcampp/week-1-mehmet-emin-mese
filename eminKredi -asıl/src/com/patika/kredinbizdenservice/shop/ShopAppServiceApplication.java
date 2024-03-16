package com.patika.kredinbizdenservice.shop;

import java.time.LocalDateTime;
import java.util.List;

public class ShopAppServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer consumer= new Consumer("Ali","Çam","alicam@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer2= new Consumer("Cem","Dırman","cemdrman@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer3= new Consumer("Ahmet","Çam","ahmetcam@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer4= new Consumer("Ziya","Çam","ziyacam@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer5= new Consumer("Faruk","Çam","farukcam@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer6= new Consumer("Ömer","Çam","omercam@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(50));
		Consumer consumer7= new Consumer("Cem","Uzun","cemuzun@gmail.com","12345678","12345678",LocalDateTime.now().minusYears(26));
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer2);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer3);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer4);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer5);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer6);
		com.patika.kredinbizdenservice.shop.Consumer.addConsumerList(consumer7);
		System.out.println("Sistemdeki tüm müşteri sayısı -----> "+com.patika.kredinbizdenservice.shop.Consumer.consumerList.size());
		
		consumer2.addProductList(new Product("ev",200,"sabun",500,consumer2));
		consumer2.addProductList(new Product("ev",200,"sabun",500,consumer2));
		consumer2.addProductList(new Product("ev",200,"sabun",500,consumer2));
		consumer7.addProductList(new Product("ev",900,"sabun",500,consumer7));
		consumer2.addBillList(new Bill(200,"ev faturası"));
		consumer7.addBillList(new Bill(1600,"iş faturası"));
		List<Bill> list=com.patika.kredinbizdenservice.shop.Consumer.billList;
		com.patika.kredinbizdenservice.shop.Consumer.listSpecificUsersBill(list,"Cem");
		com.patika.kredinbizdenservice.shop.Consumer.listSpecificUserwithAge(list,"Cem");
		com.patika.kredinbizdenservice.shop.Consumer.billAboveSpecificValue(1500);
	}

}
