package ru.adventurersguild.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.adventurersguild.R;
import ru.adventurersguild.characterData.Character;
import ru.adventurersguild.adapters.NPCAdapter;

public class NPCsActivity extends AppCompatActivity {
    private List<Character> npcs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.npcs_list);
        RecyclerView npcList = findViewById(R.id.npc_cards_list);
        NPCAdapter adapter = new NPCAdapter(this, npcs);
        npcList.setAdapter(adapter);
    }

    public void toNpcEditor(View view){
        setContentView(R.layout.npc_create);
    }

    public void toNPCsList(View view){
        setContentView(R.layout.npcs_list);
        RecyclerView npcList = findViewById(R.id.npc_cards_list);
        NPCAdapter adapter = new NPCAdapter(this, npcs);
        npcList.setAdapter(adapter);
    }

    public void toQuestsList(View view){
        setContentView(R.layout.quests_list);
    }
}
