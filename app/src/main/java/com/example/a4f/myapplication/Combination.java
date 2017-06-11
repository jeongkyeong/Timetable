package com.example.a4f.myapplication;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.security.auth.Subject;

/**
 * Created by 상규 on 2017-06-10.
 */

public class Combination {
    private ArrayList <SubjectInfo> arrList;     //기준 어레이리스트
    private ArrayList<SubjectInfo> stList; //조합을 저장할 스택리스트
    private ArrayList<SubjectInfo> resultList; //요구학점 조건을 만족한 최종 리스트
    private ArrayList<SubjectList> dbList;
    private String noClass;
    private int limitCr=0;
    private enum Day {월,화,수,목,금}

    private int [][] timeArr=new int[9][5];
    public Combination(ArrayList<SubjectInfo> arr,int credits,String noClass){
        this.arrList = arr;             //배열을 받아 객체에 저장한다.
        stList = new ArrayList<SubjectInfo>(); //스택에 메모리를 할당한다.
        resultList=new ArrayList<SubjectInfo>();
        limitCr=credits;
        this.noClass=noClass;
        dbList=new ArrayList<SubjectList>();
    }
    public ArrayList<SubjectList> getTabletList(){
        return dbList;
    }

    public boolean checkTime() //시간표 중복된거 있는지 검사
    {
        for(int i=0;i<9;i++) {
            for(int j=0;j<5;j++) {
                if(timeArr[i][j]>1) return false;
            }
        }
        return true;
    }

    public boolean parsingTime(String time,int level){     //시간 parsing
        String tok="";
        if(level==0){       //  0단계 : '/'로 구분된 시간 구분
            StringTokenizer stoken=new StringTokenizer(time,"/");
            while(stoken.hasMoreTokens()) {
                tok=stoken.nextToken().trim();
                if(!parsingTime(tok,level+1)) return false;
            }
        }else if(level==1){     //  1단계 화1,2,3 -> 화요일 1,2,3 을 timeArr배열에 1로 표시.
            String strDay=time.substring(0,1);
            if(strDay.equals(noClass)) return false;
            Day day=Day.valueOf(time.substring(0,1));
            tok=time.substring(1);
            StringTokenizer stoken=new StringTokenizer(tok,",");
            while(stoken.hasMoreElements()){
                tok=stoken.nextToken().trim();
                int timeNum=Integer.parseInt(tok);
                timeArr[timeNum-1][day.ordinal()]+=1;
            }
        }
        return true;
    }
    public void initArr()
    {
        for(int i=0;i<9;i++) {
            for(int j=0;j<5;j++) {
                timeArr[i][j]=0;
            }
        }
    }
    public void checkCond(){
        //스택에 있는 값들을 출력한다.
        int sum=0,sum2nd=0;
        for(int i=0;i<stList.size();i++){
            sum+=Integer.parseInt(stList.get(i).credit.substring(0,1));
        }
        if(sum<=limitCr&&sum>=limitCr-4) {
            for(int i=0;i<stList.size();i++) {
                if(parsingTime(stList.get(i).lectureTime,0)){
                    SubjectInfo course =stList.get(i);
                    resultList.add(course);
                    sum2nd+=Integer.parseInt(stList.get(i).credit.substring(0,1));
                }
            }
        }
        if(sum2nd>limitCr||sum2nd<limitCr-4) resultList.clear();

        if(checkTime()&&!resultList.isEmpty()) dbList.add(new SubjectList(resultList));
        resultList.clear();
        initArr();
    }

    public void doCombination(int n, int r, int index){
        // n : 전체 개수
        // r : 뽑을 개수
        // index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
        if(r==0){
            checkCond();
            return;
        }
        else if(n==r){
            //nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
            for(int i=0;i<n;i++)stList.add(arrList.get(index+i));//index부터 n개를 차례대로 스택에 넣고
            checkCond(); //스택을 보여준다.
            stList.clear();        //이후 전부 pop을 시켜 다음 과정을 진행한다.
        }
        else if(n<0||r<0) return;
        else{
            //저 두가지 예외 사항을 빼면 점화식대로 진행 index를 포함하는 경우
            try{
                stList.add(arrList.get(index));
                doCombination(n-1,r-1,index+1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

                //index를 포함하지 않는 경우
                stList.remove(arrList.get(index)); //index를 제거해주고
                doCombination(n-1, r, index+1); //index를 제외한 상태에서 n-1Cr 진행.
            }catch (Exception e){}
        }
    }
}



