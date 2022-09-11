package com.mt.wallet.transaction.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 36, unique=true)
    private UUID transactionId;
    @Column(nullable = false)
    private long playerId;
    @Column(length = 17)
    private String accountNumber;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private Type type;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
