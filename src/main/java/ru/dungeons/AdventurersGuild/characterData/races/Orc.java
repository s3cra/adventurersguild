package ru.dungeons.AdventurersGuild.characterData.races;

import jakarta.persistence.Entity;
import ru.dungeons.AdventurersGuild.characterData.Character;
import ru.dungeons.AdventurersGuild.characterData.Language;
import ru.dungeons.AdventurersGuild.characterData.Size;
import ru.dungeons.AdventurersGuild.characterData.chRace;
import ru.dungeons.AdventurersGuild.characterData.statGrid;

@Entity
public class Orc extends chRace {


    public Orc(){
        super(Size.medium,
                30,
                true,
                new Language[]{Language.Common, Language.Orc});
    }

    public String getRaceName(){
        return "Orc";
    }
}
