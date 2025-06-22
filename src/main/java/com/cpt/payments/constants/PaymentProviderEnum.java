package com.cpt.payments.constants;

import lombok.Getter;

@Getter
public enum PaymentProviderEnum {
    PAYTM(1, "PAYTM"),
    PHONEPE(2, "PHONEPE"),
    GOOGLEPAY(3, "GOOGLEPAY");

    private final int code;
    private final String name;

    PaymentProviderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PaymentProviderEnum fromName(String name) {
        for (PaymentProviderEnum e : values()) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Provider: " + name);
    }

    public static int codeFromName(String name) {
        return fromName(name).getCode();
    }

    public static PaymentProviderEnum fromCode(int code) {
        for (PaymentProviderEnum e : values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Provider code: " + code);
    }
}
