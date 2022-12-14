package com.mt.wallet.transaction.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt.wallet.transaction.model.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    final ObjectMapper mapper;

    public FeignErrorDecoder() {
        this.mapper = new ObjectMapper();
    }


    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
            String body = new String(response.body().asInputStream().readAllBytes());
            ErrorResponse errorResponse = new ObjectMapper().readValue(body, ErrorResponse.class);
            return new TransactionException(errorResponse.getStatus(), errorResponse.getMessage());
    }

}
