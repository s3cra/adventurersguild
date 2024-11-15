package characterData.classes;

import java.util.ArrayList;

import characterData.chClass;
import characterData.classResources.SpellSlots;
import characterData.spells.Spell;
import lombok.Getter;

@Getter
public class Wizard extends chClass {

    static String className = "Fighter";
    SpellSlots spellSlots = new SpellSlots();
    ArrayList<Spell> spells;

    public Wizard(){
        super();
    }

}
