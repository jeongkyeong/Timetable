package com.example.a4f.myapplication;

import android.database.Cursor;

/**
 * Created by cxz13 on 2017-06-02.
 */

public class MySubjectInfo {

    int course_id;
    int course_code;
    String name; //강의명
    int time; //강의시간
    String Placetime;  // 강의 요일, 장소
    int credit;//학점
    String dept; //학부
    String professor;// 교수

    MySubjectInfo() {
    }

    MySubjectInfo(int course_id, int course_code, String name, int time, String Placetime, int credit,String dept,String professor) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.time = time;
        this.Placetime = Placetime;
        this.credit = credit;
        this.dept=dept;
        this.professor = professor;
    }

    public MySubjectInfo(Cursor cursor){
        course_id = cursor.getInt(0);
        course_code = cursor.getInt(1);
        name = cursor.getString(2);
        time = cursor.getInt(3);
        Placetime = cursor.getString(4);
        credit = cursor.getInt(5);
        dept= cursor.getString(6);
        professor = cursor.getString(7);
    }
}
