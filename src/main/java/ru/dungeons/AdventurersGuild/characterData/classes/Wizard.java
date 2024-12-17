package ru.dungeons.AdventurersGuild.characterData.classes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dungeons.AdventurersGuild.characterData.chClass;
import ru.dungeons.AdventurersGuild.characterData.classResources.SpellSlots;
import ru.dungeons.AdventurersGuild.characterData.spells.Spell;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Wizard extends chClass {

    @OneToOne
    SpellSlots spellSlots;

    public Wizard(int level, SpellSlots slots, List<Spell> spells){
        super("Wizard", level);
        if (slots == null){
            this.spellSlots = new SpellSlots();
        } else {
            this.spellSlots = slots;
        }
    }

}
