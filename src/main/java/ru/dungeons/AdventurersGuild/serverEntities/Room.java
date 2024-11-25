package ru.dungeons.AdventurersGuild.serverEntities;


import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class Room {
    Long id;
    String campaign;
    Player host;
    List<Character> playersCharacters;

    public Room(Player host, String campaign){
        this.host = host;
        this.campaign = campaign;
        this.playersCharacters = new ArrayList<>();
    }

    public int join(Character playerCharacter){
        this.playersCharacters.add(playerCharacter);
        return 0;
    }
}
