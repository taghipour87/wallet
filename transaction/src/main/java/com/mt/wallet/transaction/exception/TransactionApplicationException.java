package com.mt.wallet.transaction.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class TransactionApplicationException extends RuntimeException {

    private HttpStatus httpStatus;
    private List<String> errors;
    private Object data;

    public TransactionApplicationException(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public TransactionApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public TransactionApplicationException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public TransactionApplicationException(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message, Collections.singletonList(message), data);
    }

    public TransactionApplicationException(HttpStatus httpStatus, String message, List<String> errors) {
        this(httpStatus, message, errors, null);
    }

    public TransactionApplicationException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Object getData() {
        return data;
    }
}