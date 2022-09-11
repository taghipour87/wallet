package com.mt.wallet.transaction.service;

import com.mt.wallet.transaction.model.dto.PaymentResponseDto;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.dto.PaymentRequestDto;

import java.util.List;

/**
 * @author Mohammad Taghipour
 * @Date 9/2/2022
 */
public interface TransactionService {

    List<Transaction> findByPlayerId(long playerId);

    PaymentResponseDto debit(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto credit(PaymentRequestDto paymentRequestDto);
}
