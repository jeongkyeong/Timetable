package com.example.a4f.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cxz13 on 2017-06-02.
 */

public class SubjectDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "timeTable.db";

    private static final String CREATE_TABLE_ITEM_INFO = "create table "
            + DBTable.SubjectInfoTable.TABLE_NAME + "("
            + DBTable.SubjectInfoTable.SUBJECT_ID + " int primary key, "
            + DBTable.SubjectInfoTable.SUBJECT_CODE + " int, "
            + DBTable.SubjectInfoTable.SUBJECT_NAME + " text, "
            + DBTable.SubjectInfoTable.SUBJECT_CREDIT + " int, "
            + DBTable.SubjectInfoTable.SUBJECT_TIME + " int, "
            + DBTable.SubjectInfoTable.SUBJECT_DEPT + " text, "
            + DBTable.SubjectInfoTable.SUBJECT_SUBJECT + " text, "
            + DBTable.SubjectInfoTable.SUBJECT_PROFESSOR + "text , "
            + DBTable.SubjectInfoTable.SUBJECT_PLACETIME + " text ); ";

    public SubjectDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITEM_INFO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DBTable.SubjectInfoTable.TABLE_NAME);
        onCreate(db);
    }
}
