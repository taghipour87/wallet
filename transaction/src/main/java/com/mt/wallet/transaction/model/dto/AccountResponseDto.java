package com.mt.wallet.transaction.model.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author Mohammad Taghipour
 * @Date 8/27/2022
 */

@Data
public class AccountResponseDto {
    private UUID transactionId;
    private String accountNumber;
}
