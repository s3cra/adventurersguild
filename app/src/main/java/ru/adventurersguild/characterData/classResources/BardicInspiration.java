package ru.adventurersguild.characterData.classResources;

import ru.adventurersguild.stuff.Dice;

public class BardicInspiration {
    int available;
    int maximum;
    Dice dice;

    public BardicInspiration(int _max){
        this.available = _max;
        this.maximum = _max;
        this.dice = Dice.d6;
    }

    public void refill(){
        this.available = this.maximum;
    }

    public boolean spend(int _amount){
        if (_amount < 0 || _amount < this.maximum) return false;
        this.available -= _amount;
        return true;
    }

    public void add(int n){
        this.available = Math.max(Math.min(this.maximum, this.available+n),0);

    }

}
