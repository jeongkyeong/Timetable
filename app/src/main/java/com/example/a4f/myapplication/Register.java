package com.example.a4f.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 상규 on 2017-05-27.
 */
//register
public class Register extends AppCompatActivity {
    EditText name,password,passwordConfirm,userName;
    String strName,strUN,strPW,strDept,strgrade;
    Button join,IDcheck;
    ImageView img;
    private Spinner deptSpinner;
    private Spinner gradeSpinner;

    private AlertDialog dialog;
    //
    @Override
    protected  void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.etRegName);
        userName=(EditText)findViewById(R.id.etRegId);
        password = (EditText) findViewById(R.id.etRegPW);
        passwordConfirm = (EditText)findViewById(R.id.etRegPW2);
        deptSpinner=(Spinner)findViewById(R.id.etRegDept);
        gradeSpinner=(Spinner)findViewById(R.id.etRegGrade);

        img = (ImageView)findViewById(R.id.imageView3);
        join = (Button)findViewById(R.id.btnJoin);
        IDcheck = (Button)findViewById(R.id.button6);

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



        passwordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(password.getText().toString().equals(passwordConfirm.getText().toString())) {
                    img.setVisibility(View.INVISIBLE);
                } else {

                    img.setVisibility(View.VISIBLE);
                    join.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public void IDCHECK(View view){
        try{
            strUN = userName.getText().toString();
            String type="IDcheck";
            BackgroundWorker backgroundWorker=new BackgroundWorker(this);
            String result= backgroundWorker.execute(type,strUN).get();
            name.setText(result);
            boolean check=result.equals("1");
            if (check){
                AlertDialog.Builder builder= new AlertDialog.Builder(Register.this);
                dialog = builder.setMessage("Please use another ID")
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
                join.setEnabled(false);
                userName.setText("");
                strUN = "";
            } else {
                AlertDialog.Builder builder= new AlertDialog.Builder(Register.this);
                dialog = builder.setMessage("hehe you can use it")
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
                join.setEnabled(true);
            }

        }catch(Exception e) {
            e.printStackTrace();
        };


    }
    public void onReg(View view)
    {                                       // register Student info to MySQL
        strName=name.getText().toString();
        strUN = userName.getText().toString();
        strPW = password.getText().toString();
        strDept=deptSpinner.getSelectedItem().toString();
        strgrade=gradeSpinner.getSelectedItem().toString();

        String type="register";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,strName,strUN,strPW,strDept,strgrade);
        Intent i= new Intent(Register.this,MainActivity.class);
        startActivity(i);
        finish();


    }
}