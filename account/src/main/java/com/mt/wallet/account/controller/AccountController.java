package com.mt.wallet.account.controller;

import com.mt.wallet.account.model.dto.BalanceResponseDto;
import com.mt.wallet.account.model.dto.PaymentRequestDto;
import com.mt.wallet.account.model.entity.Account;
import com.mt.wallet.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
@RestController("/account")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponseDto> getBalanceByPlayerId(@RequestParam long playerId) {
        log.info("account balance");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getBalance(playerId));
    }

    @PostMapping("/debit")
    public ResponseEntity<Account> debit(@RequestBody PaymentRequestDto paymentRequestDto) {
        log.info("account debit");
        Account account = service.debit(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/credit")
    public ResponseEntity<Account> credit(@RequestBody PaymentRequestDto paymentRequestDto) {
        log.info("account credit");
        Account account = service.credit(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

}
