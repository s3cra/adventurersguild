package ru.adventurersguild.stuff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.adventurersguild.characterData.spells.Spell;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    boolean isWeapon;
    boolean isArmor;
    String name;
    Spell ability;

    @JsonCreator
    public Item(@JsonProperty("name") String _name,@JsonProperty("isWeapon") boolean _isWeapon
            ,@JsonProperty("isArmor") boolean _isArmor,@JsonProperty("ability") Spell _ability){
        this.name = _name;
        this.isWeapon = _isWeapon;
        this.isArmor = _isArmor;
        this.ability = _ability;
    }

    void Use(){
        this.ability.Cast();
    }

}
