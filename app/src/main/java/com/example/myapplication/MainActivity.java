package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase UserDB;
    EditText ide;
    EditText pwe;
    Button bu;
    String id;
    String pw;
    String table_name="user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onclick(View v)
    {
        int vid;
        int record_num;
        int pw_num;
        vid = v.getId();
        switch(vid) {
            case R.id.LoginBtn:
                ide = (EditText)findViewById(R.id.idInput);
                pwe = (EditText)findViewById(R.id.pwInput);
                id = "'"+ide.getText().toString()+"'";
                pw =pwe.getText().toString();

                UserDB=openOrCreateDatabase("studentDB",MODE_PRIVATE,null);
                Cursor cursor=UserDB.rawQuery("select ID, PASSWORD from "+table_name+" where ID = "+id,null);
                System.out.println("여기보세요");
               // cursor.moveToNext();
               // System.out.println(cursor.getString(0)+cursor.getString(1));
                record_num=cursor.getCount();
                if(record_num==0){//아이디가 존재하지 않는경우
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림").setCancelable(false).setNegativeButton("확인",null);
                    builder.setMessage("회원정보가 존재하지 않습니다.");
                    AlertDialog alert=builder.create();
                    alert.show();
                }
                else{
                    cursor.moveToNext();
                    String password=cursor.getString(1);
                    if(password.equals(pw)) {
                        Intent intent2 = new Intent(this, nav.class);
                        startActivity(intent2);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("알림").setCancelable(false).setNegativeButton("확인",null);
                        builder.setMessage("비밀번호가 일치하지 않습니다.");
                        AlertDialog alert=builder.create();
                        alert.show();

                    }
                }

                break;
            case R.id.RegistBtn:
                Intent intent=new Intent(this,registActivity.class);
                startActivity(intent);



                break;
        }
    }
}
