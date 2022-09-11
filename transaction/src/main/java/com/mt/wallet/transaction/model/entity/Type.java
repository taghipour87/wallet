package com.mt.wallet.transaction.model.entity;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public enum Type {
    DEBIT(1),
    CREDIT(2);

    private final int code;

    Type(int code) {
        this.code = code;
    }
}
