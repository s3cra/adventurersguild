package ru.adventurersguild.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.adventurersguild.R;
import ru.adventurersguild.adapters.CampaignAdapter;
import ru.adventurersguild.stuff.Campaign;

public class CampaignsActivity extends AppCompatActivity {
    public List<Campaign> campaigns = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaigns_list);
        CampaignAdapter adapter = new CampaignAdapter(this, campaigns);
        RecyclerView campaignsList = findViewById(R.id.campaign_cards_list);
        campaignsList.setAdapter(adapter);
    }

    private void toMain(View view){

    }

    public void toCreate(View view){
        Intent intent = new Intent(this, LocationsActivity.class);
        startActivity(intent);
    }

    public void toHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
