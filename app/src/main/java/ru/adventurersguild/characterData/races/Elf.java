package ru.adventurersguild.characterData.races;

import ru.adventurersguild.characterData.Language;
import ru.adventurersguild.characterData.Size;
import ru.adventurersguild.characterData.chRace;
import ru.adventurersguild.characterData.statGrid;

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
