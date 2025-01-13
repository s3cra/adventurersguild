package ru.adventurersguild.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.GuildAPI;
import api.Retro;
import retrofit2.Response;
import ru.adventurersguild.R;
import ru.adventurersguild.characterData.Character;
import lombok.var;
import ru.adventurersguild.adapters.CharacterAdapter;

public class CharactersActivity extends AppCompatActivity {

    List<Character> characters = new ArrayList<>();
    GuildAPI api = Retro.api;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.characters_list);
        try {
            updateList();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void toCharacterEditor(View view){
        var intent = new Intent(this, CharacterEditorActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void toHome(View view){
        var intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    private void updateList() throws IOException {
        Response<List<Character>> list = api.getCharacters().execute();
        switch (list.code()){
            case 200:
                characters = list.body();
                break;
            case 401:
                toSignIn();
                break;
            default:
                System.out.println(list.code());
                break;
        }
        RecyclerView charactersList = findViewById(R.id.character_cards_list);
        var adapter = new CharacterAdapter(this, characters);
        charactersList.setAdapter(adapter);
    }

    private void toSignIn(){
        var intent = new Intent(this, SigninActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}
