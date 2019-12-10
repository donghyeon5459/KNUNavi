package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




import androidx.annotation.Nullable;
import androidx.annotation.UiThread;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.naver.maps.map.MapFragment;
import com.naver.maps.map.OnMapReadyCallback;

public class map extends Fragment {

    MapFragment mapFragment;
    public map(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.showmap, container, false);
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);




        return view;
    }


}
