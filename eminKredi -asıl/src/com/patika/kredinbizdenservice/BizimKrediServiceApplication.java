package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.ApplicationFactory;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CampaignFactory;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.CreditCardFactory;
import com.patika.kredinbizdenservice.model.EmailValidation;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.UserFactory;
import com.patika.kredinbizdenservice.model.VechileLoan;

public class BizimKrediServiceApplication {
	
	public static void main(String[] args) {
		//1. Aynı e-mail adresi ile bir kullanıcı kayıt olabilir
		//2.Kullanıcının şifresi SHA-512 ile şifrelenerek kullanıcı oluşturulmalıdır.
		User user=UserFactory.createUser("Ali","Çam",LocalDate.now().minusYears(50),"alicam@gmail.com","password","1234567",true);
		user.toString();
		User user2=UserFactory.createUser("Faruk","Çam",LocalDate.now().minusYears(50),"alicam@gmail.com","password","1234567",true);
		user2.toString();
		user.emailValidator();
		user2.emailValidator();
		//Aynı email den sadece bir kullanıcının kayıt olabileceğini göstermek için kayıtlı emailleri bastırdım.
		com.patika.kredinbizdenservice.model.EmailValidation.printEmailList();
		
		// 3. En çok başvuru yapan kullanıcıyı bulan methodu yazın.
		//4. En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.
		//5. Son bir aylık yapılan başvuruları listeleyen methodu yazın.
		User user3=UserFactory.createUser("Ahmet","Çam",LocalDate.now().minusYears(50),"ahmetcam@gmail.com","password","1234567",true);
		
		Application application=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(200.50),12,12.1),user3,LocalDateTime.now().minusMonths(1));
		user3.addTolist(application);
		user3.addLoan(application.getLoan().getAmount());
		Application application2=ApplicationFactory.createApplication(new VechileLoan(new BigDecimal(201.50),12,12.1),user3,LocalDateTime.now().minusMonths(2));
		user3.addTolist(application2);
		user3.addLoan(application2.getLoan().getAmount());
		Application application3=ApplicationFactory.createApplication(new ConsumerLoan(new BigDecimal(202.50),12,12.1),user3,LocalDateTime.now().minusMonths(3));
		user3.addTolist(application3);
		user3.addLoan(application3.getLoan().getAmount());
		
		User user4=UserFactory.createUser("Mustafa","Çam",LocalDate.now().minusYears(50),"mustafacam@gmail.com","password","1234567",true);
		
		Application application4=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(203.50),12,12.1),user4,LocalDateTime.now().minusMonths(1));
		Application application5=ApplicationFactory.createApplication(new VechileLoan(new BigDecimal(204.50),12,12.1),user4,LocalDateTime.now().minusMonths(2));
		user4.addTolist(application4);
		user4.addLoan(application4.getLoan().getAmount());
		user4.addTolist(application5);
		user4.addLoan(application5.getLoan().getAmount());
		
		User user5=UserFactory.createUser("Ayşe","Çam",LocalDate.now().minusYears(50),"aysecam@gmail.com","password","1234567",true);
		
		Application application6=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(205.50),12,12.1),user5,LocalDateTime.now().minusMonths(1));
		user5.addTolist(application6);
		user5.addLoan(application6.getLoan().getAmount());
		com.patika.kredinbizdenservice.model.Application.mostFrequentUser();
		com.patika.kredinbizdenservice.model.User.biggestAmountandUser();
		List<Application> applications=com.patika.kredinbizdenservice.model.Application.getLastMonthApplications();
		for(Application app:applications) {
			System.out.println("Last month applications: "+app);
		}
	
		Campaign campaign=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("FinansBank"));
		Campaign campaign2=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("ZiraatBank"));
		Campaign campaign3=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("ZiraatBank"));
		Campaign campaign4=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("ZiraatBank"));
		Campaign campaign5=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("ZiraatBank"));
		Campaign campaign6=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("GarantiBank"));
		Campaign campaign7=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,new Bank("GarantiBank"));
		campaign.setCampaign(campaign);
		campaign2.setCampaign(campaign2);
		campaign3.setCampaign(campaign3);
		campaign4.setCampaign(campaign4);
		campaign5.setCampaign(campaign5);
		campaign6.setCampaign(campaign6);
		campaign7.setCampaign(campaign7);
		campaign.addCampaignList();
		campaign2.addCampaignList();
		campaign3.addCampaignList();
		campaign4.addCampaignList();
		campaign5.addCampaignList();
		campaign6.addCampaignList();
		campaign7.addCampaignList();
		CreditCard creditCard=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("FinansBank"));	
		CreditCard creditCard2=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("GarantiBank"));
		CreditCard creditCard3=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("ZiraatBank"));
		List<Bank> list=new ArrayList<Bank>();
		list.add(campaign.getBank());
		list.add(campaign2.getBank());
		list.add(campaign3.getBank());
		list.add(campaign4.getBank());
		list.add(campaign5.getBank());
		list.add(campaign6.getBank());
		list.add(campaign7.getBank());
		//com.patika.kredinbizdenservice.model.CreditCard.CreateMap(com.patika.kredinbizdenservice.model.Campaign.campaignList);
		//com.patika.kredinbizdenservice.model.CreditCard.sortByValue();
		com.patika.kredinbizdenservice.model.CreditCard.turet(list);
		User user6=UserFactory.createUser("Cem","Dirman",LocalDate.now().minusYears(50),"cemdrman@gmail.com","password","1234567",true);
		
		Application application8=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(200.50),12,12.1),user6,LocalDateTime.now().minusMonths(1));
		Application application9=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(201.50),12,12.1),user6,LocalDateTime.now().minusMonths(1));
		Application application10=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(202.50),12,12.1),user6,LocalDateTime.now().minusMonths(1));
		Application application11=ApplicationFactory.createApplication(new HouseLoan(new BigDecimal(203.50),12,12.1),user6,LocalDateTime.now().minusMonths(1));
		user6.addTolist(application8);
		user6.addTolist(application9);
		user6.addTolist(application10);
		user6.addTolist(application11);
		com.patika.kredinbizdenservice.model.Application.listSpecificUser("cemdrman@gmail.com");
		
	}

}
