package ru.dungeons.AdventurersGuild.characterData;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.dungeons.AdventurersGuild.serverEntities.Player;
import ru.dungeons.AdventurersGuild.stuff.Item;
import ru.dungeons.AdventurersGuild.stuff.Target;

@Data
@Entity
public class Character implements Target {

    @Id
    @GeneratedValue
    Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "character")
    chRace race;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = chClass.class)
    List<chClass> classes = new ArrayList<>();
    int maxHP;
    int currHP;
    @OneToMany(targetEntity = Item.class)
    List<Item> inventory;
    @OneToOne(cascade = CascadeType.ALL)
    statGrid stats;
    String personality;
    String ideals;
    String bonds;
    String flaws;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public Character(String name, chRace race, List<chClass> classes, int maxHP, int currHP, List<Item> inventory
            , statGrid stats, String personality, String ideals, String bonds, String flaws) {
        this.name = name;
        this.race = race;
        this.race.character = this;
        this.classes = classes;
        this.classes.stream().forEach(_class -> {
            _class.character = this;
        });
        this.maxHP = maxHP;
        this.currHP = currHP;
        this.inventory = inventory;
        this.inventory.stream().forEach(item -> {
            item.setOwner(this);
        });
        this.stats = stats;
        this.stats.character = this;
        this.personality = personality;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
    }



    public int getLevel(){
        int _level = 0;
        for (chClass _cl:
                classes) {
            _level += _cl.level;
        }
        return _level;
    }
    public int getLevel(chClass _class){
        if (!this.classes.contains(_class)) return 0;
        return this.classes.get(this.classes.indexOf(_class)).level;
    }


    public void takeDamage() {

    }

    public void addItem(Item _item){
        this.inventory.add(_item);
    }

}
