package com.example.a4f.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 태홍 on 2017-05-30.
 */
public class EntireTTActivity extends AppCompatActivity {
    static int colorflag = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entiretimetable);

        }
        public void onClick10(View v) {
        String a = "102관(102관(약학대학 및 R&D센터)) 505호 <강의실>(월4,5,6, 화4,5,6, 수4,5,6, 목4,5,6, 금4,5,6)";
        String[] b = a.split("\\(");
        String allDay = b[b.length-1];
        //마지막 문자 제거
        allDay = allDay.substring(0, allDay.length()-1);
        String[] c = allDay.split(" ");
        ArrayList<SubjectInfo> Info = new ArrayList<SubjectInfo>();
        int col = 0;
        col = choosecolor(col);
        for (String aC : c)
            FilllectureTimetable(Info, aC, col);//c0] =월4,5,6, 화4,5,6, 수4,5,6, 목4,5,6, 금4,5,6
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
                break;
        }
        colorflag++;
        return col;
    }
    protected void FilllectureTimetable(ArrayList<SubjectInfo> Info,String A, int col) //테이블에 채우기
    {
        int nameflag = 1;
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
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue1);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed1);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu1);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri1);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 2:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon2);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue2);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed2);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu2);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri2);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 3:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon3);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue3);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed3);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu3);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri3);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 4:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon4);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue4);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed4);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu4);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri4);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 5:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon5);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue5);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed5);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu5);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri5);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 6:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon6);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue6);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed6);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu6);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri6);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 7:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon7);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue7);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed7);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu7);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri7);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 8:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon8);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue8);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed8);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu8);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri8);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
                case 9:
                    if (A.substring(0, 1).equals("월")) {
                        TV = (TextView) findViewById(R.id.mon9);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("화")) {
                        TV = (TextView) findViewById(R.id.tue9);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("수")) {
                        TV = (TextView) findViewById(R.id.wed9);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("목")) {
                        TV = (TextView) findViewById(R.id.thu9);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    } else if (A.substring(0, 1).equals("금")){
                        TV = (TextView) findViewById(R.id.fri9);
                        if (nameflag == 0) {
                            TV.setText(Info.get(i).name + Info.get(i).professor + Info.get(i).lectureTime);
                            nameflag = 1;
                        }
                        TV.setBackgroundColor(col);
                    }
                    break;
            }
        }
    }
}