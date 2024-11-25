package ru.dungeons.AdventurersGuild.characterData.classes;

import jakarta.persistence.Entity;
import ru.dungeons.AdventurersGuild.characterData.chClass;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Fighter extends chClass {

    @JsonCreator
    public Fighter(int level){
        super("Fighter", level);
    }
}

