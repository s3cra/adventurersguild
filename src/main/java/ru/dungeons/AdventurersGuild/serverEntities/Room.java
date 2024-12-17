package ru.dungeons.AdventurersGuild.serverEntities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue
    Long id;
    String campaign;
    @ManyToOne
    User host;
    List<Character> playersCharacters;

    public Room(User host, String campaign){
        this.host = host;
        this.campaign = campaign;
        this.playersCharacters = new ArrayList<>();
    }

    public int join(Character playerCharacter){
        this.playersCharacters.add(playerCharacter);
        return 0;
    }
}
