package com.cpt.payments.pojo;

import lombok.Data;

@Data
public class Payment {
	 private String name;
	    private String email;
	    private double amount;
	    private String currency;        // Changed from 'Currency' to 'currency'
	    private String paymentMethod;   // Changed from 'PaymentMethod' to 'paymentMethod'
	    private String paymentType;     // Changed from 'PaymentType' to 'paymentType'
	    private String providerId;

}
