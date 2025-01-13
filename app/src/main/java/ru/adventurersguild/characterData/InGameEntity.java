package ru.adventurersguild.characterData;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.adventurersguild.stuff.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Character.class, name = "Character")}
)
public abstract class InGameEntity {
    String name;
    statGrid stats;
    int maxHP, currHP;
    ArrayList<Item> inventory;


}
