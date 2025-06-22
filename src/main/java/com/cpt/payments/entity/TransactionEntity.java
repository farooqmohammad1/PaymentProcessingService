package com.cpt.payments.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


@Entity
@Table(name = "transaction")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int paymentMethodId;
    private int providerId;
    private int paymentProviderId;
    private int txnStatusId;
    private double amount;
    private String currency;
    private String merchantTransactionReference;
    private String txnReference;
    private String providerReference;
    private String providerCode;
    private String providerMessage;
    private int retryCount;
}
