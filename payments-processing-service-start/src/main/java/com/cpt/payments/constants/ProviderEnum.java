package com.cpt.payments.constants;
import lombok.Getter;

public enum ProviderEnum {
    STRIPE(1, "STRIPE"),
    TRUSTLY(2, "TRUSTLY"),
    PAYPAL(3, "PAYPAL");

    @Getter
    private final int code;
    @Getter
    private final String name;

    ProviderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProviderEnum getById(int code) {
        for (ProviderEnum provider : ProviderEnum.values()) {
            if (provider.getCode() == code) {
                return provider;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return name;
    }
}

