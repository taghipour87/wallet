package com.mt.wallet.player.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
@Data
@Builder
public class PlayerResponseDto {
    private long playerId;
    private String accountNumber;
}
