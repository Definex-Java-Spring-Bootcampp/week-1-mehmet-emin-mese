package com.patika.kredinbizdenservice.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class EmailValidation {
	private static  String Email;
	
	public static void setEmails(String email) {
		Email = email;
		addEmailToList();
	}
	private static ArrayList<String> EmailList=new ArrayList<String>(); 
	public static  void Validate() {
		boolean duplicate;
		if(EmailList.stream().filter(e->e.equals(Email)).count()==1) {
			duplicate=false;
			StringBuilder sb=null;
			try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = md.digest(Email.getBytes());
             sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            }
			catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            System.out.println("Hashed Password: " + sb.toString());
		}else {
			duplicate=true;
		}
		String message=duplicate?"Email reqistered more than one":"Email valid";
		if(duplicate)
			EmailList.remove(EmailList.size()-1);
		System.out.println(message);
	}
	public static  void addEmailToList() {
		EmailList.add(Email);
	}
	public static void printEmailList() {
		System.out.print("Kayıtlı Emailler");
		for(String email:EmailList) {
			System.out.println(email);
		}
	}
}
