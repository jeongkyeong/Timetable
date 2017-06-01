package com.example.a4f.myapplication;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MakeTTFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

                creditAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.credit,android.R.layout.simple_spinner_dropdown_item);
                creditSpinner.setAdapter(creditAdapter);

                hourAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.hours,android.R.layout.simple_spinner_dropdown_item);
                hourSpinner.setAdapter(hourAdapter);

                deptAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.dept,android.R.layout.simple_spinner_dropdown_item);
                deptSpinner.setAdapter(deptAdapter);
            }
        });

        Button searchBtn = (Button) getView().findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                courseCredit=creditSpinner.getSelectedItem().toString();
                courseHour=hourSpinner.getSelectedItem().toString();
                courseDept=deptSpinner.getSelectedItem().toString();
                String type="course list";
                BackgroundWorker backgroundWorker=new BackgroundWorker(getActivity());
                backgroundWorker.execute(type,courseCredit,courseHour,courseDept);
            }
        });
    }
}
