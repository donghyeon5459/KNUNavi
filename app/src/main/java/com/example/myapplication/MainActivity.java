package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText ide;
    EditText pwe;
    Button bu;
    String id;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onclick(View v)
    {
        int vid;
        vid = v.getId();
        switch(vid) {
            case R.id.LoginBtn:
                ide = (EditText)findViewById(R.id.idInput);
                pwe = (EditText)findViewById(R.id.pwInput);
                id = ide.getText().toString();
                pw = pwe.getText().toString();

                break;
            case R.id.RegistBtn:




                break;
        }
    }
}
