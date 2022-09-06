package com.mt.wallet.transaction.controller;

import com.mt.wallet.transaction.model.dto.TransactionRequestDto;
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
    public ResponseEntity<Transaction> debit(@RequestBody TransactionRequestDto transactionRequestDto) {
        log.info("transaction debit");
        Transaction transaction = service.debit(transactionRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transaction);
    }

    @PostMapping("/credit")
    public ResponseEntity<Transaction> credit(@RequestBody TransactionRequestDto transactionRequestDto) {
        log.info("transaction credit");
        Transaction transaction = service.credit(transactionRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transaction);
    }

    @GetMapping()
    public ResponseEntity<List<Transaction>> getTransactionsByPlayerId(@RequestParam long playerId) {
        log.info("get all transaction");
        List<Transaction> transactionList = service.findByPlayId(playerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionList);
    }

}
