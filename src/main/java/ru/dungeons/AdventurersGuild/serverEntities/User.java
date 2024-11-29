package ru.dungeons.AdventurersGuild.serverEntities;

import jakarta.persistence.*;
import lombok.Data;
import ru.dungeons.AdventurersGuild.characterData.Character;

import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    Long id;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Character.class, mappedBy = "user")
    List<Character> characters;
    @Column(unique = true)
    private String login;
    private String password;
    private String roles;
}
