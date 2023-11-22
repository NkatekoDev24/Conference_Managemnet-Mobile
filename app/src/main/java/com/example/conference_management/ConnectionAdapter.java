package com.example.conference_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConnectionAdapter extends RecyclerView.Adapter<ConnectionAdapter.ConnectionViewHolder> {
    private Context context;
    private List<Connection> connectionList;

    public ConnectionAdapter(Context context, List<Connection> connectionList) {
        this.context = context;
        this.connectionList = connectionList;
    }

    @NonNull
    @Override
    public ConnectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.connection_item, parent, false);
        return new ConnectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConnectionViewHolder holder, int position) {
        Connection connection = connectionList.get(position);

        holder.textViewConnectionName.setText(connection.getName());

        if (connection.isOnline()) {
            holder.textViewConnectionStatus.setText("Online");
            holder.textViewConnectionStatus.setTextColor(ContextCompat.getColor(context, R.color.colorGreen));
        } else {
            holder.textViewConnectionStatus.setText("Offline");
            holder.textViewConnectionStatus.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return connectionList.size();
    }

    public class ConnectionViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewConnectionName;
        public TextView textViewConnectionStatus;

        public ConnectionViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewConnectionName = itemView.findViewById(R.id.textViewConnectionName);
            textViewConnectionStatus = itemView.findViewById(R.id.textViewConnectionStatus);
        }
    }
}

