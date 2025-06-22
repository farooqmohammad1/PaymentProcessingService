package com.cpt.payments.constants;

import lombok.Getter;

@Getter
public enum PaymentMethodEnum {
    CARD(1, "CARD"),
    UPI(2, "UPI");

    private final int code;
    private final String name;

    PaymentMethodEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PaymentMethodEnum fromName(String name) {
        for (PaymentMethodEnum pm : values()) {
            if (pm.getName().equalsIgnoreCase(name)) {
                return pm;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Method: " + name);
    }

    public static int codeFromName(String name) {
        return fromName(name).getCode();
    }
}



