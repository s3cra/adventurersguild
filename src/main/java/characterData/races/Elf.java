package characterData.races;

import characterData.Language;
import characterData.Size;
import characterData.chRace;
import characterData.statGrid;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;


public class Elf extends chRace {

    public Elf() {
        super(new statGrid(0,0,+1,+2,0,0),
                Size.medium,
                30,
                true,
                new Language[]{Language.Common, Language.Elvish});
    }

    public String getRaceName(){
        return "Elf";
    }
}
