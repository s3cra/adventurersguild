package ru.adventurersguild.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.adventurersguild.characterData.Character;
import lombok.var;
import ru.adventurersguild.R;

public class NPCAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Character> npcs;

    public NPCAdapter(Context context, List<Character> npcs) {
        this.inflater = LayoutInflater.from(context);
        this.npcs = npcs;
    }

    @Override
    public int getItemViewType(int position) {
        return position==npcs.size() ? 1 : 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return viewType == 1 ? new NPCAdapter.ViewHolderLast(inflater.inflate(R.layout.npc_card_create, parent, false))
                : new NPCAdapter.ViewHolder(inflater.inflate(R.layout.npc_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            var holder1 = (ViewHolder) holder;
            Character npc = npcs.get(position);
            holder1.name.setText(npc.getName());
            holder1.race.setText(npc.getRace().getRaceName());
            holder1.classes.setText(npc.classesToString());
            holder1.strength.setText(String.valueOf(npc.getStats().getStrength()));
            holder1.dexterity.setText(String.valueOf(npc.getStats().getDexterity()));
            holder1.constitution.setText(String.valueOf(npc.getStats().getConstitution()));
            holder1.intelligence.setText(String.valueOf(npc.getStats().getIntelligence()));
            holder1.wisdom.setText(String.valueOf(npc.getStats().getWisdom()));
            holder1.charisma.setText(String.valueOf(npc.getStats().getCharisma()));
            holder1.level.setText(String.valueOf(npc.getLevel()));
        }
    }

    @Override
    public int getItemCount() {
        return npcs.size()+1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, race, classes, strength, dexterity, constitution, intelligence, wisdom, charisma, level;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.name = view.findViewById(R.id.name_npc_card);
            this.race = view.findViewById(R.id.race_npc_card);
            this.classes = view.findViewById(R.id.classes_npc_card);
            this.strength = view.findViewById(R.id.strength_npc_card);
            this.dexterity = view.findViewById(R.id.dexterity_npc_card);
            this.constitution = view.findViewById(R.id.constitution_npc_card);
            this.intelligence = view.findViewById(R.id.intelligence_npc_card);
            this.wisdom = view.findViewById(R.id.wisdom_npc_card);
            this.charisma = view.findViewById(R.id.charisma_npc_card);
            this.level = view.findViewById(R.id.level_npc_card);
        }
    }

    public static class ViewHolderLast extends RecyclerView.ViewHolder{
        public ViewHolderLast(@NonNull View itemView) {
            super(itemView);
        }
    }
}
