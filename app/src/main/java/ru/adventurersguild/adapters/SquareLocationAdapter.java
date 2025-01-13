package ru.adventurersguild.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import ru.adventurersguild.R;
import ru.adventurersguild.stuff.Location;

public class SquareLocationAdapter extends RecyclerView.Adapter<SquareLocationAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Location> locations;
    @Getter(AccessLevel.PUBLIC)
    private final List<Location> relatedLocations;

    public SquareLocationAdapter(Context context, List<Location> locations){
        this.inflater = LayoutInflater.from(context);
        this.locations = locations;
        this.relatedLocations = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.square_location_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Location location = locations.get(position);
        holder.name.setText(location.name);
        holder.card.setOnClickListener(view -> {
            holder.check.setChecked(!holder.check.isChecked());
        });
        holder.check.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                relatedLocations.add(location);
            } else {
                relatedLocations.remove(location);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox check;
        CardView card;
        TextView name;

        public ViewHolder(@NonNull View view) {
            super(view);
            check = view.findViewById(R.id.location_square_card_check);
            card = view.findViewById(R.id.location_square_card);
            name = view.findViewById(R.id.location_name_card);
        }
    }

}
