package com.mt.wallet.player.model;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 8/31/2022
 */
public enum Status {
    ACTIVE(1),
    INACTIVE(2);

    private final int code;

    Status(final int code) {
        this.code = code;
    }

}
