package com.mt.wallet.player.repository;

import com.mt.wallet.player.model.entity.Player;
import com.mt.wallet.player.model.entity.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author Mohammad Taghipour
 * @Date 9/7/2022
 */
@ExtendWith(MockitoExtension.class)
class PlayerRepositoryTest {

    @Mock
    private PlayerRepository repository;

    private Player player;

    @BeforeEach
    void setup() {
        player = Player.builder()
                .id(1L)
                .accountNumber("00000058398257466")
                .firstName("Mohammad")
                .lastName("Taghipour")
                .status(Status.ACTIVE)
                .createdDateTime(LocalDateTime.now())
                .build();
    }

    // JUnit test for savePlayer method
    @DisplayName("JUnit test for savePlayer method")
    @Test
    void givenPlayerObject_whenSavePlayer_thenReturnPlayerObject() {

        given(repository.save(player)).willReturn(player);

        Player savedPlayer = repository.save(player);

        assertThat(savedPlayer).isNotNull();
    }

    // JUnit test for findByPlayerId method
    @DisplayName("JUnit test for findByPlayerId method")
    @Test
    void givenPlayerId_whenFindByPlayerId_thenReturnPlayerObject() {
        given(repository.findById(1L)).willReturn(Optional.of(player));

        Player savedPlayer = repository.findById(player.getId()).orElse(null);

        assertThat(savedPlayer).isNotNull();
    }

}
