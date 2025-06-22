
package com.cpt.payments.constants;

import lombok.Getter;

public enum PaymentMethodEnum {
    APM(1, "APM"),
    CARD(2, "CARD");

    @Getter
    private final int code;
    @Getter
    private final String name;

    PaymentMethodEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PaymentMethodEnum getById(int code) {
        for (PaymentMethodEnum method : PaymentMethodEnum.values()) {
            if (method.getCode() == code) {
                return method;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return name;
    }
}
