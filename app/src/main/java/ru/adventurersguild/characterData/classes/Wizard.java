package ru.adventurersguild.characterData.classes;

import java.util.ArrayList;
import java.util.List;

import ru.adventurersguild.characterData.chClass;
import ru.adventurersguild.characterData.classResources.SpellSlots;
import ru.adventurersguild.characterData.spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Wizard extends chClass {
    static final String className = "Wizard";
    SpellSlots spellSlots;

    public Wizard(int level, SpellSlots slots, List<Spell> spells){
        super("Wizard", level);
        this.spellSlots = slots;
    }

}
