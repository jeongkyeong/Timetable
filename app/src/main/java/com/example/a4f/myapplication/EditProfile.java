package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by 강정경 on 2017-06-01.
 */

public class EditProfile extends AppCompatActivity {
    EditText name,password,userName,dept;
    Spinner grade;
    String strName,strUN,strPW,strDept;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(EditProfile.this, MyAccount.class);
        startActivity(i);
        finish();

    }
    public void btnEditClick(View view) {
        Toast.makeText(EditProfile.this, "Edit Clicked", Toast.LENGTH_SHORT).show();
    }
    public void btnCancelClick(View view) {
        Toast.makeText(EditProfile.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(EditProfile.this, MyAccount.class);
        startActivity(i);
    }

}
