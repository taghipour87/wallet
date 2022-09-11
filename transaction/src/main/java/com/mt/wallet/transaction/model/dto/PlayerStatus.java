package com.mt.wallet.transaction.model.dto;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 8/31/2022
 */
public enum PlayerStatus {
    ACTIVE(1),
    INACTIVE(2);

    private final int code;

    PlayerStatus(final int code) {
        this.code = code;
    }

}