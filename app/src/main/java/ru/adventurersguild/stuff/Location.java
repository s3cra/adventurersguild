package ru.adventurersguild.stuff;

import java.io.Serializable;
import java.util.List;

import ru.adventurersguild.characterData.Character;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Location implements Serializable {
    public String name;
    public List<Character> npcs;
    public List<Quest> quests;
    public List<Item> loot;

    public void addQuest(Quest quest){
        if (this.quests.contains(quest)) return;
        this.quests.add(quest);
    }

    public void removeQuest(Quest quest){
        this.quests.remove(quest);
    }
}
