package com.patika.kredinbizdenservice.model;

import java.time.LocalDate;

public class UserFactory{
	private static UserFactory instance;
	public UserFactory() {
		
	}
	public static UserFactory getInstance() {
		if(instance==null) {
			instance=new UserFactory();
		}
		return instance;
	}
	
	
	public static User createUser(String name,String surname, LocalDate birthDate,String email,String password,String phoneNumber,Boolean isActive){
		return new User(name,surname,birthDate,email,password,phoneNumber,isActive);
	}
}
