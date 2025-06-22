package com.cpt.payments.constants;

import lombok.Getter;

public enum TransactionStatusEnum {

    CREATED(1, "CREATED"),
    INITIATED(2, "INITIATED"),
    PENDING(3, "PENDING"),
    SUCCESS(4, "SUCCESS"),
    FAILED(5, "FAILED");
    @Getter
    private final int code;
    @Getter
    private final String name;

    TransactionStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

   

    public static TransactionStatusEnum getById(int code) {
        for (TransactionStatusEnum status : TransactionStatusEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return name;
    }
}

