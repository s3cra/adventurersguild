package ru.dungeons.AdventurersGuild.controller;

import characterData.Character;
import characterData.statGrid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/characters")
public class CharacterController {
    @GetMapping("getAll")
    public List<Character> getc(){
        return Character.characters;
    }

}
