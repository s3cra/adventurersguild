package characterData.classes;

import java.util.ArrayList;
import java.util.List;

import characterData.chClass;
import characterData.classResources.SpellSlots;
import characterData.spells.Spell;
import lombok.Getter;

@Getter
public class Wizard extends chClass {

    SpellSlots spellSlots;
    List<Spell> spells;

    public Wizard(int level, SpellSlots slots, List<Spell> spells){
        super("Wizard", level);
        if (slots == null){
            this.spellSlots = new SpellSlots();
        } else {
            this.spellSlots = slots;
        }
        if (spells == null){
            this.spells = new ArrayList<>();
        } else {
            this.spells = spells;
        }
    }

}
