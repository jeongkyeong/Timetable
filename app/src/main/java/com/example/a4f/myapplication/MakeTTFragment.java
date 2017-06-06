package com.example.a4f.myapplication;
import org.json.*;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MakeTTFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView courseListView;
    private CourseListAdapter courseAdapter;
    private List<MySubjectInfo> courseList;
    public MakeTTFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MakeTTFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MakeTTFragment newInstance(String param1, String param2) {
        MakeTTFragment fragment = new MakeTTFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.maketimetable, container, false);
    }

    private ArrayAdapter creditAdapter;
    private Spinner creditSpinner;
    private ArrayAdapter hourAdapter;
    private Spinner hourSpinner;
    private ArrayAdapter deptAdapter;
    private Spinner deptSpinner;

    private String courseCredit="";
    private String courseHour="";
    private String courseDept="";

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        creditSpinner=(Spinner)getView().findViewById(R.id.spinnerCredits);
        hourSpinner=(Spinner)getView().findViewById(R.id.spinnerHour);
        deptSpinner=(Spinner)getView().findViewById(R.id.spinnerDept);

        final RadioGroup checkCourseType=(RadioGroup)getView().findViewById(R.id.courseCheckGruop);

        checkCourseType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton checkRB=(RadioButton)getView().findViewById(i);
                String check=checkRB.getText().toString();

                creditAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.credits,android.R.layout.simple_spinner_dropdown_item);
                creditSpinner.setAdapter(creditAdapter);

                hourAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.hours,android.R.layout.simple_spinner_dropdown_item);
                hourSpinner.setAdapter(hourAdapter);

                deptAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.dept,android.R.layout.simple_spinner_dropdown_item);
                deptSpinner.setAdapter(deptAdapter);
            }
        });

        courseListView=(ListView)getView().findViewById(R.id.courseList);
        courseList=new ArrayList<MySubjectInfo>();      //과목정보 담을 ArrayList생성.

        Button searchBtn = (Button) getView().findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener(){    //search버튼 클릭시.
            @Override
            public void onClick(View view) {
                courseCredit=creditSpinner.getSelectedItem().toString();
                courseHour=hourSpinner.getSelectedItem().toString();
                courseDept=deptSpinner.getSelectedItem().toString();
                String type="course list";
                BackgroundWorker backgroundWorker=new BackgroundWorker(getActivity());
                try {
                    String result =backgroundWorker.execute(type,courseCredit,courseHour,courseDept).get();
                    courseList.clear();
                    try{
                        int count=0;
                        JSONObject jsonObject =new JSONObject(result);
                        JSONArray jsonArray=jsonObject.getJSONArray("response");
                        String course_id;
                        String course_code;
                        String name; //강의명
                        String lectureTime; //강의시간
                        String placeTime;  // 강의 요일, 장소
                        String credit;//학점
                        String dept; //학부
                        String professor;// 교수
                        while(count<jsonArray.length()) {       //db에서 받아온정보를 ArrayList에 하나씩 담음.
                            JSONObject object=jsonArray.getJSONObject(count);
                            course_id=object.getString("course_id");
                            course_code=object.getString("course_code");
                            credit=object.getString("course_name");
                            name=object.getString("credit");
                            lectureTime=object.getString("lecture_time");
                            dept=object.getString("department");
                            professor=object.getString("professor");
                            placeTime=object.getString("place_time");
                            MySubjectInfo course=new MySubjectInfo(course_id, course_code,  name,  lectureTime,  placeTime,  credit, dept, professor);
                            courseList.add(course);
                            count++;
                        }
                    }catch (JSONException e){ }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                courseAdapter=new CourseListAdapter(getContext().getApplicationContext(),courseList);   //ArrayList를 listview 내용에 추가.
                courseListView.setAdapter(courseAdapter);
            }
        });
    }
}
