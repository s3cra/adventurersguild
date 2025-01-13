package ru.adventurersguild.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.adventurersguild.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;
import ru.adventurersguild.stuff.Item;

public class StarterPackAdapter extends RecyclerView.Adapter<StarterPackAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Pair<List<Item>,List<Item>>> items;
    private final List<List<Item>> itemsChoosed = new ArrayList<>();

    public StarterPackAdapter(Context context, List<Pair<List<Item>, List<Item>>> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list_choice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pair<List<Item>,List<Item>> choice = items.get(position);

        String a = "";
        String b = "";


        for (Item item:
                choice.first) {
            a+= ", " + item.toString();
        }
        for (Item item:
                choice.second) {
            b+= ", " + item.toString();
        }
        holder.optionA.setText(a);
        holder.optionB.setText(b);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            List<Item> choosedAtPos = new ArrayList<>();
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    compoundButton.setBackgroundColor(R.color.checked);
                    if (compoundButton == holder.optionA){
                        choosedAtPos = choice.first;
                        if (holder.optionB.isChecked()){
                            holder.optionB.setChecked(false);
                        }
                    }

                    if (compoundButton == holder.optionB){
                        choosedAtPos = choice.second;
                        if (holder.optionA.isChecked()){
                            holder.optionA.setChecked(false);
                        }
                    }

                } else{
                    if (compoundButton == holder.optionA){

                        if (!holder.optionB.isChecked()){
                            choosedAtPos.clear();
                        }
                    }

                    if (compoundButton == holder.optionB){

                        if (!holder.optionA.isChecked()){
                            choosedAtPos.clear();
                        }
                    }
                }
                if (itemsChoosed.size() <= holder.getAdapterPosition()) itemsChoosed.add(choosedAtPos);
                else itemsChoosed.set(holder.getAdapterPosition(), choosedAtPos);

            }
        };

        holder.optionA.setOnCheckedChangeListener(listener);
        holder.optionB.setOnCheckedChangeListener(listener);
    }

    public List<Item> getChoice(){
        ArrayList<Item> choice = new ArrayList<>();
        itemsChoosed.forEach(choice::addAll);
        return choice;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final Chip optionA, optionB;
        ViewHolder(View view){
            super(view);
            optionA = view.findViewById(R.id.chipA);
            optionB = view.findViewById(R.id.chipB);

        }
    }
}
