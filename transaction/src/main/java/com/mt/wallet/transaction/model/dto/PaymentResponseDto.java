package com.mt.wallet.transaction.model.dto;

import com.mt.wallet.transaction.model.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@Data
@Builder
public class PaymentResponseDto {
    private long playerId;
    private String accountNumber;
    private UUID transactionId;
    private Status status;
    private LocalDateTime transactionDateTime;
}
