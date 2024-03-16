package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCardList;
    private List<Application> applicationList;
    private List<User> userList;
  
    public Bank(String name) {
    	this.name=name;
    }
    public String getName() {
		return name;
	}

    public int getApplicationNumber() {
    	return com.patika.kredinbizdenservice.model.Campaign.campaignList.size();
    }
	public void setName(String name) {
		this.name = name;
	}


	public List<Loan> getLoanList() {
		return loanList;
	}


	public void addLoanList(Loan loan) {
		loanList.add(loan);
	}

	public List<CreditCard> getCreditCardList() {
		return creditCardList;
	}


	public void addCreditCardList(CreditCard creditCard) {
		creditCardList.add(creditCard);
	}


	public List<Application> getApplicationList() {
		return applicationList;
	}


	public void addApplicationList(Application application) {
		applicationList.add(application);
	}


	public List<User> getUserList() {
		return userList;
	}


	public void addUserList(User user) {
		userList.add(user);
	}


	/*public List<Campaign> getCampaignList() {
		return campaignList;
	}


	public void addCampaignList(Campaign campaign) {
		campaignList.add(campaign);
	}*/


	@Override
	public String toString() {
		return "Bank [name=" + name + ", loanList=" + loanList + ", creditCardList=" + creditCardList
				+ ", applicationList=" + applicationList + ", userList=" + userList
				+ "]";
	}

}
