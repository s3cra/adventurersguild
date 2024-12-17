package ru.dungeons.AdventurersGuild.characterData;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dungeons.AdventurersGuild.stuff.Item;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Character.class, name = "Character")}
)
@Table(name = "ingame_entities")
public abstract class InGameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    statGrid stats;
    int maxHP, currHP;
    @OneToMany(targetEntity = Item.class, mappedBy = "owner", fetch = FetchType.EAGER)
    ArrayList<Item> inventory;

    public InGameEntity(String name, statGrid stats, int maxHP, int currHP, ArrayList<Item> inventory) {
        this.name = name;
        this.stats = stats;
        this.stats.setOwner(this);
        this.maxHP = maxHP;
        this.currHP = currHP;
        this.inventory = inventory;
        this.inventory.forEach(item -> {
            item.setOwner(this);
        });
    }
}