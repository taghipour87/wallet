package com.mt.wallet.transaction.service.client;

import com.mt.wallet.transaction.model.dto.AccountResponseDto;
import com.mt.wallet.transaction.model.dto.PaymentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Mohammad Taghipour
 * @Date 9/5/2022
 */
@FeignClient("account")
public interface AccountFeignClient {

    @PostMapping(value = "/debit", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountResponseDto> debit(@RequestBody PaymentRequestDto paymentRequestDto);

    @PostMapping(value = "/credit", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountResponseDto> credit(@RequestBody PaymentRequestDto paymentRequestDto);

}
