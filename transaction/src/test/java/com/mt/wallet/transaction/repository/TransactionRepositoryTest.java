package com.mt.wallet.transaction.repository;

import com.mt.wallet.transaction.model.entity.Status;
import com.mt.wallet.transaction.model.entity.Transaction;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository repository;

    @SneakyThrows
    @Test
    void save() {
        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("123456789121")
                .status(Status.CREATED)
                .build();
        repository.save(transaction);

    }

}
