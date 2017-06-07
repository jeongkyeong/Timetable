package com.example.a4f.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.a4f.myapplication.R.id.courseCode;

/**
 * Created by 상규 on 2017-06-06.
 */

public class CourseListAdapter extends BaseAdapter {
    private Context context;
    private List<SubjectInfo> courseList;
    MakeTTFragment a = new MakeTTFragment();
    public CourseListAdapter(Context context,List<SubjectInfo> course) {
        this.context=context;
        this.courseList =course;
    }

    public int getCount(){return courseList.size();}

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context,R.layout.course,null);
        if(courseList.get(i).subject.equals(a.check)) {
            TextView courseCode = (TextView) v.findViewById(R.id.courseCode);
            TextView courseTitle = (TextView) v.findViewById(R.id.courseTitle);
            TextView courseCredit = (TextView) v.findViewById(R.id.courseCredit);
            TextView courseProf = (TextView) v.findViewById(R.id.courseProf);
            TextView coursePlace = (TextView) v.findViewById(R.id.coursePlace);
            courseCode.setText("code : " + courseList.get(i).course_code);
            courseTitle.setText("Title : " + courseList.get(i).name);
            courseCredit.setText("Title : " + courseList.get(i).credit);
            courseProf.setText("professor : " + courseList.get(i).professor);
            coursePlace.setText("place / time : " + courseList.get(i).placeTime);
            v.setTag(courseList.get(i).course_id);
        }
        return v;
    }

}
