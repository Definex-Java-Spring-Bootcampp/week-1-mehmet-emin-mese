package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CreditCard implements Product{

    private BigDecimal fee;
    private List<Campaign> campaignList;
    private Bank bank;
    public static Map<Campaign,String> CampaignMap=new HashMap<>();
    public CreditCard(BigDecimal fee,Bank bank) {
        this.fee = fee;
        this.bank=bank;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }
    public void addCampaignList(Campaign campaign) {
    	campaignList.add(campaign);
    }
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }
    public static void CreateMap(List<Campaign> campaignList) {
    	for (Campaign element : campaignList) {
    		CampaignMap.put(element, element.getBank().getName());
        }
    }
    
    public static Map<String, Integer> calculateFrequency() {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String value : CampaignMap.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        
        return frequencyMap;
    }
    
    
    
    public static void sortByValue() {
    	int maxFrequency = 0;
        String mostFrequentValue =null;
        while(true){
        Map<String, Integer> frequencyMap = calculateFrequency();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentValue = entry.getKey();
            }
        }
        System.out.println("En yüksek frekanslı değer: " + mostFrequentValue);
        frequencyMap.remove(mostFrequentValue);
        if(frequencyMap.size()==0)
        	break;
        }
    }
    public static String sortByFrequency(Bank bank) {
    	int size=bank.getApplicationNumber();
    	List<String> liste=new ArrayList<String>();
    	String concat=bank.getName()+"."+Integer.toString(size);
    	return concat;
    }
    public static String sortByString(String concat) {
    	String[] parcalar=concat.split("\\.");
    	return parcalar[1];
    }
    public static void turet(List<Bank> list) {
    	List<Frequency> liste=new ArrayList<Frequency>();
    	for(int i=0;i<list.size();i++) {
    		Bank bank=list.get(i);
    		int frekans=bank.getApplicationNumber();
        	Frequency frequency=new Frequency(bank,frekans);
        	liste.add(frequency);
    	}
    	int i,j;
    	Frequency temp;
    	boolean swapped;
    	for( i=0;i<liste.size()-1;i++) {
    		swapped=false;
    		for (j = 0; j < liste.size() - i - 1; j++) {
    			if (liste.get(j).getFrequency() > liste.get(j+1).getFrequency()) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = liste.get(j);
                    liste.set(j, liste.get(j + 1));
                    liste.set(j + 1, temp);
                    swapped = true;
                }
    		}
    		if (swapped == false)
                break;
    	}
    	for(Frequency fre:liste) {
    		System.out.println(fre);
    	}
    }
    
    
}
