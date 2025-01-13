package ru.adventurersguild.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import api.GuildAPI;
import api.Retro;
import ru.adventurersguild.R;
import ru.adventurersguild.characterData.Character;
import lombok.var;


public class MainActivity extends AppCompatActivity {

    String[] classes = {"Fighter", "Wizard"};
    String[] races = {"Orc", "Elf"};
    ArrayList<String> charnames = new ArrayList<>();
    ArrayList<Character> arrcharacters = new ArrayList<Character>();
    String[] stories = {};
    private GuildAPI api = Retro.api;

    public static InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (dend >= 10 || end >= 10) return "";
            for (int i = start; i < end; i++) {
                if (!java.lang.Character.isLetter(source.charAt(i)) && source.charAt(i) != '-' ) { // Accept only letter & digits ; otherwise just return

                    return "";
                }
            }

            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toHost(View view){
        setContentView(R.layout.activity_roomhost);
        Spinner charPick = findViewById(R.id.campaignslist);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.aclonicalist, stories);
        adapter.setDropDownViewResource(R.layout.aclonicalist);
        charPick.setAdapter(adapter);
    }
    public void toJoin(View view){
        setContentView(R.layout.activity_roomjoin);
        Spinner charPick = findViewById(R.id.characterslist);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.aclonicalist, charnames);
        adapter.setDropDownViewResource(R.layout.aclonicalist);
        charPick.setAdapter(adapter);
    }
    public void toCharacters(View view){
        var intent = new Intent(this, CharactersActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void toCampaigns(View view){
        var intent = new Intent(this, CampaignsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
    public void toMain(View view){
        setContentView(R.layout.activity_main);
    }


}


