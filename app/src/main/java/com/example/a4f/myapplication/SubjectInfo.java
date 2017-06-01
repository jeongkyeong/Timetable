package com.example.a4f.myapplication;

/**
 * Created by 태홍 on 2017-05-30.
 */
import java.io.*;
import java.util.*;

public class SubjectInfo{
    String name; //강의명
    int time; //강의시간
    String timePlace;  // 강의 요일, 장소
    int credit;//학점
    String dept; //학부
    String professor;// 교수

    SubjectInfo() {
    }

    SubjectInfo(String name, int time, String timePlace, int credit,String dept,String professor) {
        this.name = name;
        this.time = time;
        this.timePlace = timePlace;
        this.credit = credit;
        this.dept=dept;
        this.professor = professor;
    }

    public static void Save(ArrayList<SubjectInfo> List)
            throws FileNotFoundException {
        PrintWriter Save = new PrintWriter("");
        int i;
        for (i = 0; i < List.size(); i++) {
            Save.println(List.get(i).name + "," + List.get(i).time + ","
                    + List.get(i).timePlace + "," + List.get(i).credit + ","
                    + List.get(i).professor + ",");
        }
        Save.close();
    }

    public static void Load(ArrayList<SubjectInfo> List, File data) {
        Scanner Find = null;
        int point = 0;
        try {
            Find = new Scanner(data);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (Find.hasNext()) {
            int i;
            new SubjectInfo();
            String str = Find.nextLine();
            Scanner scanner = new Scanner(str);
            Scanner extract = scanner.useDelimiter(",");
            List.add(new SubjectInfo());
            /*for (i = 0; i < 5; i++) {
                if (i == 0)
                    List.get(point).name = extract.next();
                else if (i == 1)
                    List.get(point).professor = extract.next();
                else if (i == 2)
                    //List.get(point).day = extract.next();
                else if (i == 3)
                    //List.get(point).hakjum = extract.next();
                else
                    //List.get(point).grade = extract.next();
            }*/
            point++;
            extract.close();
            scanner.close();
        }
        Find.close();
    }
}