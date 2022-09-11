package com.mt.wallet.transaction.controller;

import com.mt.wallet.transaction.model.dto.PaymentRequestDto;
import com.mt.wallet.transaction.model.dto.PaymentResponseDto;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/debit")
    public ResponseEntity<PaymentResponseDto> debit(@RequestBody PaymentRequestDto paymentRequestDto) {
        log.info("transaction debit");
        PaymentResponseDto responseDto = service.debit(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
    }

    @PostMapping("/credit")
    public ResponseEntity<PaymentResponseDto> credit(@RequestBody PaymentRequestDto paymentRequestDto) {
        log.info("transaction credit");
        PaymentResponseDto responseDto = service.credit(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<Transaction>> getTransactionsByPlayerId(@RequestParam long playerId) {
        log.info("get all transaction");
        List<Transaction> transactionList = service.findByPlayerId(playerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionList);
    }

}
