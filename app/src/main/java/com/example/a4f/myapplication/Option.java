package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by 정윤 on 2017-05-31.
 */

public class Option extends AppCompatActivity {
    private Spinner gradeSpin;
    private Spinner creditSpin;
    private Spinner majorSpin;
    private Spinner noClasses;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);
        setTitle("Filter Options");
        gradeSpin=(Spinner)findViewById(R.id.spinnerGrade);
        creditSpin = (Spinner) findViewById(R.id.spinnerCredits);
        noClasses = (Spinner) findViewById(R.id.spinnerGG);
    }

    public void onBackPressed() {
        Intent i = new Intent(Option.this, NavActivity.class);
        startActivity(i);
        finish();
    }
    public void btnCancelClick(View view) {
        Toast.makeText(Option.this, "Cancelled", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Option.this, NavActivity.class);
        startActivity(i);
    }
    public void btnConfirmClick(View view) {
        String strGrade = gradeSpin.getSelectedItem().toString();
        String strCredits = creditSpin.getSelectedItem().toString();
        String strNoClass=noClasses.getSelectedItem().toString();
        Toast.makeText(Option.this, "Confirmed", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Option.this, EntireTTActivity.class);
        i.putExtra("grade",strGrade);
        i.putExtra("credits",strCredits);
        i.putExtra("noClass",strNoClass);
        startActivity(i);
    }
}
