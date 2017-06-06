package com.example.a4f.myapplication;

/**
 * Created by 태홍 on 2017-05-30.
 */
import java.io.*;
import java.util.*;

public class SubjectInfo{           //전체 강의를 저장하는 ArrayList
    String course_id;
    String course_code;
    String name; //강의명
    String lectureTime; //강의시간
    String placeTime;  // 강의 요일, 장소
    String credit;//학점
    String subject;//전공인지 교양인지
    String dept; //학부
    String professor;// 교수

    SubjectInfo() {
    }

    SubjectInfo(String course_id,String course_code,String  name,String credit,String lectureTime,String dept,String subject,String professor,String placeTime) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.credit = credit;
        this.subject = subject;
        this.lectureTime = lectureTime   ;
        this.dept= dept;
        this.professor =professor;
        this.placeTime = placeTime;
    }

}