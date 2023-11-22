package com.example.conference_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private Context context;
    private List<Message> messageList;
    private DatabaseReference usersDatabase; // Reference to the users' data

    public MessageAdapter(Context context, List<Message> messageList, DatabaseReference usersDatabase) {
        this.context = context;
        this.messageList = messageList;
        this.usersDatabase = usersDatabase; // Initialize the users' database reference
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);

        holder.messageText.setText(message.getText());

        // Fetch and set sender name
        fetchSenderDisplayName(message.getSenderId(), holder.senderText);

        // Set formatted timestamp
        String formattedTimestamp = formatTimestamp(message.getTimestamp());
        holder.timestampText.setText(formattedTimestamp);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView senderText;
        public TextView messageText;
        public TextView timestampText;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderText = itemView.findViewById(R.id.senderText); // Make sure you have this TextView in your message_item.xml
            messageText = itemView.findViewById(R.id.messageText); // Make sure you have this TextView in your message_item.xml
            timestampText = itemView.findViewById(R.id.timestampText); // Make sure you have this TextView in your message_item.xml
        }
    }

    // Helper method to format timestamp (customize this as needed)
    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    // Method to fetch and set the sender's display name
    private void fetchSenderDisplayName(final String senderId, final TextView senderTextView) {
        // Query the user's database reference to get the display name
        DatabaseReference userRef = usersDatabase.child(senderId).child("displayName");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String displayName = dataSnapshot.getValue(String.class);
                    senderTextView.setText("Sender: " + displayName);
                } else {
                    senderTextView.setText("Sender: Unknown");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                senderTextView.setText("Sender: Unknown");
            }
        });
    }
}
