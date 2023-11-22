package com.example.conference_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConferenceAdapter extends RecyclerView.Adapter<ConferenceAdapter.ConferenceViewHolder> {
    private List<Conference> conferenceList;
    private Context context; // Add a context variable to access resources

    public ConferenceAdapter(List<Conference> conferenceList) {
        this.context = context;
        this.conferenceList = conferenceList;
    }

    public void setData(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }

    @NonNull
    @Override
    public ConferenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conference, parent, false);
        return new ConferenceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConferenceViewHolder holder, int position) {
        Conference conference = conferenceList.get(position);

        holder.titleTextView.setText(conference.getTitle());
        holder.descriptionTextView.setText(conference.getDescription());
        holder.timeTextView.setText(conference.getEventStartTime() + " - " + conference.getEventEndTime());

        // Load the image from drawable using the resource ID
        holder.imageView.setImageResource(conference.getPictureResourceId());
    }

    @Override
    public int getItemCount() {
        return conferenceList.size();
    }

    public static class ConferenceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;
        TextView timeTextView;

        public ConferenceViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.conferenceImageView);
            titleTextView = itemView.findViewById(R.id.conferenceTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.conferenceDescriptionTextView);
            timeTextView = itemView.findViewById(R.id.conferenceTimeTextView);
        }
    }
}







