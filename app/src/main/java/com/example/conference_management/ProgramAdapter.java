package com.example.conference_management;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    private List<ProgramItemModel> programItemList;

    public ProgramAdapter(List<ProgramItemModel> programItemList) {
        this.programItemList = programItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.program_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProgramItemModel programItem = programItemList.get(position);
        holder.sessionNameTextView.setText(programItem.getSessionName());
        holder.sessionTimeTextView.setText(programItem.getSessionTime());
        holder.sessionLocationTextView.setText(programItem.getSessionLocation());
    }

    @Override
    public int getItemCount() {
        return programItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView sessionNameTextView;
        TextView sessionTimeTextView;
        TextView sessionLocationTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sessionNameTextView = itemView.findViewById(R.id.sessionName);
            sessionTimeTextView = itemView.findViewById(R.id.sessionTime);
            sessionLocationTextView = itemView.findViewById(R.id.sessionLocation);
        }
    }
}

