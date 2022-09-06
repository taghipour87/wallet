package com.mt.wallet.transaction.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
@Data
@Builder
public class PaymentRequestDto {
    private UUID transactionId;
    private long playerId;
    private BigDecimal amount;
}
