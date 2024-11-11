package stuff;

import characterData.spells.Spell;

public class Item {
    boolean isWeapon;
    boolean isArmor;
    String name;
    Spell ability;

    Item(String _name, boolean _isWeapon, boolean _isArmor, Spell _ability){
        this.name = _name;
        this.isWeapon = _isWeapon;
        this.isArmor = _isArmor;
        this.ability = _ability;
    }

    void Use(){
        this.ability.Cast();
    }
}
