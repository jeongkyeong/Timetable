package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 강정경 on 2017-06-01.
 */

public class

MyTTHistory extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytthistory);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(MyTTHistory.this, MyAccount.class);
        startActivity(i);
        finish();
    }
}
