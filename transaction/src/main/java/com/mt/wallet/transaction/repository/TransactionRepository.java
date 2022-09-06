package com.mt.wallet.transaction.repository;

import com.mt.wallet.transaction.model.entity.Transaction;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
@DynamicUpdate
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findFirstByPlayerIdOrderByCreatedDateTimeDesc(long playerId);

    List<Transaction> findByPlayerId(long playerId);
}
