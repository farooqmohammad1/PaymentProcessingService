package com.cpt.payments.pojo;

import lombok.Data;

@Data
public class Transaction {
    private int id;
    private int userId;
    private String txnStatus;
    private String paymentMethod;
    private String providerName;
    private String paymentType;
    private double amount;
    private String currency;
    private String merchantTransactionReference;
    private String txnReference;
    private String providerReference;
    private String providerCode;
    private String providerMessage;
    private int retryCount;
}
