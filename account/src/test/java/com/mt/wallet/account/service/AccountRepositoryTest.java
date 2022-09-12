package com.mt.wallet.account.service;

import com.mt.wallet.account.model.entity.Account;
import com.mt.wallet.account.model.entity.Status;
import com.mt.wallet.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author Mohammad Taghipour
 * @Date 9/7/2022
 */
@ExtendWith(MockitoExtension.class)
class AccountRepositoryTest {

    @Mock
    private AccountRepository repository;

    private Account account;

    @BeforeEach
    void setup() {
        account = Account.builder()
                .id(1)
                .accountNumber("00000058398257466")
                .playerId(1)
                .status(Status.ACTIVE)
                .balance(new BigDecimal(100))
                .createdDateTime(LocalDateTime.now())
                .build();
    }

    // JUnit test for saveAccount method
    @DisplayName("JUnit test for saveAccount method")
    @Test
    void givenAccountObject_whenSaveAccount_thenReturnAccountObject() {

        given(repository.save(account)).willReturn(account);

        Account savedAccount = repository.save(account);

        assertThat(savedAccount).isNotNull();
    }

    // JUnit test for findByPlayerId method
    @DisplayName("JUnit test for findByPlayerId method")
    @Test
    void givenPlayerId_whenFindByPlayerId_thenReturnAccountObject() {
        given(repository.findByPlayerId(1)).willReturn(Optional.of(account));

        Account savedAccount = repository.findByPlayerId(account.getPlayerId()).orElse(null);

        assertThat(savedAccount).isNotNull();
    }

}
