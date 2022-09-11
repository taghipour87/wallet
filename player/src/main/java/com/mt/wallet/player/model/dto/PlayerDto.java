package com.mt.wallet.player.model.dto;

import com.mt.wallet.player.model.entity.Status;
import lombok.Data;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
@Data
public class PlayerDto {
    private long id;
    private String accountNumber;
    private Status playerStatus;
}
