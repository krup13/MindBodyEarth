package com.example.mindbodyearth.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mindbodyearth.MeditationGuides.MeditationFragment;
import com.example.mindbodyearth.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomepageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Handle floating bubble navigation
        view.findViewById(R.id.bubble_journal).setOnClickListener(v -> loadFragment(R.id.fragment_container_journal, new JournalFragment()));
        view.findViewById(R.id.bubble_meditation).setOnClickListener(v -> loadFragment(R.id.fragment_container_meditation_guides, new MeditationFragment()));
        view.findViewById(R.id.bubble_carbon_footprint).setOnClickListener(v -> loadFragment(R.id.fragment_container_carbon_footprint, new CarbonFootprintFragment()));
        view.findViewById(R.id.bubble_meal_plan).setOnClickListener(v -> loadFragment(R.id.fragment_container_meal_plan, new MealPlanFragment()));
        view.findViewById(R.id.bubble_workout_plan).setOnClickListener(v -> loadFragment(R.id.fragment_container_workout_plan, new WorkoutPlanFragment()));

        // Handle BottomNavigationView navigation
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation_menu);
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

    private void loadFragment(int containerId, Fragment fragment) {
        // Ensure all fragment containers are hidden initially
        getView().findViewById(R.id.fragment_container_journal).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_meal_plan).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_workout_plan).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_meditation_guides).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_carbon_footprint).setVisibility(View.GONE);

        // Show the selected fragment container
        getView().findViewById(containerId).setVisibility(View.VISIBLE);

        // Add animations for the transition
        getChildFragmentManager().beginTransaction()
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

    private void resetToHome() {
        // Show the bubbles and hide all fragment containers
        getView().findViewById(R.id.scrollView).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.fragment_container_journal).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_meal_plan).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_workout_plan).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_meditation_guides).setVisibility(View.GONE);
        getView().findViewById(R.id.fragment_container_carbon_footprint).setVisibility(View.GONE);
    }

    private void handleBackNavigation() {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack(); // Go to the previous fragment
        } else {
            resetToHome(); // If no fragments in back stack, reset to home
        }
    }

    private void handleNextNavigation() {
        FragmentManager fragmentManager = getChildFragmentManager();

        // Check if there is a fragment in the back stack
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // Pop the top entry from the back stack to "redo" navigation
            fragmentManager.popBackStack();
        } else {
            Toast.makeText(getContext(), "No next page available", Toast.LENGTH_SHORT).show();
        }
    }
}