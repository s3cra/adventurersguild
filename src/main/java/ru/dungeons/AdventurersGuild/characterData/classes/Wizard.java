package ru.dungeons.AdventurersGuild.characterData.classes;

import java.util.ArrayList;
import java.util.List;

import ru.dungeons.AdventurersGuild.characterData.chClass;
import ru.dungeons.AdventurersGuild.characterData.classResources.SpellSlots;
import ru.dungeons.AdventurersGuild.characterData.spells.Spell;
import lombok.Getter;

@Getter
public class Wizard extends chClass {

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
