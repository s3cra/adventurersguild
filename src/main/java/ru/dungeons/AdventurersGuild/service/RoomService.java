package ru.dungeons.AdventurersGuild.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dungeons.AdventurersGuild.repository.RoomRepositoryI;
import ru.dungeons.AdventurersGuild.serverEntities.User;
import ru.dungeons.AdventurersGuild.serverEntities.Room;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepositoryI repo;

    public Room getRoom(Long id){
        return this.repo.getRoom(id);
    }

    public Room hostRoom(User host, String campaign){
        return this.repo.hostRoom(host, campaign);
    }
}
