package com.mt.wallet.player.service;

import com.mt.wallet.player.model.dto.PlayerResponseDto;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
public interface PlayerService {
    PlayerResponseDto findById(long playerId);
}
