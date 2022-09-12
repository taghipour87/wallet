package com.mt.wallet.transaction.repository;

import com.mt.wallet.transaction.model.entity.Status;
import com.mt.wallet.transaction.model.entity.Transaction;
import com.mt.wallet.transaction.model.entity.Type;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository repository;

    @Test
    void save() {
        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID())
                .playerId(1)
                .accountNumber("123456789121")
                .status(Status.CREATED)
                .type(Type.CREDIT)
                .build();
        transaction =repository.save(transaction);
        Assertions.assertNotNull(transaction);
    }

    @Test
    void checkIdempotency() {
        UUID uuid = UUID.randomUUID();
        Transaction transaction_1 = Transaction.builder()
                .transactionId(uuid)
                .playerId(1)
                .accountNumber("123456789121")
                .status(Status.CREATED)
                .type(Type.CREDIT)
                .build();
        Transaction transaction_2 = Transaction.builder()
                .transactionId(uuid)
                .playerId(1)
                .accountNumber("123456789121")
                .status(Status.CREATED)
                .type(Type.CREDIT)
                .build();;
        transaction_1 =repository.save(transaction_1);
        try {
            transaction_2 = repository.save(transaction_2);
            System.out.println();
        } catch (Exception e) {
            Assertions.assertInstanceOf(DataIntegrityViolationException.class, e, "transactionId is not unique");
        }
    }

}
