package ru.dungeons.AdventurersGuild.characterData;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.dungeons.AdventurersGuild.characterData.classResources.SpellSlots;
import ru.dungeons.AdventurersGuild.characterData.classes.*;
import ru.dungeons.AdventurersGuild.characterData.spells.Spell;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wizard.class, name = "Wizard"),

        @JsonSubTypes.Type(value = Fighter.class, name = "Fighter") }
)
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "classes")
public abstract class chClass {
    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;
    @JsonIgnore
    String className;
    @JsonIgnore
    @ManyToOne
    Character character;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    List<Spell> spells;
    int level;

    protected chClass(String className, int level){
        this.className = className;
        this.level = level;
    }


}
