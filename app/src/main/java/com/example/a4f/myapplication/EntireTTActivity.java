package com.example.a4f.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by 태홍 on 2017-05-30.
 */
public class EntireTTActivity extends AppCompatActivity {
    static int colorflag = 1;
    static int count =0;
    private String grade;
    private int credits;
    private String major;
    private String noClasses;
    private ArrayList<ArrayList<SubjectInfo>> tableList;
    private ArrayList<SubjectInfo> courseList;
    private Spinner tableSpinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entiretimetable);
        Intent i = getIntent();
        courseList=new ArrayList<SubjectInfo>();
        grade=i.getStringExtra("grade");
        credits=Integer.parseInt(i.getStringExtra("credits"));
        major=i.getStringExtra("major");
        noClasses=i.getStringExtra("noClass");
        tableSpinner=(Spinner)findViewById(R.id.spinnerTable);
        if(count==0) {
            good("ACT", "도선재", "310관(310관) 620호 <강의실>(월3,4, 화3,4, 수3,4, 목3,4, 금3,4)");
            count++;
        }
        else if(count==1)
        {
            good("ACT","도선재","310관(310관) 620호 <강의실>(월3,4, 화3,4, 수3,4, 목3,4, 금3,4)");
            good("글쓰기","최유숙","310관(310관) 622호 <강의실>(월7,8, 화7,8, 수7,8, 목7,8, 금7,8)");
        }
        else{}
            //good(i.getExtras().getString("placeTime"));
       /* Button back;
        back = (Button)findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(EntireTTActivity.this, MakeTTFragment.class);
              //  startActivity(intent);
               // finish();
                Bundle bundle = new Bundle();
                MakeTTFragment a = new MakeTTFragment();
                a.setArguments(bundle);
            }
        });*/
        }
        public void good(String ah ,String bh, String ch) {
       // a = "102관(102관(약학대학 및 R&D센터)) 505호 <강의실>(월4,5,6, 화4,5,6, 수4,5,6, 목4,5,6, 금4,5,6)";
        String[] b = ch.split("\\(");
        String allDay = b[b.length-1];
        //마지막 문자 제거
        allDay = allDay.substring(0, allDay.length()-1);
        String[] c = allDay.split(" ");
            Intent i = getIntent();
            MakeTTFragment MTT = new MakeTTFragment();
        int col = 0;
        col = choosecolor(col);
        for (String aC : c)
            FilllectureTimetable(ah,bh,ch, aC, col);//c0] =월4,5,6, 화4,5,6, 수4,5,6, 목4,5,6, 금4,5,6
    }
    protected int choosecolor(int col)
    {
        switch(colorflag)
        {
            case 1:
                col = getResources().getColor(R.color.TT1);
                break;
            case 2:
                col = getResources().getColor(R.color.TT2);
                break;
            case 3:
                col = getResources().getColor(R.color.TT3);
                break;
            case 4:
                col = getResources().getColor(R.color.TT4);
                break;
            case 5:
                col = getResources().getColor(R.color.TT5);
                break;
            case 6:
                col = getResources().getColor(R.color.TT6);
                break;
            case 7:
                col = getResources().getColor(R.color.TT7);
                colorflag=1;
                break;
        }
        colorflag++;
        return col;
    }
    protected void FilllectureTimetable(String name,String professor,String placeTime,String A, int col) //테이블에 채우기
    {
        int nameflag = 0;
        TextView TV;
        String b;
        b = A.substring(1,A.length());
        String[] c = b.split(",");
        for(int i=0;i<c.length;i++)
        {
            switch (Integer.parseInt(c[i]))
            {
                case 1:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon1);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue1);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed1);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu1);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri1);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 2:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon2);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue2);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed2);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu2);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri2);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 3:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon3);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue3);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed3);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu3);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri3);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 4:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon4);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue4);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed4);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu4);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri4);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 5:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon5);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue5);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed5);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu5);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri5);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 6:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon6);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue6);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed6);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu6);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri6);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 7:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon7);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue7);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed7);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu7);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri7);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 8:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon8);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue8);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed8);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu8);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri8);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 9:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon9);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue9);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed9);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu9);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri9);
                        if (nameflag == 0) {
                            TV.setText(name+"\n"+professor+"\n"+placeTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
            }
        }
    }

    public void btnMakeTableClick(View view){
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        String type="make table";
        SharedPreferences userData = getSharedPreferences("userData", MODE_PRIVATE);
        String deptartment = userData.getString("Dept","");

        try {
            String result=backgroundWorker.execute(type,grade,deptartment).get();
            courseList.clear();
            try{
                int count=0;
                JSONObject jsonObject =new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("response");
                String course_id;
                String name; //강의명
                String grade;
                String major;
                String lectureTime; //강의시간
                String credit;//학점
                String dept; //학부
                String professor;// 교수
                while(count<jsonArray.length()) {       //db에서 받아온정보를 ArrayList에 하나씩 담음.
                    JSONObject object=jsonArray.getJSONObject(count);
                    course_id=object.getString("course_id");
                    name=object.getString("course_name");
                    grade=object.getString("grade");
                    lectureTime=object.getString("lecture_time");
                    dept=object.getString("department");
                    professor=object.getString("professor");
                    major=object.getString("major");
                    credit = object.getString("credit");
                    SubjectInfo course=new SubjectInfo(course_id, "",  name,credit,lectureTime, dept,major, professor,"");
                    courseList.add(course);
                    count++;
                }
            }catch (JSONException e){ }

        }   catch (Exception e) { e.printStackTrace(); }
        Combination combination=new Combination(courseList,credits,noClasses);

        combination.doCombination(courseList.size(),2,0);
        ArrayList<String> entries=new ArrayList<String>();
        tableList=combination.getTabletList();
        setEntries(tableList,entries);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,entries);
        tableSpinner.setAdapter(arrayAdapter);
    }

    public void setEntries(ArrayList<ArrayList<SubjectInfo>> dbList,ArrayList<String> entries)
    {
        for(int i=0;i<dbList.size();i++) {
            entries.add("Table "+i);
        }
    }

    public void onBackPressed() {
        Intent i = new Intent(EntireTTActivity.this, NavActivity.class);
        startActivity(i);
        finish();

    }
}