package com.example.sabaqsabqimanzilcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView hd, ft, sb;
ListView lw;
EditText ed, ee;
Button btn, btngitt;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hd=findViewById(R.id.textViewheader);
        ft=findViewById(R.id.textView3footer);
        sb=findViewById(R.id.textView2);
       // lw=findViewById(R.id.arraylistview);
        ed=findViewById(R.id.editTextTextPersonName2);
        ee=findViewById(R.id.editTextTextRollnum);
        btn=findViewById(R.id.button2);
        btngitt=findViewById(R.id.gitbtn);
        db = new DBHandler(this);
        RefreshGrid();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(ed.getText().toString(), "printonClick: ");

                if (TextUtils.isEmpty(ed.getText()) || TextUtils.isEmpty(ee.getText())) {

                    Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    ee.setText("BITF19A");
                }

                else if (db.CheckRoll(ee.getText().toString().trim())) {

                    Toast.makeText(MainActivity.this, "Roll Number already Enrolled", Toast.LENGTH_SHORT).show();
                    ee.setText("BITF19A");

                }
                else {
                    RecordClassManipulation data = new RecordClassManipulation(ed.getText().toString(), "", "", "", ee.getText().toString());
                    db.insertRecord(data);
                    RefreshGrid();
                    ee.setText("BITF19A");


                }
            }

        });



        btngitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://github.com/Ravian001/SabaqSAbqiManzilCounterAssignment/commits/bugfix");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });



    }






    public void RefreshGrid() {

    //new recycler work

        List<RecordClassManipulation> students = db.selectAllresultsWithSingleValue();






        recyclerView = findViewById(R.id.recylerViewStudent);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new theRecyclerViewAdapter(students) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();






// Arraylist based work
        //ArrayAdapter<RecordClassManipulation> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, students);
        //lw.setAdapter(arrayAdapter);
    }

}