package ru.dungeons.AdventurersGuild.controller;

import characterData.Character;
import characterData.statGrid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dungeons.AdventurersGuild.repository.CharacterRepositoryI;
import ru.dungeons.AdventurersGuild.service.CharacterService;
import serverEntities.Player;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/characters")
@AllArgsConstructor
public class CharacterController {
    private CharacterService service;

    @GetMapping
    public List<Character> getCharacters(){
        return this.service.getCharacters();
    }

    @PostMapping("/new")
    Character saveCharacter(@RequestBody Character character){
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
