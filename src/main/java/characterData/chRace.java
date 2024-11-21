package characterData;


import characterData.classes.Fighter;
import characterData.classes.Wizard;
import characterData.races.*;
import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Elf.class, name = "Elf"),

        @JsonSubTypes.Type(value = Orc.class, name = "Orc") }
)
public abstract class chRace {
    statGrid stats;
    Size size;
    int speed;
    boolean darkVision;
    Language[] langs;



    public static chRace getByName(String name){

        switch (name){
            case "Orc":
                return new Orc();
            case "Elf":
                return new Elf();
            default:
                return  new Orc();
        }
    }
    @JsonIgnore
    public String getRaceName(){
        return "";
    };
}
