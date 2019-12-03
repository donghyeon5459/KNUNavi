package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText log;
    EditText reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onclick(View v)
    {
        int id;
        id = v.getId();
        switch(id) {
            case R.id.LoginBtn:


                break;
            case R.id.RegistBtn:



                break;
        }


    }


}
