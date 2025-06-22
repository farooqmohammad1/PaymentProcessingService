package com.cpt.payments.constants;

import lombok.Getter;

@Getter
public enum ProviderEnum {
    RAZORPAY(1, "RAZORPAY"),
    PAYU(2, "PAYU"),
    STRIPE(3, "STRIPE");

    private final int code;
    private final String name;

    ProviderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProviderEnum fromName(String name) {
        for (ProviderEnum e : values()) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid Provider: " + name);
    }

    public static int codeFromName(String name) {
        return fromName(name).getCode();
    }

    public static ProviderEnum fromCode(int code) {
        for (ProviderEnum e : values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid Provider code: " + code);
    }
}
