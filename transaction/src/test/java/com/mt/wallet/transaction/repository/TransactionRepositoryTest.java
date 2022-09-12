package com.mt.wallet.transaction.repository;

import com.mt.wallet.transaction.model.entity.Status;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.entity.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    @Mock
    private TransactionRepository repository;

    private Transaction transaction_1;
    private List<Transaction> transactionList;
    private Long playerId;

    @BeforeEach
    void setup() {
        playerId = 1L;
        transaction_1 = Transaction.builder()
                .id(1L)
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("00000058398257466")
                .status(Status.COMPLETED)
                .type(Type.DEBIT)
                .createdDateTime(LocalDateTime.now())
                .build();
        Transaction transaction_2 = Transaction.builder()
                .id(2L)
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("00000058398257466")
                .status(Status.COMPLETED)
                .type(Type.CREDIT)
                .createdDateTime(LocalDateTime.now())
                .build();
        Transaction transaction_3 = Transaction.builder()
                .id(3L)
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("00000058398257466")
                .status(Status.COMPLETED)
                .type(Type.CREDIT)
                .createdDateTime(LocalDateTime.now())
                .build();
        Transaction transaction_4 = Transaction.builder()
                .id(4L)
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("00000058398257466")
                .status(Status.COMPLETED)
                .type(Type.DEBIT)
                .createdDateTime(LocalDateTime.now())
                .build();
        transactionList = Arrays.asList(transaction_1, transaction_2, transaction_3, transaction_4);
    }

    // JUnit test for saveTransaction method
    @DisplayName("JUnit test for saveTransaction method")
    @Test
    void givenTransactionObject_whenSaveTransaction_thenReturnTransactionObject() {

        given(repository.save(transaction_1)).willReturn(transaction_1);

        Transaction savedTransaction = repository.save(transaction_1);

        assertThat(savedTransaction).isNotNull();
    }

    // JUnit test for check Idempotency
    @DisplayName("JUnit test for getTransactionsByPlayerId method which return transaction list")
    @Test
    void givenTransactionList_whenGetTransactionsByPlayerId_thenReturnTransactionList() {

        given(repository.findByPlayerId(playerId))
                .willReturn(transactionList);

        List<Transaction> transactions = repository.findByPlayerId(playerId);

        assertThat(transactions).hasSize(4);
    }

}
