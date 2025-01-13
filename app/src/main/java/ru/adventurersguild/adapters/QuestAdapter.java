package ru.adventurersguild.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.adventurersguild.R;
import ru.adventurersguild.stuff.Quest;

public class QuestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Quest> quests;
    private final LayoutInflater inflater;

    public QuestAdapter(Context context, List<Quest> quests) {
        this.quests = quests;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == quests.size()) return 1;
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) return new ViewHolderLast(inflater.inflate(R.layout.quest_card_create, parent, false));
        return new ViewHolder(inflater.inflate(R.layout.quest_card, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position < quests.size()) {
            Quest quest = quests.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.name.setText(quest.name);
            holder1.xp.setText(quest.xpGain + " XP");
        }
    }

    @Override
    public int getItemCount() {
        return quests.size()+1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, xp;
        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.quest_name_card);
            xp = view.findViewById(R.id.xp_gain_quest_card);
        }
    }
    public static class ViewHolderLast extends RecyclerView.ViewHolder{
        ViewHolderLast(View view){
            super(view);
        }
    }
}
