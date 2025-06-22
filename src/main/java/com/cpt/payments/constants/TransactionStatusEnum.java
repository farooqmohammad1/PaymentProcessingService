package com.cpt.payments.constants;

import lombok.Getter;
@Getter
public enum TransactionStatusEnum {
    CREATED(1,"CREATED"),
    INITIATED(2,"INITIATED"),
    PENDING(3,"PENDING"),
    SUCCESS(4,"SUCCESS"),
    FAILURE(5,"FAILURE");

    private final int code;
    private final String name;

    TransactionStatusEnum(int code,String name) {
        this.code = code;
        this.name = name;
    }

    public static TransactionStatusEnum fromCode(int code) {
        for (TransactionStatusEnum status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code for TransactionStatusEnum: " + code);
    }

    public static TransactionStatusEnum fromName(String name) {
        for (TransactionStatusEnum status : values()) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid name for TransactionStatusEnum: " + name);
    }

    public static int codeFromName(String name) {
        return fromName(name).getCode();
    }

    public static String getName(String txnStatus) {
        return txnStatus;
    }
}
