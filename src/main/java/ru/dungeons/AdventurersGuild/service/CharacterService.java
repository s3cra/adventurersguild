package ru.dungeons.AdventurersGuild.service;

import ru.dungeons.AdventurersGuild.characterData.Character;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dungeons.AdventurersGuild.repository.CharacterRepositoryI;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterService {

    CharacterRepositoryI repository;

    public List<Character> getCharacters(){
        return this.repository.getCharacters();
    }

    public Character saveCharacter(Character character){
        return this.repository.saveCharacter(character);
    }
    public Character getCharacter(String name){
        return this.repository.getCharacter(name);
    }
    public Character updateCharacter(Character character){
        return this.repository.updateCharacter(character);
    }
    public void deleteCharacter(String name){
        this.repository.deleteCharacter(name);
    }
}
