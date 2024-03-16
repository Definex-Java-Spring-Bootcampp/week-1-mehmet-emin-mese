package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

public class CreditCardFactory {
	public static CreditCard createCreditCard(BigDecimal fee,Bank bank) {
        return new CreditCard(fee,bank);
    }
}
