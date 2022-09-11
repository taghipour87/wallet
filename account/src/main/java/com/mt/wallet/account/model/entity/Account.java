package com.mt.wallet.account.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Account {

    @Id
    private long id;
    @Column(nullable = false)
    private BigDecimal balance = new BigDecimal(0);
    @Column(nullable = false, length = 17, unique=true)
    private String accountNumber;
    @Column(nullable = false, unique=true)
    private long playerId;
    @Column(nullable = false)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
    @Version
    private long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
