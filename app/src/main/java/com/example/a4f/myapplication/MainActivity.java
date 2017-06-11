package com.example.a4f.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    //EditText userNameEt, passwordEt;
    TextView userNameEt,passwordEt;
    private AlertDialog dialog;
    String accoutID;
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

 /*   public void testDB(){

        TextView textView = (TextView)this.findViewById(R.id.textView3);
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

        try {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            String result=backgroundWorker.execute(type, username, password).get();

            boolean checkk=result.equals("1");

            if ( checkk){
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                dialog = builder.setMessage("Success Login!")
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
                accoutID=username;
                requestUserInfo(username,password);
                Intent i = new Intent(MainActivity.this, NavActivity.class);
                i.putExtra("username",username);
                startActivity(i);
            } else {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                dialog = builder.setMessage("Check your ID or Password. ")
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void requestUserInfo(String name,String pw){         // 성공한 로그인 user정보를 파일로 저장해놓음. 나중에 user정보를 다른화면에서 사용하도록.
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        String type="user info";
        String dept;
        String grade;
        try {
            String result = backgroundWorker.execute(type, name, pw).get();
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("user");
                JSONObject object=jsonArray.getJSONObject(0);
                grade=object.getString("grade");
                dept=object.getString("dept");

                SharedPreferences userData=getSharedPreferences("userData",MODE_PRIVATE);   //SharedPreferences를 활용해 xml파일로저장.
                SharedPreferences.Editor editor=userData.edit();
                editor.putString("ID",name);
                editor.putString("Password",pw);
                editor.putString("Grade",grade);
                editor.putString("Dept",dept);
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
             e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}