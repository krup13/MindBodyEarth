package com.example.mindbodyearth.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.navigation_dashboard:
                        selectedFragment = new DashboardFragment();
                        break;
                    case R.id.navigation_notifications:
                        selectedFragment = new NotificationsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }
}