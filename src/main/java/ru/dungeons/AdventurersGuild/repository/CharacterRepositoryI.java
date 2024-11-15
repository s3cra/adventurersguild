package ru.dungeons.AdventurersGuild.repository;

import characterData.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepositoryI {

    List<Character> getCharacters();
    Character saveCharacter(Character character);
    Character getCharacter(String name);
    Character updateCharacter(Character character);
    void deleteCharacter(String name);
}
