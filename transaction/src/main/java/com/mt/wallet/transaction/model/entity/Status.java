package com.mt.wallet.transaction.model.entity;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public enum Status {
    CREATED(1),
    COMPLETED(2),
    CANCELED(3);

    private final int code;

    Status(int code) {
        this.code = code;
    }
}
