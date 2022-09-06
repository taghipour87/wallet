package com.mt.wallet.transaction.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/5/2022
 */
@Data
public class TransactionRequestDto {
    private long playerId;
    private BigDecimal amount;
}
