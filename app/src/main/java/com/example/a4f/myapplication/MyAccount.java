package com.example.a4f.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by 강정경 on 2017-06-01.
 */

public class MyAccount extends AppCompatActivity {
    EditText name,password,userName,dept;
    Spinner grade;
    String strName,strUN,strPW,strDept;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaccount);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public void btnEditProfileClick(View view) {
        Toast.makeText(MyAccount.this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MyAccount.this, EditProfile.class);
        startActivity(i);
        finish();
    }

    public void btnMyTTClick(View view) {
        Toast.makeText(MyAccount.this, "My Timetable Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MyAccount.this, MyTT.class);
        startActivity(i);
        finish();
    }

    public void btnHistoryClick(View view) {
        Toast.makeText(MyAccount.this, "History Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MyAccount.this, MyTTHistory.class);
        startActivity(i);
        finish();
    }

}