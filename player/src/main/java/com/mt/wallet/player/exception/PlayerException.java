package com.mt.wallet.player.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PlayerException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
