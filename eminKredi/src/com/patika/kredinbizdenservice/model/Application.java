package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Application {

    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;
    public static ArrayList<Application> ApplicationList=new ArrayList<Application>();
    private Bank bank;
	private List<Loan> loanList;
	private List<User> userList;
    private Application() {
    }

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public static ArrayList<Application> getApplicationList() {
		return ApplicationList;
	}

	public Bank getBank() {
		return bank;
	}

	public List<Loan> getLoanList() {
		return loanList;
	}

	public List<User> getUserList() {
		return userList;
	}
	public void addLoanList(Loan loan) {
		loanList.add(loan);
	}

	public void setUserList(User user) {
		userList.add(user);
	}
    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
    public static List<Application> getLastMonthApplications() {
    	List<Application> lastMonthApplications = new ArrayList<>();
    	LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1).minusMinutes(1);
    	for (Application app : ApplicationList) {
            if (app.getLocalDateTime().isAfter(oneMonthAgo)) {
                lastMonthApplications.add(app);
            }
        }
        return lastMonthApplications;
    }
    public static void listSpecificUser(String email) {
    	List<Application> applications = ApplicationList.stream()
                .filter(application -> application.getUser().getEmail().equals(email)).toList();
    	for (Application item : applications) {
            System.out.println(item);
        }
    }
    public static void mostFrequentUser () {
    	HashMap<Application, Long> userFrequencyMap = new HashMap<>();
    	for(int i=0;i<ApplicationList.size();i++) {
    		Application userName = ApplicationList.get(i);
    		Long userFrequency=ApplicationList.stream().filter(e->e.equals(userName)).count();
    		userFrequencyMap.put(ApplicationList.get(i),userFrequency);
    	}
    	Application mostFrequentUser=Collections.max(userFrequencyMap.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
    	String user=mostFrequentUser.getUser().getName();
    	System.out.println("Biggest number of application made by: "+user);
    }
}
