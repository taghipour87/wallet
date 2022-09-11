package com.mt.wallet.account.repository;

import com.mt.wallet.account.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<Account> findWithLockingByPlayerId(long playerId);
    Optional<Account> findByPlayerId(long playerId);

}
