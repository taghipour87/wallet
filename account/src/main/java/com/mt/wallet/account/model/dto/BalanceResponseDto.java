package com.mt.wallet.account.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
@Data
@Builder
public class BalanceResponseDto {
    private BigDecimal balance;
}
