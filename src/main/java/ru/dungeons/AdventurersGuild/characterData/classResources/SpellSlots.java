package ru.dungeons.AdventurersGuild.characterData.classResources;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SpellSlots {
    Map<Integer, Integer> available = new HashMap<>();
    Map<Integer, Integer> maximum = new HashMap<>();

    public SpellSlots(){
        this.maximum.put(1,2);
        for (int i=2; i<10; i++ ){
            this.maximum.put(i,0);
        }
        this.available.putAll(this.maximum);
    }

    public void refill(){
        this.available.putAll(this.maximum);
    }

    public boolean spend(int _level, int _quantity){
        if (this.available.get(_level) < _quantity)return false;
        this.available.put(_level,Math.max(Math.min(this.maximum.get(_level), this.available.get(_level) - _quantity),0));
        return true;
    }


    public void add(int _level, int _quantity){
        this.available.put(_level,Math.max(Math.min(this.maximum.get(_level), this.available.get(_level) + _quantity),0));
    }

    public String toString(){
        String _slots = "";
        for (int i=1; i<10; i++ ){
            _slots+= i + "Level: [" + this.available.get(i) + "/" + this.maximum.get(i) + "]\n";
        }
        return _slots;
    }
}
