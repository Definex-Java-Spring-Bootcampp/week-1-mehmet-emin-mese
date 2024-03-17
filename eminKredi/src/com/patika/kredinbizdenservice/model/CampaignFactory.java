package com.patika.kredinbizdenservice.model;

import java.time.LocalDate;

import com.patika.kredinbizdenservice.enums.SectorType;

public class CampaignFactory {
	private static CampaignFactory instance;
	private CampaignFactory() {
		
	}
	public static CampaignFactory getInstance() {
		if(instance==null) {
			instance=new CampaignFactory();
		}
		return instance;
	}
	public static Campaign createCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector,Bank bank) {
        return new Campaign(title,content,dueDate,createDate,updateDate,sector,bank);
    }
}





