package com.example.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;

import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import androidx.annotation.UiThread;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.naver.maps.map.MapFragment;
import com.naver.maps.map.OnMapReadyCallback;

public class map extends Fragment {

    MapFragment mapFragment;

    private GpsTracker gpsTracker;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};


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
