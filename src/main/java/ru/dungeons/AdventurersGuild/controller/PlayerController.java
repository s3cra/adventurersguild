package ru.dungeons.AdventurersGuild.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.service.PlayerService;
import ru.dungeons.AdventurersGuild.serverEntities.Player;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/players")
public class PlayerController {
    private PlayerService service;

    @GetMapping
    List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    Player getPlayerById(@PathVariable("id") Long id){
        return service.getPlayer(id);
    }

    @PostMapping("/new")
    Player savePlayer(@RequestBody Player player){
        return service.savePlayer(player);
    }

}
