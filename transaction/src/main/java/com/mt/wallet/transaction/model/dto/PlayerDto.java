package com.mt.wallet.transaction.model.dto;

import lombok.Data;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
@Data
public class PlayerDto {

    private long id;
    private String accountNumber;
    private PlayerStatus playerStatus;

}
