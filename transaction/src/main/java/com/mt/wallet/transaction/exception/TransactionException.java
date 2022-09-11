package com.mt.wallet.transaction.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionException extends RuntimeException {

    private final HttpStatus httpStatus;


    public TransactionException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}