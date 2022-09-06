package com.mt.wallet.account.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
public class AccountException extends RuntimeException {
    private HttpStatus httpStatus;
    private List<String> errors;
    private Object data;

    public AccountException(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public AccountException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public AccountException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public AccountException(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message, Collections.singletonList(message), data);
    }

    public AccountException(HttpStatus httpStatus, String message, List<String> errors) {
        this(httpStatus, message, errors, null);
    }

    public AccountException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
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
