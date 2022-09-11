package com.mt.wallet.transaction.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 36)
    private UUID transactionId;
    @Column(nullable = false)
    private long playerId;
    @Column(length = 12)
    private String accountNumber;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private Type type;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

}
