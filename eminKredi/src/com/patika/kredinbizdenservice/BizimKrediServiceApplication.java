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
import com.patika.kredinbizdenservice.model.Frequency;
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
		// 3. En çok başvuru yapan kullanıcıyı bulan methodu yazın.
		com.patika.kredinbizdenservice.model.Application.mostFrequentUser();
		//4. En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.
		com.patika.kredinbizdenservice.model.User.biggestAmountandUser();
		//5. Son bir aylık yapılan başvuruları listeleyen methodu yazın.
		List<Application> applications=com.patika.kredinbizdenservice.model.Application.getLastMonthApplications();
		for(Application app:applications) {
			System.out.println("Last month applications: "+app);
		}
		Bank bankFinans=new Bank("FinansBank");
		Bank bankZiraat=new Bank("ZiraatBank");
		Bank bankGaranti=new Bank("GarantiBank");
		Campaign campaign=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankFinans);
		Campaign campaign2=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankFinans);
		Campaign campaign3=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankZiraat);
		Campaign campaign4=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankZiraat);
		Campaign campaign5=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankZiraat);
		Campaign campaign6=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankZiraat);
		Campaign campaign7=CampaignFactory.createCampaign("Kampanya","bir alana bir bedava",LocalDate.now(),LocalDate.now(),LocalDate.now(),SectorType.MARKET,bankGaranti);
		bankGaranti.setCampaign(campaign);
		bankGaranti.addCampaignList();
		bankGaranti.setCampaign(campaign2);
		bankGaranti.addCampaignList();
		bankGaranti.setCampaign(campaign3);
		bankGaranti.addCampaignList();
		bankGaranti.setCampaign(campaign4);
		bankGaranti.addCampaignList();
		int FrequencyZiraat=bankZiraat.getCampaignList().size();
		bankFinans.setCampaign(campaign5);
		bankFinans.addCampaignList();
		bankFinans.setCampaign(campaign6);
		bankFinans.addCampaignList();
		int FrequencyFinans=bankFinans.getCampaignList().size();
		bankZiraat.setCampaign(campaign7);
		bankZiraat.addCampaignList();
		int FrequencyGaranti=bankGaranti.getCampaignList().size();
		Frequency frequencyZiraat=new Frequency(bankZiraat,FrequencyZiraat);
		Frequency frequencyFinans=new Frequency(bankFinans,FrequencyFinans);
		Frequency frequencyGaranti=new Frequency(bankGaranti,FrequencyGaranti);
		
		CreditCard creditCard=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("FinansBank"));	
		CreditCard creditCard2=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("GarantiBank"));
		CreditCard creditCard3=CreditCardFactory.createCreditCard(new BigDecimal(300.90),new Bank("ZiraatBank"));
		List<Frequency> list=new ArrayList<Frequency>();
		list.add(frequencyZiraat);
		list.add(frequencyFinans);
		list.add(frequencyGaranti);
		//6.Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen methodu yazın.
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
		System.out.println("cemdrman@gmail.com mailini kullanan başvurular: ");
		//7. cemdrman@gmail.com mail adresine sahip kullanıcının bütün başvurularınıl listeleyen methodu yazın.(Parametrik şekilde çalışmalıdır.)
		com.patika.kredinbizdenservice.model.Application.listSpecificUser("cemdrman@gmail.com");
		
	}

}
