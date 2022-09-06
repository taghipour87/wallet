package com.mt.wallet.player.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Mohammad Taghipour
 * @Date 8/30/2022
 */

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 17)
    private String accountNumber;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;


}
