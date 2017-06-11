package com.example.a4f.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    public String getName;
    public String getUsername;
    public String getPassword;
    public String getDept;
    public String getGrade;

    private static String TAG = "jsontest";
    private String username;
    private static final String TAG_JSON="user";
    private static final String TAG_NAME = "name";
    private static final String TAG_USERNAME = "username";
    private static final String TAG_PASSWORD ="password";
    private static final String TAG_DEPT ="dept";
    private static final String TAG_GRADE ="grade";


    ArrayList<HashMap<String, String>> mArrayList;
    TextView tv, tv2;
    String mJsonString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mArrayList = new ArrayList<>();
        NavActivity.GetData task = new NavActivity.GetData();
        Intent i =getIntent();
        username=i.getStringExtra("username");
        try {
            task.execute("http://timetable.dothome.co.kr/getUser.php?username="+URLEncoder.encode(username,"UTF-8"));
        }catch (Exception e){

        }

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void updateText() {
        tv.setText(username);
        tv2.setText(getDept+"  "+getGrade+"학년");
    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(NavActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            //mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null){

                //mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];


            try {

                URL url = new URL(serverURL);
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

                String name = item.getString(TAG_NAME);
                String username = item.getString(TAG_USERNAME);
                String password = item.getString(TAG_PASSWORD);
                String dept = item.getString(TAG_DEPT);
                String grade = item.getString(TAG_GRADE);

                getName = name;
                getUsername = username;
                getPassword = password;
                getDept = dept;
                getGrade = grade;

/*
                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put(TAG_NAME, name);
                hashMap.put(TAG_USERNAME, username);
                hashMap.put(TAG_PASSWORD, password);
                hashMap.put(TAG_DEPT, dept);
                hashMap.put(TAG_GRADE, grade);

                mArrayList.add(hashMap);
*/
            }
/*
            ListAdapter adapter = new SimpleAdapter(
                    EditProfile.this, mArrayList, R.layout.editprofile,
                    new String[]{TAG_NAME,TAG_USERNAME, TAG_PASSWORD,TAG_DEPT,TAG_GRADE},
                    new int[]{R.id.textView_list_name, R.id.textView_list_username, R.id.textView_list_password, R.id.textView_list_dept ,R.id.textView_list_grade}
            );

            mlistView.setAdapter(adapter);
*/
        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }
       // profileInfo();
        this.tv = (TextView) findViewById(R.id.text_username);
        this. tv2 = (TextView) findViewById(R.id.text_department);
         updateText();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main22, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String title=getString(R.string.app_name);
        Fragment frag=null;
        if (id == R.id.nav_account) {
            drawer.closeDrawer(GravityCompat.START);
            Intent i = new Intent(NavActivity.this, MyAccount.class);
            i.putExtra("username",username);
            startActivity(i);
        } else if (id == R.id.nav_make) {
            frag=new MakeTTFragment();
        } else if (id == R.id.nav_options) {
            drawer.closeDrawer(GravityCompat.START);
            Intent i = new Intent(NavActivity.this, Option.class);
            startActivity(i);

        } else if (id == R.id.nav_logout) {
            drawer.closeDrawer(GravityCompat.START);
            Intent i = new Intent(NavActivity.this, MainActivity.class);
            startActivity(i);
        }
        if(frag!=null) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame,frag);
            ft.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
