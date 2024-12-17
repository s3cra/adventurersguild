package ru.dungeons.AdventurersGuild.characterData.classes;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dungeons.AdventurersGuild.characterData.chClass;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Setter
@NoArgsConstructor
@Entity
public class Fighter extends chClass {

    @JsonCreator
    public Fighter(int level){
        super("Fighter", level);
    }
}

