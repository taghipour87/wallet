package com.mt.wallet.player.service;

import com.mt.wallet.player.exception.PlayerException;
import com.mt.wallet.player.model.dto.PlayerResponseDto;
import com.mt.wallet.player.model.entity.Player;
import com.mt.wallet.player.model.entity.Status;
import com.mt.wallet.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.mt.wallet.player.constant.Error.PLAYER_DOES_NOT_EXIST;
import static com.mt.wallet.player.constant.Error.PLAYER_IS_DISABLED;

/**
 * @AUTHOR Mohammad Taghipour
 * @DATE 9/11/2022
 */
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    @Override
    public PlayerResponseDto findById(long playerId) {
        Player player = repository.findById(playerId)
                .orElseThrow(() -> new PlayerException(HttpStatus.INTERNAL_SERVER_ERROR, PLAYER_DOES_NOT_EXIST));
        if (player.getStatus().equals(Status.INACTIVE))
            throw new PlayerException(HttpStatus.INTERNAL_SERVER_ERROR, PLAYER_IS_DISABLED);
        return PlayerResponseDto.builder()
                .playerId(playerId)
                .accountNumber(player.getAccountNumber())
                .build();
    }
}
