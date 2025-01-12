package com.example.mindbodyearth.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mindbodyearth.CarbonFootprintFragment;
import com.example.mindbodyearth.Fragments.JournalFragment;
import com.example.mindbodyearth.Fragments.MealPlanFragment;
import com.example.mindbodyearth.Fragments.WorkoutPlanFragment;
import com.example.mindbodyearth.MeditationGuides.MeditationFragment;
import com.example.mindbodyearth.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle floating bubble navigation
        findViewById(R.id.bubble_journal).setOnClickListener(v -> loadFragment(R.id.fragment_container_journal, new JournalFragment()));
        findViewById(R.id.bubble_meditation).setOnClickListener(v ->loadFragment(R.id.fragment_container_meditation_guides, new MeditationFragment()));
        findViewById(R.id.bubble_carbon_footprint).setOnClickListener(v ->loadFragment(R.id.fragment_container_carbon_footprint,new CarbonFootprintFragment()));
        findViewById(R.id.bubble_meal_plan).setOnClickListener(v ->loadFragment(R.id.fragment_container_meal_plan,new MealPlanFragment()));
        findViewById(R.id.bubble_workout_plan).setOnClickListener(v ->loadFragment(R.id.fragment_container_workout_plan,new WorkoutPlanFragment()));

        // Handle BottomNavigationView navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_back:
                    handleBackNavigation();
                    return true;
                case R.id.navigation_home:
                    resetToHome();
                    return true;
                case R.id.navigation_next:
                    handleNextNavigation();
                    return true;
                default:
                    return false;
            }
        });

        // Default to home screen (floating bubbles)
        resetToHome();
    }

    /**
     * Load a fragment into the specified container while keeping the bubbles visible.
     */
    private void loadFragment(int containerId, Fragment fragment) {
        // Ensure all fragment containers are hidden initially
        findViewById(R.id.fragment_container_journal).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_meal_plan).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_workout_plan).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_meditation_guides).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_carbon_footprint).setVisibility(View.GONE);

        // Show the selected fragment container
        findViewById(containerId).setVisibility(View.VISIBLE);

        // Add animations for the transition
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fragment_enter,  // Enter animation
                        R.anim.fragment_exit,  // Exit animation
                        R.anim.fragment_pop_enter,  // Pop Enter animation
                        R.anim.fragment_pop_exit   // Pop Exit animation
                )
                .replace(containerId, fragment)
                .addToBackStack(null) // Add to back stack for navigation
                .commit();
    }

    /**
     * Reset the layout to show the floating bubbles.
     */
    private void resetToHome() {
        // Show the bubbles and hide all fragment containers
        findViewById(R.id.scrollView).setVisibility(View.VISIBLE);
        findViewById(R.id.fragment_container_journal).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_meal_plan).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_workout_plan).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_meditation_guides).setVisibility(View.GONE);
        findViewById(R.id.fragment_container_carbon_footprint).setVisibility(View.GONE);
    }

    /**
     * Handle back navigation to go to the previous fragment if available.
     */
    private void handleBackNavigation() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack(); // Go to the previous fragment
        } else {
            resetToHome(); // If no fragments in back stack, reset to home
        }
    }

    /**
     * Handle next navigation to go to the next fragment if applicable.
     */
    private void handleNextNavigation() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Check if there is a fragment in the back stack
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // Pop the top entry from the back stack to "redo" navigation
            fragmentManager.popBackStack();
        } else {
            Toast.makeText(this, "No next page available", Toast.LENGTH_SHORT).show();
        }
    }
}
