package com.lura.location.adapter;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hman.location.R;
import com.lura.location.db.LocationDetails;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.CustomViewHolder> {

    private List<LocationDetails> locationDetailList;
    Activity activity;

    public LocationAdapter(List<LocationDetails> locationDetailList, Activity activity) {
        this.locationDetailList = locationDetailList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_adapter_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final LocationDetails locationDetail = getItem(position);

        holder.itemTitle.setText("Lat&Long" + locationDetail.getLatitude() + " , " + locationDetail.getLongitude());
        holder.itemTime.setText(locationDetail.getCreatedAt());

        holder.showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://maps.google.com/?q=" + locationDetail.getLatitude() + "," + locationDetail.getLongitude()));
                activity.startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return locationDetailList.size();
    }

    public LocationDetails getItem(int position) {
        return locationDetailList.get(position);
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle, itemTime;
        private Button showMap;

        public CustomViewHolder(View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.lat_long);
            itemTime = itemView.findViewById(R.id.created_text);
            showMap = itemView.findViewById(R.id.show_map);
        }
    }
}
