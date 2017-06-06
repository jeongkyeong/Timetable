package com.example.a4f.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by cxz13 on 2017-06-02.
 */

public class SubjectDAO {

    //내부 db에서 array로 내용 가져오기
    public static ArrayList<MySubjectInfo> getItemInfo(Context context){
        ArrayList<MySubjectInfo> itemList = new ArrayList<MySubjectInfo>();

        SubjectDBHelper dbHelper = new SubjectDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + DBTable.SubjectInfoTable.TABLE_NAME+ ";", null);
        while(cursor.moveToNext()){
            MySubjectInfo item = new MySubjectInfo(cursor);
            itemList.add(item);
        }
        return itemList;
    }

    public static void insertItemInfo(Context context, MySubjectInfo subjectInfo){
        SubjectDBHelper dbHelper = new SubjectDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into " + DBTable.SubjectInfoTable.TABLE_NAME +
                " values (" + subjectInfo.course_id+ ", " + subjectInfo.course_code +", '" + subjectInfo.name + "', " +subjectInfo.credit+", '"+ subjectInfo.lectureTime +", '"
                 +subjectInfo.dept+"', '"+subjectInfo.professor+"', "+subjectInfo.placeTime+ "');");
    }

    public static void deleteItemInfo(Context context, MySubjectInfo subjectInfo){
        SubjectDBHelper dbHelper = new SubjectDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + DBTable.SubjectInfoTable.TABLE_NAME +
                " where  " + DBTable.SubjectInfoTable.SUBJECT_ID +" = " + subjectInfo.course_id + ";");
    }

}
