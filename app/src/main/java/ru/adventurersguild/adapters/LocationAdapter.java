package ru.adventurersguild.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.adventurersguild.R;
import ru.adventurersguild.stuff.Location;

public class LocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Location> locations;
    private final LayoutInflater inflater;

    public LocationAdapter(Context context, List<Location> locations) {
        this.locations = locations;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == locations.size()) return 1;
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) return new ViewHolderLast(inflater.inflate(R.layout.location_card_create, parent, false));
        return new ViewHolder(inflater.inflate(R.layout.location_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position < locations.size()) {
            Location location = locations.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.name.setText(location.name);
        }
    }

    @Override
    public int getItemCount() {
        return locations.size()+1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.location_name_card);
        }
    }
    public static class ViewHolderLast extends RecyclerView.ViewHolder{
        ViewHolderLast(View view){
            super(view);
        }
    }
}
