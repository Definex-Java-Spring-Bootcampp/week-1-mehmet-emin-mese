package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Campaign {

    private String title;
    private String content;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private SectorType sector;
	private Bank bank;
	private List<User> userList;
	public static List<Campaign> campaignList=new ArrayList<Campaign>();
	  public static Campaign campaign;
	  public static List<Campaign> getCampaignList() {
			return campaignList;
		}
		public Campaign getCampaign() {
			return campaign;
		}
		public void setCampaign(Campaign campaign) {
			this.campaign = campaign;
		}
	public void addCampaignList(){
		campaignList.add(campaign);
	}
    public Bank getBank() {
		return bank;
	}

	public Campaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector,Bank bank) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.sector = sector;
        this.bank=bank;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public SectorType getSector() {
        return sector;
    }

    public void setSector(SectorType sector) {
        this.sector = sector;
    }

    public void addUserList(User user) {
    	userList.add(user);
    }
    public List<User> getUserList() {
    	return userList;
    }
    @Override
    public String toString() {
        return "Campaign{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dueDate=" + dueDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sector=" + sector +
                '}';
    }
    
}
