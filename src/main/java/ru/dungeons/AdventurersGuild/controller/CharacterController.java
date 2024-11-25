package ru.dungeons.AdventurersGuild.controller;

import ru.dungeons.AdventurersGuild.characterData.Character;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.serverEntities.Player;
import ru.dungeons.AdventurersGuild.service.CharacterService;
import ru.dungeons.AdventurersGuild.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/characters")
@AllArgsConstructor
public class CharacterController {
    private CharacterService service;
    private final PlayerService service2;

    @GetMapping
    public List<Character> getCharacters(){
        return this.service.getCharacters();
    }

    @PostMapping("/new")
    Character saveCharacter(@RequestBody Character character){
        Player pl = new Player();
        pl.setCharacters(List.of(character));
        service2.savePlayer(pl);
        return this.service.saveCharacter(character);
    }

    @GetMapping("/{name}")
    Character getCharacter(@PathVariable("name") String name){
        return this.service.getCharacter(name);
    }

    @PutMapping("/update")
    Character updateCharacter(@RequestBody Character character){
        return this.service.updateCharacter(character);
    }

    @DeleteMapping("/{name}")
    void deleteCharacter(@PathVariable("name") String name){
        this.service.deleteCharacter(name);
    }

}
