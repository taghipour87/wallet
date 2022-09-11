package com.mt.wallet.transaction.model.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public enum Type {
    DEBIT(1),
    CREDIT(2);

    private static final Map<Integer, Type> codeToTypeMap = new HashMap<>();

    static {
        Arrays.stream(values())
                .forEach(status -> codeToTypeMap.put(status.code, status));
    }

    private final int code;

    public static Type valueOf(int code) {
        for (Type type: Type.values()) {
            if (type.code == code)
                return codeToTypeMap.get(code);
        }
        return null;
    }

    public Integer fromValue(Type type) {
        return type.code;
    }

    Type(final int code) {
        this.code = code;
    }
}
