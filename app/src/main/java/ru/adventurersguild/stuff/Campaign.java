package ru.adventurersguild.stuff;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Campaign {
    private String name;
    private String notes;
    private List<Location> locations;
    private List<Quest> quests;

}
