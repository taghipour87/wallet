package com.mt.wallet.player.exception;

import com.mt.wallet.player.model.ErrorResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return e.getMessage();
    }

    @ExceptionHandler(PlayerException.class)
    public ResponseEntity<ErrorResponse> handleError(PlayerException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}