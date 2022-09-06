package com.mt.wallet.player.repository;

import com.mt.wallet.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mohammad Taghipour
 * @Date 8/30/2022
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
