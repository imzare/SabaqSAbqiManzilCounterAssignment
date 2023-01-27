package com.example.sabaqsabqimanzilcounter;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class theRecyclerViewAdapter extends RecyclerView.Adapter<theRecyclerViewAdapter.MyVH> {

    EditText PersonName0, PersonSabaq0, PersonSabqi0, PersonManzil0;

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
        //set name and id by dynamically getting from database
        holder.textViewFriendName.setText(holder.data.getName());
        holder.ID.setText(holder.data.RollNumber);


        holder.textViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //holder.textViewEdit.setText("ponka");
                //dialogue box start


                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("You can update existing record here");
                builder.setTitle("Edit Record");
                builder.setCancelable(true);
                LayoutInflater inflator= LayoutInflater.from(v.getContext());

                View layout = inflator.inflate(R.layout.changerecord, (ViewGroup) v.findViewById(R.id.custt) );
                //show custom view
                builder.setView(layout);
                // Sets the Name by fetching from the recyclerview automatically
                String a= holder.textViewFriendName.getText().toString();
                EditText name1=(EditText) layout.findViewById(R.id.editTextTextPersonName);
                name1.setText(a);

                String b= holder.ID.getText().toString();
                EditText name2=(EditText) layout.findViewById(R.id.editTextTextPersonNamehardID);
                name2.setText(b);
                //end customview
// Add the buttons
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        //getting text from inflated text
                        Dialog dialogObj = Dialog.class.cast(dialog);

                        //binding edit text of custom layout in, inflator
                        EditText name1=(EditText)dialogObj.findViewById(R.id.editTextTextPersonName);
                        EditText sabaq1=(EditText)dialogObj.findViewById(R.id.editTextTextPersonSabaq);
                        EditText sabqi1=(EditText)dialogObj.findViewById(R.id.editTextTextPersonsabqi);
                        EditText manzil1=(EditText)dialogObj.findViewById(R.id.editTextTextPersonManzil);
                        EditText Rollnun1=(EditText)dialogObj.findViewById(R.id.editTextTextRollnum);



                        String r= name1.getText().toString();
                        String w= name2.getText().toString();
                        String x= sabaq1.getText().toString() ;
                        String y=sabqi1.getText().toString();
                        String z= manzil1.getText().toString();

                        Log.d("hassan1 ",w);
                        Log.d("hassan2 ",x);
                        Log.d("hassan3 ",y);
                        Log.d("hassan4 ",z);





                        // User clicked Update button
                        DBHandler upr = new DBHandler(v.getContext());


                        RecordClassManipulation up = new RecordClassManipulation(r,x,y,z,w);
                        upr.insertRecord(up);
                        //upr.updateStudent(up);


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




        //View details

        holder.textViewSeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Getting roll from recyclerview to pass in function
                String passRoll=holder.ID.getText().toString();
                Log.d(passRoll, "what: ");

                Intent intt = new Intent(v.getContext(), StudentBio.class);

               // String message =  "Hassan"; //editText.getText().toString();
                //intt.putExtra("key", 756);
                intt.putExtra("passRoll", passRoll);
                v.getContext().startActivity(intt);

            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        ImageView imageViewFriend;
        TextView textViewFriendName, ID;
        TextView textViewEdit;
        TextView textViewSeeDetails;
        RecordClassManipulation data;

        EditText PersonName, PersonSabaq, PersonSabqi, PersonManzil;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewEdit = itemView.findViewById(R.id.textVieweditdetails);
            textViewSeeDetails = itemView.findViewById(R.id.textViewdetails);
            ID= itemView.findViewById(R.id.textViewrollId);

            PersonName = itemView.findViewById(R.id.editTextTextPersonName);
            PersonSabaq = itemView.findViewById(R.id.editTextTextPersonSabaq);
            PersonSabqi = itemView.findViewById(R.id.editTextTextPersonsabqi);
            PersonManzil = itemView.findViewById(R.id.editTextTextPersonManzil);
        }
    }
}
