package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class registActivity extends AppCompatActivity {

    SQLiteDatabase UserDB;
    EditText editTextNum;
    EditText editTextName;
    EditText editTextId;
    EditText editTextPw;
    String tableName1="user";
    String tableName2="timetable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        UserDB=openOrCreateDatabase("studentDB",MODE_PRIVATE,null);
        UserDB.execSQL("create table if not exists "+tableName1+"("+"STUNUM VARCHAR, "+"NAME VARCHAR, "+"ID VARCHAR, "+"PASSWORD VARCHAR, "+"PRIMARY KEY (STUNUM))");
        UserDB.execSQL("create table if not exists "+tableName2+"( STUNUM VARCHAR, COURSE VARCHAR, COURSENUM VARCHAR, DAY VARCHAR, LOCATION VARCHAR, START VARCHAR, END VARCHAR)");

        editTextNum;
        editTextName;
        editTextId;
        editTextPw;

    }
    private void insertRecord(String num,String name,String id,String pw){
        String var1="'"+num+"'";
        String var2="'"+name+"'";
        String var3="'"+id+"'";
        String var4="'"+pw+"'";
        UserDB.execSQL("insert into "+tableName1+"(STUNUM NAME ID PASSWORD) "+"values "+"("+var1+","+var2+","+var3+","+var4+")");
    }
}
