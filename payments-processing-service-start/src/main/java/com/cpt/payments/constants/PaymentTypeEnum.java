
package com.cpt.payments.constants;

import lombok.Getter;

public enum PaymentTypeEnum {
    SALE(1, "SALE"),
    RECURRING(2, "RECURRING");

    @Getter
    private final int code;
    @Getter
    private final String name;

    PaymentTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PaymentTypeEnum getById(int code) {
        for (PaymentTypeEnum type : PaymentTypeEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return name;
    }
}

