package ru.dungeons.AdventurersGuild.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dungeons.AdventurersGuild.serverEntities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
