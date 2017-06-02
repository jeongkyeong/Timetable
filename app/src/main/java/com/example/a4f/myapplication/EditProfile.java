package com.example.a4f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import java.io.*;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 강정경 on 2017-06-01.
 */

public class EditProfile extends AppCompatActivity {

    String username = "jkjk";/////////////////////?????현재사용자아이디

    private static String TAG = "EditProfile";
    private static String TAG_JSON = "webnautes";
    private static final String TAG_username = "username";
    private static final String TAG_name = "name";
    private static final String TAG_password = "password";
    private static final String TAG_dept = "dept";
    private static final String TAG_grade = "grade";


    private TextView mTextViewResult;
    ArrayList<HashMap<String, String>> mArrayList;
    ListView mlistView;
    String mJsonString;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);
        mArrayList = new ArrayList<>();

        try{
            String editUrl = "http://timetable.dothome.co.kr/edit.php?username="+ URLEncoder.encode(username,"UTF-8");
            GetData task = new GetData();
            task.execute(editUrl);
        }
         catch (IOException e) {
            e.printStackTrace();
        }


    }
    private class GetData extends AsyncTask<String,Void,String>{
        ProgressDialog progressDialog;
        String errorString = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(EditProfile.this, "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null){

                mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String editUrl = params[0];

            try {

                URL url = new URL(editUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String username = item.getString(TAG_username);
                String name = item.getString(TAG_name);
                String password = item.getString(TAG_password);
                String dept = item.getString(TAG_dept);
                String grade = item.getString(TAG_grade);

                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put(TAG_username, username);
                hashMap.put(TAG_name, name);
                hashMap.put(TAG_password, password);
                hashMap.put(TAG_dept,dept);
                hashMap.put(TAG_grade,grade);

                mArrayList.add(hashMap);
            }

            ListAdapter adapter = new SimpleAdapter(
                    EditProfile.this, mArrayList, R.layout.editmain,
                    new String[]{TAG_name,TAG_username, TAG_password,TAG_dept,TAG_grade},
                    new int[]{R.id.textView_list_name, R.id.textView_list_username, R.id.textView_list_password, R.id.textView_list_dept, R.id.textView_list_grade}
            );

            mlistView.setAdapter(adapter);

        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(EditProfile.this, MyAccount.class);
        startActivity(i);
        finish();

    }
    public void btnEditClick(View view) {
        Toast.makeText(EditProfile.this, "Edit Clicked", Toast.LENGTH_SHORT).show();

        ///edit background worker
        Intent i = new Intent(EditProfile.this, MyAccount.class);
        startActivity(i);

    }
    public void btnCancelClick(View view) {
        Toast.makeText(EditProfile.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(EditProfile.this, MyAccount.class);
        startActivity(i);
    }

}

