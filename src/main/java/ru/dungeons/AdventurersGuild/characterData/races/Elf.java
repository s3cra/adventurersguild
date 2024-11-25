package ru.dungeons.AdventurersGuild.characterData.races;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import ru.dungeons.AdventurersGuild.characterData.Character;
import ru.dungeons.AdventurersGuild.characterData.Language;
import ru.dungeons.AdventurersGuild.characterData.Size;
import ru.dungeons.AdventurersGuild.characterData.chRace;
import ru.dungeons.AdventurersGuild.characterData.statGrid;

@Entity
public class Elf extends chRace {

    public Elf() {
        super(Size.medium,
                30,
                true,
                new Language[]{Language.Common, Language.Elvish});
    }

    public String getRaceName(){
        return "Elf";
    }
}
