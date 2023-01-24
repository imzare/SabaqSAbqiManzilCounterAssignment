package com.example.sabaqsabqimanzilcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView hd, ft, sb;
ListView lw;

DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hd=findViewById(R.id.textViewheader);
        ft=findViewById(R.id.textView3footer);
        sb=findViewById(R.id.textView2);
        lw=findViewById(R.id.arraylistview);
        db = new DBHandler(this);
        RefreshGrid();
    }






    public void RefreshGrid() {
        List<RecordClassManipulation> students = db.selectAllresults();

        ArrayAdapter<RecordClassManipulation> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, students);
        lw.setAdapter(arrayAdapter);
    }

}