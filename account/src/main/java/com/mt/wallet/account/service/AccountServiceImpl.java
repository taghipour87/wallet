package com.mt.wallet.account.service;

import com.mt.wallet.account.exception.AccountException;
import com.mt.wallet.account.constant.Error;
import com.mt.wallet.account.model.dto.BalanceResponseDto;
import com.mt.wallet.account.model.dto.PaymentRequestDto;
import com.mt.wallet.account.model.entity.Account;
import com.mt.wallet.account.model.entity.Status;
import com.mt.wallet.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mt.wallet.account.constant.Error.ACCOUNT_IS_NOT_ACTIVE;
import static com.mt.wallet.account.constant.Error.BALANCE_IS_NOT_ENOUGH;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    @Transactional
    public BalanceResponseDto getBalance(long playerId) {
        Account account = repository.findByPlayerId(playerId)
                .orElseThrow(() -> new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, Error.PLAYER_DOES_NOT_EXIST));
        if (account.getStatus().equals(Status.INACTIVE))
            throw new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, ACCOUNT_IS_NOT_ACTIVE);
        return BalanceResponseDto.builder().balance(account.getBalance()).build();
    }

    @Override
    @Transactional
    public Account debit(PaymentRequestDto paymentRequestDto) throws RuntimeException {
        Account account = repository.findWithLockingByPlayerId(paymentRequestDto.getPlayerId())
                .orElseThrow(() -> new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, Error.PLAYER_DOES_NOT_EXIST));
        if (account.getStatus().equals(Status.INACTIVE))
            throw new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, ACCOUNT_IS_NOT_ACTIVE);
        if (account.getBalance().compareTo(paymentRequestDto.getAmount()) >= 0) {
            account.setBalance(account.getBalance().subtract(paymentRequestDto.getAmount()));
            account = repository.save(account);
        } else {
            throw new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, BALANCE_IS_NOT_ENOUGH);
        }
        return account;
    }

    @Override
    @Transactional
    public Account credit(PaymentRequestDto paymentRequestDto) {
        Account account = repository.findWithLockingByPlayerId(paymentRequestDto.getPlayerId())
                .orElseThrow(() -> new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, Error.PLAYER_DOES_NOT_EXIST));
        if (account.getStatus().equals(Status.INACTIVE))
            throw new AccountException(HttpStatus.INTERNAL_SERVER_ERROR, ACCOUNT_IS_NOT_ACTIVE);
        account.setBalance(account.getBalance().add(paymentRequestDto.getAmount()));
        account = repository.save(account);
        return account;
    }

}
