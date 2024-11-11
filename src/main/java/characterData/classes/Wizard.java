package characterData.classes;

import java.util.ArrayList;

import characterData.chClass;
import characterData.classResources.SpellSlots;
import characterData.spells.Spell;

public class Wizard extends chClass {
    SpellSlots spellSlots = new SpellSlots();
    ArrayList<Spell> spells;

    public Wizard(){
        super();
    }

    public String getClassName(){
        return "Wizard";
    }
}
