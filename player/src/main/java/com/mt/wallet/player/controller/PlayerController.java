package com.mt.wallet.player.controller;

import com.mt.wallet.player.model.Player;
import com.mt.wallet.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammad Taghipour
 * @Date 8/30/2022
 */
@RestController("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository repository;

    @PostMapping
    public ResponseEntity<Player> insert(Player player) {
        player = repository.save(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

}
