package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class registActivity extends AppCompatActivity {

    SQLiteDatabase UserDB;
    EditText getName;
    EditText getId;
    EditText getNum;
    EditText getPw;
    String tableName1="user";
    String tableName2="timetable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        UserDB=openOrCreateDatabase("studentDB",MODE_PRIVATE,null);
        UserDB.execSQL("create table if not exists "+tableName1+"("+"STUNUM VARCHAR, "+"NAME VARCHAR, "+"ID VARCHAR, "+"PASSWORD VARCHAR, "+"PRIMARY KEY (STUNUM))");


    }
}
