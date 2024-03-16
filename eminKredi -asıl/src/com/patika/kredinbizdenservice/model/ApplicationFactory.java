package com.patika.kredinbizdenservice.model;

import java.time.LocalDateTime;

public class ApplicationFactory {
	public static Application createApplication(Loan loan, User user, LocalDateTime localDateTime) {
        return new Application(loan, user, localDateTime);
    }
}
