package ru.dungeons.AdventurersGuild.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.service.RoomService;
import ru.dungeons.AdventurersGuild.serverEntities.Room;

@RestController
@RequestMapping("/api/v1/rooms")
@AllArgsConstructor
public class RoomController {
    private RoomService service;

    @GetMapping("/{id}")
    Room getRoom(@PathVariable("id") Long id){
        return this.service.getRoom(id);
    }

    @PostMapping("/new")
    Room hostRoom(){
        //TODO
        return null;
    }
}
