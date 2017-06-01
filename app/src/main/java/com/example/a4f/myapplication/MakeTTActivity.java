package com.example.a4f.myapplication;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.view.View;

import java.lang.reflect.Array;

/**
 * Created by 태홍 on 2017-05-31.
 */

public class MakeTTActivity extends Fragment {

    public MakeTTActivity() {
    }
/*

    private ArrayAdapter creditAdapter;
    private Spinner creditSpinner=(Spinner)getView().findViewById(R.id.spinnerCredits);
    private ArrayAdapter hourAdapter;
    private Spinner hourSpinner=(Spinner)getView().findViewById(R.id.spinnerHour);
    private ArrayAdapter deptAdapter;
    private Spinner deptSpinner=(Spinner)getView().findViewById(R.id.spinnerDept);

    private String courseCredit="";
    private String courseHour="";
    private String courseDept="";
    private RadioGroup checkCourseType=(RadioGroup)getView().findViewById(R.id.courseCheckGruop);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        checkCourseType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton checkRB=(RadioButton)findViewById(i);
                String check=checkRB.getText().toString();

                creditAdapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.credit,android.R.layout.simple_spinner_dropdown_item);
                creditSpinner.setAdapter(creditAdapter);

                hourAdapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.hours,android.R.layout.simple_spinner_dropdown_item);
                hourSpinner.setAdapter(hourAdapter);


                deptAdapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.dept,android.R.layout.simple_spinner_dropdown_item);
                deptSpinner.setAdapter(deptAdapter);
            }
        });
    }
*/

}
