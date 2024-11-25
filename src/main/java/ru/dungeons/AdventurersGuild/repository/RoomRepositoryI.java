package ru.dungeons.AdventurersGuild.repository;

import ru.dungeons.AdventurersGuild.serverEntities.Player;
import ru.dungeons.AdventurersGuild.serverEntities.Room;

public interface RoomRepositoryI {
    Room getRoom(Long id);
    Room hostRoom(Player host, String campaign);
}
