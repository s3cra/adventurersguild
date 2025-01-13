package ru.adventurersguild.characterData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.adventurersguild.characterData.classResources.SpellSlots;
import ru.adventurersguild.characterData.classes.*;
import ru.adventurersguild.characterData.spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wizard.class, name = "Wizard"),

        @JsonSubTypes.Type(value = Fighter.class, name = "Fighter") }
)
public abstract class chClass {
    @JsonIgnore
    String className;
    int level = 1;
    List<Spell> spells;

    protected chClass(String className, int level){
        this.className = className;
        this.level = level;
    }

    public static chClass getByName(String name){

        switch (name){
            case "Fighter":
                return new Fighter(1);
            case "Wizard":
                return new Wizard(1, new SpellSlots(), new ArrayList<Spell>());
            default:
                return new Fighter(1);
        }
    }



    public String toClassDataString(){
        return this.getClassName() + " | " + this.level + "   ";
    }

}
