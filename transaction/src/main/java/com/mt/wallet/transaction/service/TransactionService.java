package com.mt.wallet.transaction.service;

import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.dto.TransactionRequestDto;

import java.util.List;

/**
 * @author Mohammad Taghipour
 * @Date 9/2/2022
 */
public interface TransactionService {

    List<Transaction> findByPlayId(long playerId);

    Transaction debit(TransactionRequestDto transactionRequestDto);

    Transaction credit(TransactionRequestDto transactionRequestDto);
}
