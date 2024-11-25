package ru.dungeons.AdventurersGuild.repository;

import org.springframework.stereotype.Repository;
import ru.dungeons.AdventurersGuild.characterData.Character;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository implements CharacterRepositoryI {


    List<Character> characters = new ArrayList<>();

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
                    characters.set(characters.indexOf(character1), character);
                    return character;
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
