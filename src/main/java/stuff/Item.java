package stuff;

import characterData.spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    boolean isWeapon;
    boolean isArmor;
    String name;
    Spell ability;


    void Use(){
        this.ability.Cast();
    }
}
