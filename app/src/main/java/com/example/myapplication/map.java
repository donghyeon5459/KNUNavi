package com.example.myapplication;

import android.Manifest;
import android.database.Cursor;
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
import java.util.ArrayList;
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
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

public class map extends FragmentActivity implements OnMapReadyCallback {

    MapFragment mapFragment;
    GpsTracker gp;
    int day;
    int hour;
    Calendar cal = Calendar.getInstance();
    String korDay;
    String table_name;
    ArrayList<String> start;
    ArrayList<String>  location;
    LatLng it4, it5;
    String minlocation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmap);

        start = new ArrayList<String >();
        location = new ArrayList<String>();

        it4 = new LatLng(  35.888187, 128.610944 );
        it5 = new LatLng( 35.888093, 128.611634 );

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
        korDay = '"'+korDay+'"';
        //korDay = '"'+"월"+'"';
        table_name="timetable";

        hour = cal.get(Calendar.HOUR_OF_DAY);
        //System.out.println(korDay);

        Cursor cursor=MainActivity.UserDB.rawQuery("select * from "+table_name+" where STUNUM = "+  "'" +   currentuser.Snum   +"'"      +" AND DAY = "+korDay,null);
        System.out.println(cursor.getCount());
        //cursor.moveToNext();
        //System.out.println(cursor.getString(0));
        for(int i=0; i< cursor.getCount(); i++)
        {
            cursor.moveToNext();
            location.add(cursor.getString(4));
            start.add(cursor.getString(5));

            System.out.println(location.get(i));
            System.out.println(start.get(i));


        }
        int min = 9999;
        int temp;
        for(int i=0; i< cursor.getCount(); i++)
        {

            temp = Integer.parseInt( start.get(i).substring(0,2)  );
            System.out.println(temp);
            if ( temp < min  && temp > hour  ) {

                System.out.println("fgjkjvjkcjcjcjk");
                System.out.println(hour);
                System.out.println(temp);
                min = temp;
                minlocation =location.get(i);
            }


        }
        min = 99;

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

        InfoWindow infoWindow1 = new InfoWindow();
        infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "현위치";
            }

        });
        infoWindow1.open(marker1);
        Marker marker2 = new Marker();
        System.out.println(minlocation);
        if(minlocation == null)
        {

        }
        else if ( minlocation.equals("IT4호관"))
        {
            System.out.println("IT4들어와따");
            marker2.setPosition(it4);
            marker2.setMap(naverMap);

            marker2.setSubCaptionText("다음 수업");
            marker2.setSubCaptionColor(Color.RED);
            marker2.setSubCaptionHaloColor(Color.YELLOW);
            marker2.setSubCaptionTextSize(10);

            InfoWindow infoWindow2 = new InfoWindow();
            infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
                @NonNull
                @Override
                public CharSequence getText(@NonNull InfoWindow infoWindow) {
                    return "다음 수업";
                }

            });
            infoWindow2.open(marker2);


        }
        else if ( minlocation.equals("IT융복합관"))
        {
            System.out.println("융복");
            marker2.setPosition(it5);
            marker2.setMap(naverMap);

            marker2.setSubCaptionText("다음 수업");
            marker2.setSubCaptionColor(Color.RED);
            marker2.setSubCaptionHaloColor(Color.YELLOW);
            marker2.setSubCaptionTextSize(10);

            InfoWindow infoWindow2 = new InfoWindow();
            infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
                @NonNull
                @Override
                public CharSequence getText(@NonNull InfoWindow infoWindow) {
                    return "다음 수업";
                }
            });
            infoWindow2.open(marker2);
        }
    }
}
