package com.example.sleephabit.navigator;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.example.sleephabit.navigator.homeFragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNav extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

//      Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    RecordFragment recordFragment = new RecordFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;

                case R.id.navigation_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                    return true;

                case R.id.navigation_record:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, recordFragment).commit();
                    return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("on bottonNav", e.toString());
            throw e;
        }
    }
}