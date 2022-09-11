package com.mt.wallet.account.model.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
public enum Status {
    ACTIVE(1),
    INACTIVE(2);

    private static final Map<Integer, Status> codeToStatusMap = new HashMap<>();

    static {
        Arrays.stream(values())
                .forEach(status -> codeToStatusMap.put(status.code, status));
    }

    private final int code;

    public static Status valueOf(int code) {
        for (Status status : Status.values()) {
            if (status.code == code)
                return codeToStatusMap.get(code);
        }
        return null;
    }

    public Integer fromValue(Status status) {
        return status.code;
    }

    Status(final int code) {
        this.code = code;
    }

}
