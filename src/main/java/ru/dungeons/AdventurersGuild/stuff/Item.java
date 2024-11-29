package ru.dungeons.AdventurersGuild.stuff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ru.dungeons.AdventurersGuild.characterData.Character;
import ru.dungeons.AdventurersGuild.characterData.spells.Spell;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;
    @JsonIgnore
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne
    Character owner;
    @JsonProperty("isWeapon")
    boolean isWeapon;
    @JsonProperty("isArmor")
    boolean isArmor;
    @JsonProperty("name")
    String name;
    @JsonProperty("ability")
    @OneToOne
    Spell ability;


    void Use(){
       this.ability.Cast();
    }
}
