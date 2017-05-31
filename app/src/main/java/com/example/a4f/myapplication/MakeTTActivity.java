package com.example.a4f.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by 태홍 on 2017-05-31.
 */

public class MakeTTActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maketimetable);
        setTitle("Make Timetable!");
        final String[] grade = {"1학년","2학년","3학년","4학년"};
        Spinner spinnerA = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,grade);
        spinnerA.setAdapter(adapter);
    }
}
