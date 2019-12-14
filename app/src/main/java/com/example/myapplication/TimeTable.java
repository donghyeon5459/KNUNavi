package com.example.myapplication;


import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeTable extends Fragment {

    String table_name="timetable";
    ArrayList<String> list=new ArrayList<>();
    ArrayList<TextView> monList=new ArrayList<>();
    ArrayList<TextView> tueList=new ArrayList<>();
    ArrayList<TextView> wedList=new ArrayList<>();
    ArrayList<TextView> thuList=new ArrayList<>();
    ArrayList<TextView> friList=new ArrayList<>();
    public TimeTable() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_time_table, container, false);
        Cursor cursor=MainActivity.UserDB.rawQuery("select DAY, START, END from "+table_name+" where STUNUM = "+currentuser.Snum,null);
        makeList();
        makeTextviewList(view);
        String day;
        String start;
        String end;
        while (cursor.moveToNext()) { //행 데이터 개수만큼 반복
            day= cursor.getString(0) ; //현재 커서의 열 번호 데이터값을 반환//DAY
            start= cursor.getString(1);
            end=cursor.getString(2);
            int stime=Integer.parseInt(start)/1000;
            int etime=Integer.parseInt(end)/1000;
            System.out.println("22222222222222222222222222222222222222222222222222222222222222"+stime+" "+etime);
            switch(day){
                case "월":
                    for(int j=stime;j<etime;j++)
                    {
                        monList.get(j-9).setBackgroundColor(0xfff00000);
                    }
                    break;
                case "화":
                    for(int j=stime;j<etime;j++)
                    {
                        tueList.get(j-9).setBackgroundColor(0xfff00000);
                    }
                    break;
                case "수":
                    for(int j=stime;j<etime;j++)
                    {
                        wedList.get(j-9).setBackgroundColor(0xfff00000);
                    }
                    break;
                case "목":
                    for(int j=stime;j<etime;j++)
                    {
                        thuList.get(j-9).setBackgroundColor(0xfff00000);
                    }
                    break;
                case "금":
                    for(int j=stime;j<etime;j++)
                    {
                        friList.get(j-9).setBackgroundColor(0xfff00000);
                    }
                    break;

            }
        }




        return view;
    }
    private void makeList(){
        int i;

        for(i=900;i<1900;i+=100){
            String num=Integer.toString(i);
            list.add("R.id.mon"+num);
            list.add("R.id.tue"+num);
            list.add("R.id.wed"+num);
            list.add("R.id.thu"+num);
            list.add("R.id.fri"+num);
        }


    }
    private void makeTextviewList(View view){
        for (int j=0;j<50;j=j+5) {
            TextView view1 = view.findViewById(getResources().getIdentifier(list.get(j),"id","com.example.myapplication"));
            monList.add(view1);
            TextView view2 = view.findViewById(getResources().getIdentifier(list.get(j+1),"id","com.example.myapplication"));
            tueList.add(view2);
            TextView view3 = view.findViewById(getResources().getIdentifier(list.get(j+2),"id","com.example.myapplication"));
            wedList.add(view3);
            TextView view4 = view.findViewById(getResources().getIdentifier(list.get(j+3),"id","com.example.myapplication"));
            thuList.add(view4);
            TextView view5 = view.findViewById(getResources().getIdentifier(list.get(j+4),"id","com.example.myapplication"));
            friList.add(view5);
        }

    }

}
