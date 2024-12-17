package ru.dungeons.AdventurersGuild.characterData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@Table(name = "stat_grids")
public class statGrid {
    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    InGameEntity owner;

    @NonNull
    Integer strength;
    @NonNull
    Boolean athletics = false;
    //-------------------
    @NonNull
    Integer dexterity;
    @NonNull
    Boolean acrobatics = false;
    @NonNull
    Boolean sleight_of_hand = false;
    @NonNull
    Boolean stealth = false;
    //-------------------
    @NonNull
    Integer constitution;
    @NonNull
    Integer intelligence;
    @NonNull
    Boolean arcana = false;
    @NonNull
    Boolean history = false;
    @NonNull
    Boolean investigation = false;
    @NonNull
    Boolean nature = false;
    @NonNull
    Boolean religion = false;
    //-------------------
    @NonNull
    Integer wisdom;
    @NonNull
    Boolean animal_handling = false;
    @NonNull
    Boolean insight = false;
    @NonNull
    Boolean medicine = false;
    @NonNull
    Boolean perception = false;
    @NonNull
    Boolean survival = false;
    //-------------------
    @NonNull
    Integer charisma;
    @NonNull
    Boolean deception = false;
    @NonNull
    Boolean intimidation = false;
    @NonNull
    Boolean performance = false;
    @NonNull
    Boolean persuasion = false;
    //-------------------
}
