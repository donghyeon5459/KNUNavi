package com.example.myapplication;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyTable extends Fragment {

    //SQLiteDatabase UserDB;
    String tableName2="timetable";
    String eday;

    EditText edit_courseName;
    EditText edit_courseNum;
    Spinner edit_day;
    EditText edit_location;
    TimePicker edit_start;
    TimePicker edit_end;
    ArrayList<String> Day;
    ArrayAdapter arrayAdapter;
    String startHr,startMin,endHr,endMin;
    String startTime,endTime;
    public ModifyTable() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_modify_table, container, false);
        edit_courseName= view.findViewById(R.id.ecourse);
        edit_courseNum=view.findViewById(R.id.ecoursenum);
        edit_day=view.findViewById(R.id.eday);
        edit_location=view.findViewById(R.id.elocation);
        edit_start=view.findViewById(R.id.estart);
        edit_end=view.findViewById(R.id.eend);
        Day=new ArrayList<String>();
        Day.add("월");
        Day.add("화");
        Day.add("수");
        Day.add("목");
        Day.add("금");

        arrayAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_dropdown_item, Day);
        edit_day.setAdapter(arrayAdapter);
        edit_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println("df");
                eday = Day.get(i);

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        edit_start.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                startHr=String.format("%02d",hour);
                startMin=String.format("%02d",minute);
                startTime=startHr+startMin;//시작시간 저장 문자열

            }
        });
        edit_end.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                endHr=String.format("%02d",hour);
                endMin= String.format("%02d",minute);
                endTime=endHr+endMin;//종료시간 저장 문자열
            }
        });
        Button save_button=view.findViewById(R.id.save);
        save_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                System.out.println( edit_courseName.getText().toString() );
                System.out.println( edit_courseNum.getText().toString() );
                System.out.println(startTime+"       "+endTime);
                insertTable(currentuser.Snum,    edit_courseName.getText().toString(),   edit_courseNum.getText().toString(),  eday,edit_location.getText().toString(),startTime,endTime);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    private void insertTable(String Snum,String courseName,String courseNum,String day,String location,String start,String end){
        String var1="'"+Snum+"'";
        String var2="'"+courseName+"'";
        String var3="'"+courseNum+"'";
        String var4="'"+day+"'";
        String var5="'"+location+"'";
        String var6="'"+start+"'";
        String var7="'"+end+"'";
        System.out.println("insert into "+tableName2+"(STUNUM, COURSE, COURSENUM, DAY, LOCATION, START, END) "+"values "+"("+var1+","+var2+","+var3+","+var4+","+var5+","+var6+","+var7+")");
        MainActivity.UserDB.execSQL("insert into "+tableName2+"(STUNUM, COURSE, COURSENUM, DAY, LOCATION, START, END) "+"values "+"("+var1+","+var2+","+var3+","+var4+","+var5+","+var6+","+var7+")");
    }

}
