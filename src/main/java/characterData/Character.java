package characterData;


import static characterData.statGrid.sum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import stuff.Item;
import stuff.Target;

@Getter
public class Character implements Target {
    String name;
    chRace race;
    List<chClass> classes = new ArrayList<>();
    int maxHP;
    int currHP;
    List<Item> inventory;

    //todo front
//    public String getClassesString() {
//        String _classes = "";
//
//        for (chClass _cl:
//             classes) {
//            _classes += _cl.getClassData();
//        }
//
//        return _classes;
//    }

    statGrid stats;
    String personality;
    String ideals;
    String bonds;
    String flaws;

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

    @JsonCreator
    public Character(@JsonProperty String name,@JsonProperty String _race,@JsonProperty String _class,@JsonProperty statGrid _stats,
                     @JsonProperty String _personality,@JsonProperty String _ideals,@JsonProperty String _bonds,@JsonProperty String _flaws){

        this.name = name;
        this.race = chRace.getByName(_race);
        this.classes.add(chClass.getByName(_class));
        this.stats = sum(_stats,this.race.stats);
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

}
