package ru.adventurersguild.characterData.entities;

import java.util.ArrayList;

import ru.adventurersguild.characterData.InGameEntity;
import ru.adventurersguild.characterData.chClass;
import ru.adventurersguild.characterData.chRace;

public class NPC extends InGameEntity {
    chRace race;
    ArrayList<chClass> classes = new ArrayList<>();

}
