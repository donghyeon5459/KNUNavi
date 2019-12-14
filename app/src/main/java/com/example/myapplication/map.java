package com.example.myapplication;

import android.Manifest;
import android.graphics.Color;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import androidx.annotation.UiThread;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

public class map extends FragmentActivity implements OnMapReadyCallback {

    MapFragment mapFragment;
    GpsTracker gp;
    int day;
    Calendar cal = Calendar.getInstance();
    String korDay;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmap);

        day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case 1:
                korDay = "일";
                break;
            case 2:
                korDay = "월";
                break;
            case 3:
                korDay = "화";
                break;
            case 4:
                korDay = "수";
                break;
            case 5:
                korDay = "목";
                break;
            case 6:
                korDay = "금";
                break;
            case 7:
                korDay = "토";
                break;
        }

        System.out.println(korDay);
        //MainActivity.UserDB
        gp = new GpsTracker(this);
        mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null)
        {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setMapType(NaverMap.MapType.Navi);

        naverMap.setSymbolScale(1.0f);
        LatLng curlo = new LatLng(  gp.getLatitude(), gp.getLongitude() );

        CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(curlo);
        naverMap.moveCamera(cameraUpdate1);

        CameraUpdate cameraUpdate2 = CameraUpdate.zoomTo(16);
        naverMap.moveCamera(cameraUpdate2);

        Marker marker1 = new Marker();
        marker1.setPosition(curlo);
        marker1.setMap(naverMap);

        marker1.setSubCaptionText("현위치");
        marker1.setSubCaptionColor(Color.GREEN);
        marker1.setSubCaptionHaloColor(Color.YELLOW);
        marker1.setSubCaptionTextSize(10);
    }
}
