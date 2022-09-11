package com.mt.wallet.transaction.repository;

import com.mt.wallet.transaction.model.entity.Transaction;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
@DynamicUpdate
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByPlayerId(long playerId);
}
