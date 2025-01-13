package ru.adventurersguild.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import ru.adventurersguild.R;

import java.util.List;

import ru.adventurersguild.characterData.Character;

public class CharacterAdapter  extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Character> characters;

    public CharacterAdapter(Context context, List<Character> characters) {
        this.characters = characters;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.character_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.nameView.setText(character.getName());
        holder.raceView.setText(character.getRace().getRaceName());
        holder.classView.setText(character.classesToString());
        holder.levelView.setText(String.valueOf(character.getLevel()));
        holder.STR.setText(String.valueOf(character.getStats().getStrength()));
        holder.DEX.setText(String.valueOf(character.getStats().getDexterity()));
        holder.CON.setText(String.valueOf(character.getStats().getConstitution()));
        holder.INT.setText(String.valueOf(character.getStats().getIntelligence()));
        holder.WIS.setText(String.valueOf(character.getStats().getWisdom()));
        holder.CHA.setText(String.valueOf(character.getStats().getCharisma()));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, raceView, classView, levelView;
        final TextView STR, DEX, CON, INT, WIS, CHA;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.nameBarCharacterInfo);
            raceView = view.findViewById(R.id.raceBarCharacterInfo);
            classView = view.findViewById(R.id.classBarCharacterInfo);
            levelView = view.findViewById(R.id.levelBarCharacterInfo);
            STR = view.findViewById(R.id.strValueMini);
            DEX = view.findViewById(R.id.dexValueMini);
            CON = view.findViewById(R.id.conValueMini);
            INT = view.findViewById(R.id.intValueMini);
            WIS = view.findViewById(R.id.wisValueMini);
            CHA = view.findViewById(R.id.chaValueMini);
        }
    }
}
