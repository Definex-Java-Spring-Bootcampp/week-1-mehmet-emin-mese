package com.patika.kredinbizdenservice.model;

public class Frequency {
	public Bank bank;
	public int frequency;
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public Frequency(Bank bank, int frequency) {
		this.bank = bank;
		this.frequency = frequency;
	}
	
}
