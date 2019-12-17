package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.example.myapplication.ModifyTable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

public class nav extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fm;
    private FragmentTransaction ft;
    Fragment fr = new ModifyTable();
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;

    Intent intent2;
    int flag ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        toolbar = findViewById(R.id.toolbar);
        intent2 = new Intent(getApplicationContext(),  map.class);
        flag = 1;

        toolbar.setTitle("시간표");
        getSupportFragmentManager().beginTransaction().add(R.id.fra, fr).commit();



        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawer.closeDrawers();
                switch (item.getItemId())
                {
                    case R.id.map:
                        startActivity(intent2);
                        //startActivity(intent2);
                        flag = 0;
                        //fr = new map();
                        //toolbar.setTitle("지도");
                        break;

                    case R.id.modifytimetable:
                        fr = new ModifyTable();
                        toolbar.setTitle("시간표 수정");
                        break;
                    case R.id.timetable:
                        fr = new TimeTable();
                        toolbar.setTitle("시간표");
                        break;
                    case R.id.logout:
                        Intent it=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(it);


                }
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fra, fr);
                ft.addToBackStack(null);
                ft.commit();

                return true;
                //return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void mapmap()
    {
        startActivity( intent2 );
        /*if( flag == 0)
        {
            startActivity( intent2 );
            flag = 1;
        }*/
        /*else if (flag == 1)
        {

        }*/
    }
}
