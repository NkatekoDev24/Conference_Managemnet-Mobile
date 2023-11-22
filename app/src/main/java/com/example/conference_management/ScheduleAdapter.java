package com.example.conference_management;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    private List<ScheduleSession> scheduleList;

    public ScheduleAdapter(List<ScheduleSession> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item_layout, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleSession schedule = scheduleList.get(position);
        holder.titleTextView.setText(schedule.getTitle());
        holder.timeTextView.setText(schedule.getTime());
        holder.textViewScheduleDescription.setText(schedule.getDescription());
        holder.textViewScheduleDate.setText(schedule.getDate());
        holder.textViewScheduleLocation.setText(schedule.getLocation());
    }


    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        TextView textViewScheduleDescription;
        TextView textViewScheduleDate;
        TextView textViewScheduleLocation;

        ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewScheduleTitle);
            timeTextView = itemView.findViewById(R.id.textViewScheduleTime);
            textViewScheduleDescription = itemView.findViewById(R.id.textViewScheduleDescription);
            textViewScheduleDate = itemView.findViewById(R.id.textViewScheduleDate);
            textViewScheduleLocation = itemView.findViewById(R.id.textViewScheduleLocation);
        }
    }
}


