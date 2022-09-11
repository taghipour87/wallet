package com.mt.wallet.account.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public AccountException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
