package ru.dungeons.AdventurersGuild.serverEntities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    Long id;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Character.class, mappedBy = "user", fetch = FetchType.EAGER)
    List<Character> characters = new ArrayList<Character>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "host")
    List<Room> rooms = new ArrayList<Room>();
    @Column(unique = true)
    private String login;
    private String password;
    private String roles;

    public void addCharacter(Character character){
        this.characters.add(character);
        character.setUser(this);
    }
    public void updateCharacter(Character character) {
        if (this.characters == null || character == null) return;
        int index = this.characters.stream().filter(character1 -> character1.getName().equals(character.getName()))
                .map(character1 -> this.characters.indexOf(character1))
                .findFirst().orElse(null);
        this.characters.set(index, character);
    }
    public void removeCharacter(String name){
        this.characters.stream().filter(character -> character.getName().equals(name)).forEach(character -> {
            this.characters.remove(character);
        });
    }
}
