package ru.dungeons.AdventurersGuild.characterData.spells;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dungeons.AdventurersGuild.characterData.chClass;
import ru.dungeons.AdventurersGuild.stuff.Item;

@Data
@Entity
@NoArgsConstructor
@Table(name = "spells")
public abstract class Spell {
    @JsonIgnore
    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    Item item;
    @ManyToOne
    chClass owner;
    @Enumerated(EnumType.STRING)
    SpellType type;
    String name;
    Integer range;
    Integer radius;

    Spell(String _name, SpellType _type, int _range, int _radius){
        this.name = _name;
        this.type = _type;
        this.range = _range;
        this.radius = _radius;
    }


    public void Cast(){};
}
