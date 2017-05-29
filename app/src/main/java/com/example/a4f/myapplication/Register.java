package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 상규 on 2017-05-27.
 */
//register
public class Register extends AppCompatActivity {
    EditText name,password,userName,dept;
    String strName,strUN,strPW,strDept;
 //
    @Override
    protected  void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.etRegName);
        userName=(EditText)findViewById(R.id.etRegId);
        password = (EditText) findViewById(R.id.etRegPW);
        dept=(EditText)findViewById(R.id.etRegDept);
        Button cancel;
        cancel = (Button)findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onReg(View view)
    {                                       // register Student info to MySQL
        strName=name.getText().toString();
        strUN = userName.getText().toString();
        strPW = password.getText().toString();
        strDept = dept.getText().toString();
        String type="register";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,strName,strUN,strPW,strDept);
    }
}
