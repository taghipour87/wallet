package com.mt.wallet.account.model.entity;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
public enum Status {
    ACTIVE(1),
    BLOCKED(3);

    private final int code;

    Status(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
