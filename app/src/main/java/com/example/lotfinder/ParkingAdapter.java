package com.example.lotfinder;
import com.example.lotfinder.models.ParkingLot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lotfinder.models.ParkingLot;
import java.util.List;

public class ParkingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ParkingLot> parkingLots;
    private OnItemClickListener listener;

    private static final int VIEW_TYPE_STANDARD = 0;
    private static final int VIEW_TYPE_PREMIUM = 1;

    public interface OnItemClickListener {
        void onItemClick(ParkingLot parkingLot);
    }

    public ParkingAdapter(List<ParkingLot> parkingLots, OnItemClickListener listener) {
        this.parkingLots = parkingLots;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return parkingLots.get(position).isPremium() ? VIEW_TYPE_PREMIUM : VIEW_TYPE_STANDARD;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == VIEW_TYPE_PREMIUM) {
            View view = inflater.inflate(R.layout.parking_item_premium, parent, false);
            return new PremiumViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.parking_item_standard, parent, false);
            return new StandardViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ParkingLot lot = parkingLots.get(position);

        if (holder instanceof PremiumViewHolder) {
            ((PremiumViewHolder) holder).parkingName.setText(lot.getName());
        } else {
            ((StandardViewHolder) holder).parkingName.setText(lot.getName());
        }

        holder.itemView.setOnClickListener(v -> listener.onItemClick(lot));
    }

    @Override
    public int getItemCount() {
        return parkingLots.size();
    }

    public void updateList(List<ParkingLot> newList) {
        parkingLots.clear();
        parkingLots.addAll(newList);
        notifyDataSetChanged();
    }

    static class StandardViewHolder extends RecyclerView.ViewHolder {
        TextView parkingName;

        StandardViewHolder(View itemView) {
            super(itemView);
            parkingName = itemView.findViewById(R.id.parkingName);
        }
    }

    static class PremiumViewHolder extends RecyclerView.ViewHolder {
        TextView parkingName;

        PremiumViewHolder(View itemView) {
            super(itemView);
            parkingName = itemView.findViewById(R.id.parkingName);
        }
    }
}
