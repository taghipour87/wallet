package com.mt.wallet.account.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 9/6/2022
 */
@Data
@Builder
public class AccountResponseDto {
    private UUID transactionId;
    private String accountNumber;
}
