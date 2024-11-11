package characterData.spells;

public abstract class Spell {
    SpellType type;
    String name;
    int range;
    int radius;

    Spell(String _name, SpellType _type, int _range, int _radius){
        this.name = _name;
        this.type = _type;
        this.range = _range;
        this.radius = _radius;
    }


    public void Cast(){};
}
