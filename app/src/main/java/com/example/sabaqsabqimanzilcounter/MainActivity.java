package com.example.sabaqsabqimanzilcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView hd, ft, sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hd=findViewById(R.id.textViewheader);
        ft=findViewById(R.id.textView3footer);
        sb=findViewById(R.id.textView2);
    }
}