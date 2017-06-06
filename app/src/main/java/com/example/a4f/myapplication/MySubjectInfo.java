package com.example.a4f.myapplication;

import android.database.Cursor;

/**
 * Created by cxz13 on 2017-06-02.
 */

public class MySubjectInfo {

    String course_id;
    String course_code;
    String name; //강의명
    String lectureTime; //강의시간
    String placeTime;  // 강의 요일, 장소
    String credit;//학점
    String dept; //학부
    String professor;// 교수

    MySubjectInfo() {
    }

    MySubjectInfo(String course_id, String course_code, String name, String time, String Placetime, String credit,String dept,String professor) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.credit = credit;
        this.lectureTime = time   ;
        this.dept= dept;
        this.professor =professor;
        this.placeTime = Placetime;
    }

    public MySubjectInfo(Cursor cursor){
        course_id = cursor.getString(0);
        course_code = cursor.getString(1);
        name = cursor.getString(2);
        credit = cursor.getString(3);
        lectureTime = cursor.getString(4);
        dept= cursor.getString(5);
        professor = cursor.getString(6);
        placeTime = cursor.getString(7);
    }
}
