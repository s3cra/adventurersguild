package ru.dungeons.AdventurersGuild.serverEntities;

import jakarta.persistence.*;
import lombok.Data;
import ru.dungeons.AdventurersGuild.characterData.Character;

import java.util.List;

@Data
@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue
    Long id;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Character.class, mappedBy = "player")
    List<Character> characters;

}
