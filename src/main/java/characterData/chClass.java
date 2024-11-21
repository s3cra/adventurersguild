package characterData;

import characterData.classResources.SpellSlots;
import characterData.classes.*;
import characterData.races.Orc;
import characterData.spells.Spell;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wizard.class, name = "Wizard"),

        @JsonSubTypes.Type(value = Fighter.class, name = "Fighter") }
)
public abstract class chClass {
    @JsonIgnore
    String className;
    int level;

    protected chClass(String className, int level){
        this.className = className;
        this.level = level;
    }
    public static chClass getByName(String name){

        switch (name){
            case "Fighter":
                return new Fighter(1);
            case "Wizard":
                return new Wizard(1,new SpellSlots(), new ArrayList<Spell>());
            default:
                return new Fighter(1);
        }
    }


}
