package ru.dungeons.AdventurersGuild.controller;

import characterData.Character;
import characterData.statGrid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.service.CharacterService;
import serverEntities.Player;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/characters")
@AllArgsConstructor
public class CharacterController {
    private CharacterService service;

    @GetMapping
    public List<Character> getCharacters(@RequestParam Player player){
        return null;
    }
}
