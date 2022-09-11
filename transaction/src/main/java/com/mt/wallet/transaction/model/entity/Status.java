package com.mt.wallet.transaction.model.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public enum Status {
    CREATED(1),
    COMPLETED(2),
    CANCELED(3);

    private static final Map<Integer, Status> codeToStatusMap = new HashMap<>();

    static {
        Arrays.stream(values())
                .forEach(status -> codeToStatusMap.put(status.code, status));
    }

    private final int code;

    public static Status valueOf(int code) {
        for (Status status: Status.values()) {
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
