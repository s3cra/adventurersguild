package ru.adventurersguild.characterData.classResources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellSlots {
    List<Integer> available;
    List<Integer> maximum;

    public SpellSlots(){
        this.maximum = List.of(2,0,0,0,0,0,0,0,0,0);
        this.available = List.copyOf(this.maximum);
    }

    public void refill(){
        this.available = List.copyOf(this.maximum);
    }

    public boolean spend(int _level, int _quantity){
        _level--;
        if (this.available.get(_level) < _quantity)return false;
        this.available.set(_level,Math.max(Math.min(this.maximum.get(_level), this.available.get(_level) - _quantity),0));
        return true;
    }


    public void add(int _level, int _quantity){
        _level--;
        this.available.set(_level,Math.max(Math.min(this.maximum.get(_level), this.available.get(_level) + _quantity),0));
    }

    public String toString(){
        String _slots = "";
        for (int i=1; i<10; i++ ){
            _slots+= i + "Level: [" + this.available.get(i-1) + "/" + this.maximum.get(i-1) + "]\n";
        }
        return _slots;
    }
}
