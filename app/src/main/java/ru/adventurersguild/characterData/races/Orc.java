package ru.adventurersguild.characterData.races;

import ru.adventurersguild.characterData.Language;
import ru.adventurersguild.characterData.Size;
import ru.adventurersguild.characterData.chRace;
import ru.adventurersguild.characterData.statGrid;

public class Orc extends chRace {


    public Orc(){
        super(new statGrid(+2,0,+1,0,0,0),
                Size.medium,
                30,
                true,
                new Language[]{Language.Common, Language.Orc});
    }

    public String getRaceName(){
        return "Orc";
    }
}
