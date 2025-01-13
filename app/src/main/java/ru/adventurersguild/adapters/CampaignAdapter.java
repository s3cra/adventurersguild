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
import ru.adventurersguild.stuff.Campaign;

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Campaign> campaigns;

    public CampaignAdapter(Context context, List<Campaign> campaigns) {
        this.inflater = LayoutInflater.from(context);
        this.campaigns = campaigns;
    }

    @NonNull
    @Override
    public CampaignAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.campaigns_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignAdapter.ViewHolder holder, int position) {
        Campaign campaign = this.campaigns.get(position);

        holder.name.setText(campaign.getName());
    }

    @Override
    public int getItemCount() {
        return this.campaigns.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.campaign_name_card);
        }
    }
}
