package ru.adventurersguild.stuff;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Quest{
    public String name;
    public int xpGain;
    public List<Item> reward = new ArrayList<>();
}
