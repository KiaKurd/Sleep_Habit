package com.example.sleephabit.navigator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.google.android.material.navigation.NavigationBarView;


public class BottomNav extends AppCompatActivity implements  NavigationBarView.OnItemSelectedListener{

    NavigationBarView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

       bottomNavigationView = findViewById(R.id.bottomNavigationView);

       bottomNavigationView.setOnItemSelectedListener(this);
       bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    RecordFragment recordFragment = new RecordFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
    }
}