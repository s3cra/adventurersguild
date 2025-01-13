package ru.adventurersguild.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import lombok.var;
import ru.adventurersguild.R;
import ru.adventurersguild.adapters.LocationAdapter;
import ru.adventurersguild.stuff.Location;

public class LocationsActivity extends AppCompatActivity {
    List<Location> locations = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locations_list);
        LocationAdapter adapter = new LocationAdapter(this, locations);
        RecyclerView locationsList = findViewById(R.id.location_cards_list);
        locationsList.setAdapter(adapter);
    }

    public void toLocationEditor(View view){
        setContentView(R.layout.location_create);
    }

    public  void toLocationsList(View view){
        setContentView(R.layout.locations_list);
        LocationAdapter adapter = new LocationAdapter(this, locations);
        RecyclerView locationsList = findViewById(R.id.location_cards_list);
        locationsList.setAdapter(adapter);
    }

    public void createLocation(View view){
        TextInputEditText namebar = findViewById(R.id.namebar_location_editor);
        if (namebar.getText() == null || namebar.getText().toString().isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content)
                    , "Nameless locations are not allowed."
                    , Snackbar.LENGTH_LONG).show();
            return;
        }
        var location = new Location(namebar.getText().toString(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        locations.add(location);
        Snackbar.make(findViewById(android.R.id.content),
                "Location added.",
                Snackbar.LENGTH_LONG).show();
        toLocationsList(view);
    }

    public void toCampaigns(View view){
        Intent intent = new Intent(this, CampaignsActivity.class);


        startActivity(intent);
    }

    public void toQuests(View view){
        Intent intent = new Intent(this, QuestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        Location[] locs = locations.toArray(new Location[0]);
        if (!locations.isEmpty()) intent.putExtra("locations", locs);
        startActivity(intent);
    }
}
