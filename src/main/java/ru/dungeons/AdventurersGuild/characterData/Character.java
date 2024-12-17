package ru.dungeons.AdventurersGuild.characterData;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ru.dungeons.AdventurersGuild.serverEntities.User;
import ru.dungeons.AdventurersGuild.stuff.Item;
import ru.dungeons.AdventurersGuild.stuff.Target;

@Data
@Entity
@NoArgsConstructor
public class Character extends InGameEntity implements Target {

    @Id
    @GeneratedValue
    Long id;
    @JsonIgnore
    @ManyToOne
    User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    chRace race;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "character", fetch = FetchType.EAGER)
    List<chClass> classes = new ArrayList<>();
    String personality;
    String ideals;
    String bonds;
    String flaws;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public Character(@JsonProperty("name") String name,@JsonProperty("race") chRace race,@JsonProperty("classes") List<chClass> classes
            ,@JsonProperty("maxHP") int maxHP,@JsonProperty("currHP") int currHP,@JsonProperty("inventory") List<Item> inventory
            ,@JsonProperty("stats") statGrid stats,@JsonProperty("personality") String personality,@JsonProperty("ideals") String ideals
            ,@JsonProperty("bonds") String bonds,@JsonProperty("flaws") String flaws) {
        super(name, stats, maxHP, currHP, (ArrayList<Item>) inventory);
        this.race = race;
        this.classes = classes;
        this.classes.forEach(_class -> {
            _class.character = this;
        });
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
