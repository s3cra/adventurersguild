package ru.adventurersguild.characterData;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ru.adventurersguild.characterData.races.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Elf.class, name = "Elf"),

        @JsonSubTypes.Type(value = Orc.class, name = "Orc") }
)
public abstract class chRace {
    statGrid stats;
    Size size;
    int speed;
    boolean darkVision;
    Language[] langs;


    protected chRace(statGrid stats, Size size, int speed, boolean darkVision, Language[] langs){
        this.stats = stats;
        this.size = size;
        this.speed = speed;
        this.darkVision = darkVision;
        this.langs = langs;
    }

    public static chRace getByName(String name){

        switch (name){
            case "Orc":
                return new Orc();
            case "Elf":
                return new Elf();
            default:
                return  new Orc();
        }
    }

    public String getRaceName(){
        return "";
    };
}
