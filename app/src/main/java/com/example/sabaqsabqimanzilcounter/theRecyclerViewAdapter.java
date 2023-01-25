package com.example.sabaqsabqimanzilcounter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class theRecyclerViewAdapter extends RecyclerView.Adapter<theRecyclerViewAdapter.MyVH> {

    List<RecordClassManipulation> friendsList;
    public theRecyclerViewAdapter(List<RecordClassManipulation> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public theRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customviewlistdata, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull theRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.textViewFriendName.setText(holder.data.getName());
        holder.textViewdateFriend.setText(String.valueOf(holder.data.getDob()));
        holder.imageViewFriend.setImageResource(holder.data.getImageID());
        holder.textViewCity.setText(holder.data.getCity());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        ImageView imageViewFriend;
        TextView textViewFriendName;
        TextView textViewdateFriend;
        TextView textViewCity;
        RecordClassManipulation data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewdateFriend = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);
        }
    }
}
