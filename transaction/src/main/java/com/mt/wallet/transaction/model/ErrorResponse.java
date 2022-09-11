package com.mt.wallet.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private HttpStatus status;
    private int code;
    private String message;

}
