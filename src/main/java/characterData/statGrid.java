package characterData;

import java.util.HashMap;
import java.util.Map;

public final class statGrid {
    int strength;
    public int getStrength() {
        return strength;
    }
    Map<String, Boolean> str_skills = Map.of(
            "Athletics", false
    );

    int dexterity;
    public int getDexterity() {
        return dexterity;
    }
    Map<String, Boolean> dex_skills = Map.of(
            "Acrobatics", false,
            "Sleight of Hand", false,
            "Stealth", false
    );

    int constitution;
    public int getConstitution() {
        return constitution;
    }

    int intelligence;
    public int getIntelligence() {
        return intelligence;
    }
    Map<String, Boolean> int_skills = Map.of(
            "Arcana", false,
            "History", false,
            "Investigation", false,
            "Nature", false,
            "Religion", false
    );

    int wisdom;
    public int getWisdom() {
        return wisdom;
    }
    Map<String, Boolean> wis_skills = Map.of(
            "Animal Handling", false,
            "Insight", false,
            "Medicine", false,
            "Perception", false,
            "Survival", false
    );

    int charisma;
    public int getCharisma() {
        return charisma;
    }
    Map<String, Boolean> cha_skills = Map.of(
            "Deception", false,
            "Intimidation", false,
            "Performance", false,
            "Persuasion", false
    );



    public statGrid(int strength, int dexterity, int constitution,
                    int intelligence, int wisdom, int charisma){
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    static statGrid sum(statGrid a, statGrid b){
        return new statGrid(a.strength+ b.strength, a.dexterity+b.dexterity,
                a.constitution+b.constitution, a.intelligence+b.intelligence,
                a.wisdom+b.wisdom, a.charisma+b.charisma);
    }

    @Override
    public String toString(){
        return "STR: " + (this.strength) + "; " +
                "WIS: " + (this.wisdom) + "; "+ '\n' +
                "DEX: " + (this.dexterity) + "; "+
                "INT: " + (this.intelligence) + "; "+ '\n' +
                "CON: " + (this.constitution) + "; "+
                "CHA: " + (this.charisma) + "; ";
    }


}
