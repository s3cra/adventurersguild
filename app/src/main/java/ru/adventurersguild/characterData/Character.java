package ru.adventurersguild.characterData;


import static ru.adventurersguild.characterData.statGrid.sum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
import ru.adventurersguild.stuff.Item;
import ru.adventurersguild.stuff.Target;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class Character extends InGameEntity implements Target {
    chRace race;
    ArrayList<chClass> classes = new ArrayList<>();
    String personality, ideals, bonds, flaws;

    public int getLevel(){
        int _level = 0;
        for (chClass _cl:
                classes) {
            _level += _cl.level;
        }
        return _level;
    }
    public int getLevel(chClass _class){
        if (!this.classes.contains(_class)) return 0;
        return this.classes.get(this.classes.indexOf(_class)).level;
    }

    public Character(String name, String _race, String _class, statGrid _stats,
                     String _personality, String _ideals, String _bonds, String _flaws,
                     int _maxHP, int _currHP){
        super(name, sum(_stats,chRace.getByName(_race).stats), _maxHP, _currHP, new ArrayList<>());
        this.race = chRace.getByName(_race);
        this.classes.add(chClass.getByName(_class));
        this.personality = _personality;
        this.ideals = _ideals;
        this.bonds = _bonds;
        this.flaws = _flaws;
    }

    public void takeDamage() {

    }

    public void addItem(Item _item){
        this.inventory.add(_item);
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public String classesToString() {
        String _classes = "";

        for (chClass _cl:
                classes) {
            _classes += _cl.toClassDataString();
        }

        return _classes;
    }


}
