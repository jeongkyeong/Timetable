package com.example.a4f.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 상규 on 2017-05-30.
 */

public class HomeFragment extends Fragment{
    public HomeFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        return inflater.inflate(R.layout.activity_main,container,false);
    }
}


