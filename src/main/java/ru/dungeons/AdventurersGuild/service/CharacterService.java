package ru.dungeons.AdventurersGuild.service;

import characterData.Character;
import characterData.statGrid;
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

    public void create_character(String _name, String _race, String _class,
                                 int _str, int _dex, int _con, int _int, int _wis, int _cha,
                                 String _personality, String _ideals, String _bonds, String _flaws){
        new Character(_name, _race, _class, new statGrid(
                _str,_dex,_con,_int,_wis,_cha
        ), _personality,_ideals,_bonds,_flaws);
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
