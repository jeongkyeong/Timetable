package com.example.a4f.myapplication;

import java.util.ArrayList;

/**
 * Created by 상규 on 2017-06-12.
 */

public class SubjectList {
    ArrayList<SubjectInfo> list;
    SubjectList(ArrayList<SubjectInfo> list){
        this.list=new ArrayList<SubjectInfo>(list);
    }
    @Override
    public int hashCode(){
        return (this.list.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SubjectList) {
            SubjectList temp = (SubjectList) obj;
            if (this.list.equals(temp.list)) {
                return true;
            }
        }
        return false;
    }
}
