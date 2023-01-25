package com.example.sabaqsabqimanzilcounter;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class theRecyclerViewAdapter extends RecyclerView.Adapter<theRecyclerViewAdapter.MyVH> {

    List<RecordClassManipulation> studentList;
    public theRecyclerViewAdapter(List<RecordClassManipulation> studentList) {
        this.studentList = studentList;
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
        holder.data=studentList.get(position);
        holder.textViewFriendName.setText(holder.data.getName());
        //holder.textViewdateFriend.setText(String.valueOf(holder.data.getDob()));
        //holder.imageViewFriend.setImageResource(holder.data.getImageID());
        //holder.textViewCity.setText(holder.data.getCity());

        holder.textViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //holder.textViewEdit.setText("ponka");
                //dialogue box start


                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("You can update existing record here");
                builder.setTitle("Edit Record");
                builder.setCancelable(true);
// Add the buttons
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked Update button



                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();

                //dialogue box end

            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        ImageView imageViewFriend;
        TextView textViewFriendName;
        TextView textViewEdit;
        TextView textViewSeeDetails;
        RecordClassManipulation data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewEdit = itemView.findViewById(R.id.textVieweditdetails);
            textViewSeeDetails = itemView.findViewById(R.id.textViewdetails);
        }
    }
}
