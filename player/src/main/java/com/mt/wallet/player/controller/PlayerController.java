package com.mt.wallet.player.controller;

import com.mt.wallet.player.model.dto.PlayerResponseDto;
import com.mt.wallet.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammad Taghipour
 * @Date 8/30/2022
 */
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;

    @GetMapping("/")
    public ResponseEntity<PlayerResponseDto> getPlayerById(@RequestParam long playerId) {
        PlayerResponseDto dto = service.findById(playerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

}
