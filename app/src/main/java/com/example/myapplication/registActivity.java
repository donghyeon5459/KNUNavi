package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registActivity extends AppCompatActivity {

    public static SQLiteDatabase UserDB;
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
        //UserDB=openOrCreateDatabase("studentDB",);
        UserDB.execSQL("create table if not exists "+tableName1+"("+"STUNUM TEXT, "+"NAME TEXT, "+"ID TEXT, "+"PASSWORD TEXT, "+"PRIMARY KEY (STUNUM))");
        UserDB.execSQL("create table if not exists "+tableName2+"( STUNUM TEXT, COURSE TEXT, COURSENUM TEXT, DAY TEXT, LOCATION TEXT, START VARCHAR, END TEXT)");

        editTextNum=findViewById(R.id.edit_num);
        editTextName=findViewById(R.id.edit_name);
        editTextId=findViewById(R.id.edit_id);
        editTextPw=findViewById(R.id.edit_pw);

        Button save_button=findViewById(R.id.save_btn);
        save_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                insertRecord(editTextNum.getText().toString(),editTextName.getText().toString(),editTextId.getText().toString(),editTextPw.getText().toString());
                finish();
            }
        });
    }
    private void insertRecord(String num,String name,String id,String pw){
        String var1="'"+num+"'";
        String var2="'"+name+"'";
        String var3="'"+id+"'";
        String var4="'"+pw+"'";
        UserDB.execSQL("insert into "+tableName1+"(STUNUM, NAME, ID, PASSWORD) "+"values "+"("+var1+","+var2+","+var3+","+var4+")");
    }
}
