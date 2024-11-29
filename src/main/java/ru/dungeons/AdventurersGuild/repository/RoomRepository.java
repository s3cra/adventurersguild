package ru.dungeons.AdventurersGuild.repository;

import org.springframework.stereotype.Repository;
import ru.dungeons.AdventurersGuild.serverEntities.User;
import ru.dungeons.AdventurersGuild.serverEntities.Room;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository implements RoomRepositoryI{
    private List<Room> rooms = new ArrayList<>();

    public Room getRoom(Long id){
        return this.rooms.stream()
                .filter(room -> room.getId().equals(id)).findFirst().orElse(null);
    }
    public Room hostRoom(User host, String campaign){
        Room _room = new Room(host,campaign);
        rooms.add(_room);
        return _room;
    }
}
