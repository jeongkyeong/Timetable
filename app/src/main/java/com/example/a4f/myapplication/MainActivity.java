package com.example.a4f.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testDB();
    }

    private static final String url = "jdbc:mysql://localhost:8080/test"; //test is name of your db
    private static final String user = "root";
    private static final String pass = "1234";

    public void testDB(){

        TextView textView = (TextView)this.findViewById(R.id.textView3);
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String result = "Database connection success\n";
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from Persons");
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
    }


    public void onButtonClick1(View v) {
        setContentView(R.layout.activity_main2);
    }

    public void onButtonClick2(View v) {
        setContentView(R.layout.activity_main22);
    }

}
