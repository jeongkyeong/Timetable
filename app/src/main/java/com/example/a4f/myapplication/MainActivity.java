package com.example.a4f.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick1(View v) {
        setContentView(R.layout.Main2Activity);
    }

    public void onButtonClick2(View v) {
        setContentView(R.layout.Main22Activity);
    }
}
