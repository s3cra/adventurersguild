package ru.adventurersguild.characterData.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.adventurersguild.characterData.chClass;
import lombok.Getter;

@Getter
public class Fighter extends chClass {

    @JsonCreator
    public Fighter(@JsonProperty("level") int level) {
        super("Fighter", level);
    }

}
