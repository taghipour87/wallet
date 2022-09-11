package com.mt.wallet.transaction.service;

import com.mt.wallet.transaction.model.dto.AccountResponseDto;
import com.mt.wallet.transaction.model.dto.PaymentRequestDto;
import com.mt.wallet.transaction.model.dto.PaymentResponseDto;
import com.mt.wallet.transaction.model.entity.Status;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.entity.Type;
import com.mt.wallet.transaction.repository.TransactionRepository;
import com.mt.wallet.transaction.service.client.AccountFeignClient;
import com.mt.wallet.transaction.service.client.PlayerFeignClient;
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
    private final PlayerFeignClient playerFeignClient;

    @Override
    public List<Transaction> findByPlayerId(long playerId) {
        playerFeignClient.getPlayer(playerId);
        return repository.findByPlayerId(playerId);
    }

    @Override
    public PaymentResponseDto debit(PaymentRequestDto paymentRequestDto) {
        playerFeignClient.getPlayer(paymentRequestDto.getPlayerId());
        Transaction createdTransaction = saveCreatedTransaction(paymentRequestDto, Type.DEBIT);
        AccountResponseDto accountResponseDto = accountFeignClient.debit(paymentRequestDto).getBody();
        Transaction completedTransaction = saveCompletedTransaction(createdTransaction, Objects.requireNonNull(accountResponseDto));
        return convertToPaymentResponseDto(completedTransaction);
    }

    @Override
    public PaymentResponseDto credit(PaymentRequestDto paymentRequestDto) {
        playerFeignClient.getPlayer(paymentRequestDto.getPlayerId());
        Transaction transaction = saveCreatedTransaction(paymentRequestDto, Type.CREDIT);
        AccountResponseDto accountResponseDto = accountFeignClient.credit(paymentRequestDto).getBody();
        Transaction completedTransaction = saveCompletedTransaction(transaction, Objects.requireNonNull(accountResponseDto));
        return convertToPaymentResponseDto(completedTransaction);
    }

    private Transaction saveCreatedTransaction(PaymentRequestDto paymentRequestDto, Type type) {
        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID())
                .status(Status.CREATED)
                .type(type)
                .playerId(paymentRequestDto.getPlayerId())
                .build();
        return repository.save(transaction);
    }

    private Transaction saveCompletedTransaction(Transaction transaction, AccountResponseDto accountResponseDto) {
        transaction.setStatus(Status.COMPLETED);
        transaction.setAccountNumber(accountResponseDto.getAccountNumber());
        repository.save(transaction);
        return transaction;
    }

    private PaymentResponseDto convertToPaymentResponseDto(Transaction transaction) {
        return PaymentResponseDto.builder()
                .playerId(transaction.getPlayerId())
                .accountNumber(transaction.getAccountNumber())
                .transactionId(transaction.getTransactionId())
                .transactionDateTime(transaction.getUpdatedDateTime())
                .status(transaction.getStatus())
                .build();
    }

}
