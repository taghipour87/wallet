package com.mt.wallet.account.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */

@Entity
@Data
public class Account {

    @Id
    private long id;
    @Column(nullable = false)
    private BigDecimal balance = new BigDecimal(0);
    @Column(nullable = false, length = 17)
    private String accountNumber;
    @Column(nullable = false)
    private long playerId;
    @Column(nullable = false)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
    @Version
    private long version;


}
