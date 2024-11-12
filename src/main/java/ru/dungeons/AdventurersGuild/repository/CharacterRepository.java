package ru.dungeons.AdventurersGuild.repository;

import characterData.statGrid;
import org.springframework.stereotype.Repository;
import characterData.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CharacterRepository implements CharacterRepositoryI {

    List<Character> characters = List.of(new Character("bro", "Elf", "Wizard", new statGrid(
            15,15,15,15,15,15
    ), "","","",""));

    @Override
    public List<Character> getCharacters(){
        return characters;
    }

    @Override
    public Character saveCharacter(Character character) {
        characters.add(character);
        return character;
    }

    @Override
    public Character getCharacter(String name) {
        return characters.stream().filter(n -> n.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Character updateCharacter(Character character) {
        return characters.stream().filter(n -> n.getName().equals(character.getName()))
                .findFirst().map(character1 -> {
                    characters.set(characters.indexOf(character), character1);
                    return character1;
                }).orElse(null);

    }

    @Override
    public void deleteCharacter(String name) {
        characters.stream().filter(character1 -> character1.getName().equals(name))
                .findFirst().map(character1 -> {
                    return characters.remove(character1);
                });
    }
}
