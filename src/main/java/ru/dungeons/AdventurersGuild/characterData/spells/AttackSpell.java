package ru.dungeons.AdventurersGuild.characterData.spells;

import ru.dungeons.AdventurersGuild.stuff.Dice;
import ru.dungeons.AdventurersGuild.stuff.Target;

public class AttackSpell extends Spell {
    DamageType dmgType;
    Dice dice;
    int diceQuantity;

    AttackSpell(String _name, SpellType _type, int _range, int _radius, DamageType _dmgType, Dice _dice, int _diceQuantity){
        super(_name, _type, _range, _radius);
        this.dmgType = _dmgType;
        this.dice = _dice;
        this.diceQuantity = _diceQuantity;
    }

    public void Cast(Target _target, int diceValue){

    }
}
