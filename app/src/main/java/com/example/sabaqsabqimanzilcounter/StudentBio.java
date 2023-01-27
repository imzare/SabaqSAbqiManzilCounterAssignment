package com.example.sabaqsabqimanzilcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentBio extends AppCompatActivity {
TextView testt;
ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_bio);

        testt =findViewById(R.id.textViewMain);

        Intent intent = getIntent();
         String number = intent.getStringExtra("passRoll");
        DBHandler db = new DBHandler(this);
        List<RecordClassManipulation> students = db.selectSpccificresults(number);
        //List<RecordClassManipulation> students = db.selectSpccificresults(number);
        Log.d(number, "WhatIn ");
        testt.setText(number);
        lw= findViewById(R.id.SuratNamesListView);



        ArrayList<String> arrli = new ArrayList<>();
        arrli.add(students.toString());
        Log.d(students.toString(), "final: ");
        ArrayAdapter<String> arradp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrli);
        lw.setAdapter(arradp);



        //testt =findViewById(R.id.textViewtesting);

        //RecordClassManipulation rv = new RecordClassManipulation();



    }
}