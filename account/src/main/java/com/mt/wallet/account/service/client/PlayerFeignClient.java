package com.mt.wallet.account.service.client;

import com.mt.wallet.account.model.dto.PlayerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mohammad Taghipour
 * @Date 9/5/2022
 */
@FeignClient("player")
public interface PlayerFeignClient {

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlayerResponseDto> getPlayer(@RequestParam long playerId);

}
