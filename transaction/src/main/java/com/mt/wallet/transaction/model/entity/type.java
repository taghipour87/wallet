package com.mt.wallet.transaction.model.entity;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public enum type {
    DEBIT(1),
    CREDIT(2);

    private final int code;

    type(int code) {
        this.code = code;
    }
}
