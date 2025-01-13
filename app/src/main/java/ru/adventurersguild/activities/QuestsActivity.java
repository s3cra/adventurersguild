package ru.adventurersguild.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.val;
import lombok.var;
import ru.adventurersguild.R;
import ru.adventurersguild.adapters.QuestAdapter;
import ru.adventurersguild.adapters.SquareLocationAdapter;
import ru.adventurersguild.stuff.Location;
import ru.adventurersguild.stuff.Quest;

public class QuestsActivity extends AppCompatActivity {
    List<Quest> quests = new ArrayList<>();
    List<Location> locations = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quests_list);
        QuestAdapter adapter = new QuestAdapter(this, quests);
        RecyclerView questsList = findViewById(R.id.quest_cards_list);
        questsList.setAdapter(adapter);
        if (getIntent().getExtras() == null) return;
        Location[] locationList = getIntent().getSerializableExtra("locations", Location[].class);
        locations = Arrays.asList((Location[]) locationList);
    }

    public void toQuestEditor(View view){
        setContentView(R.layout.quest_create);
        SquareLocationAdapter adapter = new SquareLocationAdapter(this, locations);
        RecyclerView locationsList = findViewById(R.id.related_locations_list_quest);
        locationsList.setAdapter(adapter);
        val snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(locationsList);
    }

    public  void toQuestsList(View view){
        setContentView(R.layout.quests_list);
        QuestAdapter adapter = new QuestAdapter(this, quests);
        RecyclerView questsList = findViewById(R.id.quest_cards_list);
        questsList.setAdapter(adapter);
    }

    public void toLocationsList(View view){
        Intent intent = new Intent(this, LocationsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void createQuest(View view){
        RecyclerView locationsList = findViewById(R.id.related_locations_list_quest);
        if(locationsList.getAdapter() == null) return;
        List<Location> relatedLocations = ((SquareLocationAdapter)locationsList.getAdapter()).getRelatedLocations();
        TextInputEditText namebar = findViewById(R.id.namebar_quest_editor);
        TextInputEditText xpGain = findViewById(R.id.xp_gain_quest_editor);
        if (namebar.getText() == null || namebar.getText().toString().isEmpty() ||
                xpGain.getText() == null || xpGain.getText().toString().isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content)
                    , "Fill all fields, please."
                    , Snackbar.LENGTH_LONG).show();
            return;
        }
        var quest = new Quest(namebar.getText().toString(), Integer.parseInt(xpGain.getText().toString()), new ArrayList<>());
        quests.add(quest);
        relatedLocations.forEach(location -> locations.get(locations.indexOf(location)).addQuest(quest));
        Snackbar.make(findViewById(android.R.id.content),
                "Quest added.",
                Snackbar.LENGTH_LONG).show();
        toQuestsList(view);
    }

    public void toNPCs(View view){
        Intent intent = new Intent(this, NPCsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(intent);
    }


}
