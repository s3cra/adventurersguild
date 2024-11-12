package characterData;


import static characterData.statGrid.sum;

import java.util.ArrayList;
import java.util.List;

import stuff.Item;
import stuff.Target;

public class Character implements Target {
    String name;
    public String getName() {
        return this.name;
    }
    chRace race;
    public String getRace() {
        return this.race.getRaceName();
    }
    ArrayList<chClass> classes = new ArrayList<>();
    public ArrayList<chClass> getClasses(){return this.classes;}
    int maxHP;
    public int getMaxHP() {return maxHP;}
    int currHP;
    public int getCurrHP() {return currHP;}
    ArrayList<Item> inventory;
    public ArrayList<Item> getInventory() {return inventory;}

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
    public statGrid getStats(){
        return this.stats;
    }
    String personality;
    public String getPersonality() {
        return personality;
    }
    String ideals;
    public String getIdeals() {
        return ideals;
    }
    String bonds;
    public String getBonds() {
        return bonds;
    }
    String flaws;
    public String getFlaws() {
        return flaws;
    }

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
                     String _personality, String _ideals, String _bonds, String _flaws){

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
