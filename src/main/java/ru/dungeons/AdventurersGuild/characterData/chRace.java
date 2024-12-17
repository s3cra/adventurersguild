package ru.dungeons.AdventurersGuild.characterData;


import jakarta.persistence.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.dungeons.AdventurersGuild.characterData.races.*;
import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Elf.class, name = "Elf"),

        @JsonSubTypes.Type(value = Orc.class, name = "Orc") }
)
@Entity
@Table(name = "races")
public abstract class chRace {
    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;
    @NonNull
    Size size;
    @NonNull
    int speed;
    @NonNull
    boolean darkVision;
    @NonNull
    Language[] langs;



    @JsonIgnore
    public String getRaceName(){
        return "";
    };
}
