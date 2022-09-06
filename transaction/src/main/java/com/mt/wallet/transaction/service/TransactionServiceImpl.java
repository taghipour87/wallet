package com.mt.wallet.transaction.service;

import com.mt.wallet.transaction.model.dto.AccountResponseDto;
import com.mt.wallet.transaction.model.dto.PaymentRequestDto;
import com.mt.wallet.transaction.model.dto.TransactionRequestDto;
import com.mt.wallet.transaction.model.entity.Status;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.entity.type;
import com.mt.wallet.transaction.repository.TransactionRepository;
import com.mt.wallet.transaction.service.client.AccountFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 9/2/2022
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final AccountFeignClient accountFeignClient;

    @Override
    public List<Transaction> findByPlayId(long playerId) {
        return repository.findByPlayerId(playerId);
    }

    @Override
    public Transaction debit(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = saveCreatedTransaction(transactionRequestDto, type.DEBIT);
        PaymentRequestDto paymentRequestDto = getPaymentRequestDto(transactionRequestDto, transaction);
        AccountResponseDto accountResponseDto = accountFeignClient.debit(paymentRequestDto).getBody();
        return  saveCompletedTransaction(transaction, Objects.requireNonNull(accountResponseDto));
    }

    @Override
    public Transaction credit(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = saveCreatedTransaction(transactionRequestDto, type.CREDIT);
        PaymentRequestDto paymentRequestDto = getPaymentRequestDto(transactionRequestDto, transaction);
        AccountResponseDto accountResponseDto = accountFeignClient.credit(paymentRequestDto).getBody();
        return  saveCompletedTransaction(transaction, Objects.requireNonNull(accountResponseDto));
    }

    private Transaction saveCreatedTransaction(TransactionRequestDto transactionRequestDto, type type) {
        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID())
                .status(Status.CREATED)
                .type(type)
                .playerId(transactionRequestDto.getPlayerId())
                .build();
        return repository.save(transaction);
    }

    private PaymentRequestDto getPaymentRequestDto(TransactionRequestDto transactionRequestDto, Transaction transaction) {
        return PaymentRequestDto.builder()
                .playerId(transactionRequestDto.getPlayerId())
                .amount(transactionRequestDto.getAmount())
                .transactionId(transaction.getTransactionId())
                .build();
    }

    private Transaction saveCompletedTransaction(Transaction transaction, AccountResponseDto accountResponseDto) {
        transaction.setStatus(Status.COMPLETED);
        transaction.setAccountNumber(accountResponseDto.getAccountNumber());
        repository.save(transaction);
        transaction.setId(null);
        return transaction;
    }

}
