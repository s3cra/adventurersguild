package characterData;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public final class statGrid {

    int strength;
    Map<String, Boolean> str_skills = Map.of(
            "Athletics", false
    );

    int dexterity;
    Map<String, Boolean> dex_skills = Map.of(
            "Acrobatics", false,
            "Sleight of Hand", false,
            "Stealth", false
    );

    int constitution;

    int intelligence;
    Map<String, Boolean> int_skills = Map.of(
            "Arcana", false,
            "History", false,
            "Investigation", false,
            "Nature", false,
            "Religion", false
    );

    int wisdom;
    Map<String, Boolean> wis_skills = Map.of(
            "Animal Handling", false,
            "Insight", false,
            "Medicine", false,
            "Perception", false,
            "Survival", false
    );

    int charisma;
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
