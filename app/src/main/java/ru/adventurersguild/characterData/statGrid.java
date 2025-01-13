package ru.adventurersguild.characterData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Jacksonized
public class statGrid {

    @NonNull
    Integer strength;
    Boolean athletics = false;
    //-------------------
    @NonNull
    Integer dexterity;
    Boolean acrobatics = false;
    Boolean sleight_of_hand = false;
    Boolean stealth = false;
    //-------------------
    @NonNull
    Integer constitution;
    @NonNull
    Integer intelligence;
    Boolean arcana = false;
    Boolean history = false;
    Boolean investigation = false;
    Boolean nature = false;
    Boolean religion = false;
    //-------------------
    @NonNull
    Integer wisdom;
    Boolean animal_handling = false;
    Boolean insight = false;
    Boolean medicine = false;
    Boolean perception = false;
    Boolean survival = false;
    //-------------------
    @NonNull
    Integer charisma;
    Boolean deception = false;
    Boolean intimidation = false;
    Boolean performance = false;
    Boolean persuasion = false;
    //-------------------
    public static statGrid sum(statGrid a, statGrid b){
        return new statGrid(
                a.strength+b.strength,
                a.dexterity+b.dexterity,
                a.constitution+b.constitution,
                a.intelligence+b.intelligence,
                a.wisdom+b.wisdom,
                a.charisma+ b.charisma
        );
    }
}
