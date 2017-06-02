package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {
    //EditText userNameEt, passwordEt;
    TextView userNameEt,passwordEt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  userNameEt = (EditText)findViewById(R.id.etRegId);
        // passwordEt = (EditText)findViewById(R.id.etPassword);
        userNameEt = (TextView)findViewById(R.id.idText);
        passwordEt = (TextView)findViewById(R.id.passwordText);
        //testDB();
    }

    private static final String url = "http://timetable.dothome.co.kr/timetable"; //test is name of your db
    private static final String user = "timetable";
    private static final String pass = "twinkle13";
/*
    public void testDB(){

        TextView textView = (TextView)this.findViewById(R.id.textView);
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(url, user, pass);

            String result = "Database connection success\n";
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from users");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while(resultSet.next()){
                result += resultSetMetaData.getColumnName(1) + ":" + resultSet.getString(1) + "\n";
                result += resultSetMetaData.getColumnName(2) + ":" + resultSet.getString(1) + "\n";
            }
            textView.setText(result);

        }catch (Exception e){
            e.printStackTrace();
            textView.setText(e.toString());
        }
    }*/


    public void openRegister(View v) {
        startActivity(new Intent(this, Register.class));
        finish();
    }

    public void onLoginClick(View v) {
        String username = userNameEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
        startActivity(new Intent(this,NavActivity.class));
        finish();
    }
}