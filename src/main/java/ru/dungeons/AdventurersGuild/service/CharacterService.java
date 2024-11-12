package ru.dungeons.AdventurersGuild.service;

import characterData.Character;
import characterData.statGrid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService {

    public List<characterData.Character> get_all_characters(){
        return characterData.Character.characters;
    }

    public void create_character(String _name, String _race, String _class,
                                 int _str, int _dex, int _con, int _int, int _wis, int _cha,
                                 String _personality, String _ideals, String _bonds, String _flaws){
        new Character(_name, _race, _class, new statGrid(
                _str,_dex,_con,_int,_wis,_cha
        ), _personality,_ideals,_bonds,_flaws);
    }
}
