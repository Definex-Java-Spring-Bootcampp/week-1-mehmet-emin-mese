package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User{

    protected String name;
    protected String surname;
    protected LocalDate birthDate;
    protected String email; //bir email ile bir kere kayıt olunabilir.
    protected String password; //hash fonskiyonlarından biri ile hashlanecek.
    protected String phoneNumber;
    protected Boolean isActive;
    private List<Loan> loanList;
    private List<CreditCard> creditCardList;
    private List<Application> applicationList;
    private List<Bank> bankList;
    private List<Campaign> campaignList;
	public List<Loan> getLoanList() {
		return loanList;
	}

	public List<CreditCard> getCreditCardList() {
		return creditCardList;
	}

	public List<Bank> getBankList() {
		return bankList;
	}

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public static Map<BigDecimal, String> getLoanMap() {
		return LoanMap;
	}
	
	 public List<Application> getApplicationList() {
	        return applicationList;
	 }

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
    	this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
    	this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

   
    public void addApplicationList(Application application) {
        applicationList.add(application);
    }
    public void addLoanList(Loan loan) {
		loanList.add(loan);
	}
    public void addCreditCardList(CreditCard creditCard) {
		creditCardList.add(creditCard);
	}
    public void addBankList(Bank bank) {
		bankList.add(bank);
	}
    public void addCampaignList(Campaign campaign) {
		campaignList.add(campaign);
	}
    
    public void emailValidator() {
    	com.patika.kredinbizdenservice.model.EmailValidation.setEmails(email);
    	com.patika.kredinbizdenservice.model.EmailValidation.Validate();
    	
     }

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", isActive=" + isActive
				+ ", applicationList=" + applicationList + "]";
	}
	
	public void addTolist(Application application) {
		com.patika.kredinbizdenservice.model.Application.ApplicationList.add(application);
    }
	public static Map<BigDecimal,String> LoanMap=new HashMap<>();
    
	public void addLoan(BigDecimal amount) {
    	LoanMap.put(amount,name);
    }
    public static void biggestAmountandUser () {
    	String username=Collections.max(LoanMap.entrySet(), Comparator.comparing(Map.Entry::getKey)).getValue();
    	
    	BigDecimal amount=LoanMap.entrySet()
    	        .stream()
    	        .filter(entry -> username.equals(entry.getValue()))
    	        .map(Map.Entry::getKey)
    	        .findFirst()
    	        .orElse(null);
    	System.out.println("Biggest credit amount----->"+" Username: "+username+" Amount "+amount);
    	
    }
}
