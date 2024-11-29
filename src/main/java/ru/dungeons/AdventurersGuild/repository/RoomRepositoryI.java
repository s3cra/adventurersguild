package ru.dungeons.AdventurersGuild.repository;

import ru.dungeons.AdventurersGuild.serverEntities.User;
import ru.dungeons.AdventurersGuild.serverEntities.Room;

public interface RoomRepositoryI {
    Room getRoom(Long id);
    Room hostRoom(User host, String campaign);
}
