package com.mt.wallet.account.service;

import com.mt.wallet.account.model.dto.BalanceResponseDto;
import com.mt.wallet.account.model.dto.PaymentRequestDto;
import com.mt.wallet.account.model.entity.Account;

import javax.transaction.Transactional;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
public interface AccountService {

    BalanceResponseDto getBalance(long playerId);

    Account debit(PaymentRequestDto paymentRequestDto);

    @Transactional
    Account credit(PaymentRequestDto paymentRequestDto);
}
