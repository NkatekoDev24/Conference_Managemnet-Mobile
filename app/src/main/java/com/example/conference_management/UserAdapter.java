//package com.example.conference_management;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.core.content.ContextCompat;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//    private Context context;
//    private List<User> userList;
//
//    public UserAdapter(Context context, List<User> userList) {
//        this.context = context;
//        this.userList = userList;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//
//        holder.usernameText.setText(user.getUsername());
//
//        // Set the online/offline status based on the isConnected field
//        if (user.isConnected()) {
//            holder.statusText.setText("Online");
//            holder.statusText.setTextColor(ContextCompat.getColor(context, R.color.colorGreen));
//        } else {
//            holder.statusText.setText("Offline");
//            holder.statusText.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    public class UserViewHolder extends RecyclerView.ViewHolder {
//        public TextView usernameText;
//        public TextView statusText;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            usernameText = itemView.findViewById(R.id.usernameText);
//            statusText = itemView.findViewById(R.id.statusText);
//        }
//    }
//}
//
