package com.example.mindbodyearth.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        setDownsampledImage(view.findViewById(R.id.bubble_journal), R.drawable.ic_journal);
        setDownsampledImage(view.findViewById(R.id.bubble_meditation), R.drawable.ic_meditation);
        setDownsampledImage(view.findViewById(R.id.bubble_carbon_footprint), R.drawable.ic_carbon_footprint);
        setDownsampledImage(view.findViewById(R.id.bubble_meal_plan), R.drawable.ic_meal_plan);
        setDownsampledImage(view.findViewById(R.id.bubble_workout_plan), R.drawable.ic_workout_plan);
        setDownsampledImage(view.findViewById(R.id.bottom_navigation_menu),R.drawable.ic_back);
        setDownsampledImage(view.findViewById(R.id.bottom_navigation_menu),R.drawable.ic_home);
        setDownsampledImage(view.findViewById(R.id.bottom_navigation_menu),R.drawable.ic_next);

        // Handle floating bubble navigation
        view.findViewById(R.id.bubble_journal).setOnClickListener(v -> loadFragment(new JournalFragment()));
        view.findViewById(R.id.bubble_meditation).setOnClickListener(v -> loadFragment(new MeditationFragment()));
        view.findViewById(R.id.bubble_carbon_footprint).setOnClickListener(v -> loadFragment(new CarbonFootprintFragment()));
        view.findViewById(R.id.bubble_meal_plan).setOnClickListener(v -> loadFragment(new MealPlanFragment()));
        view.findViewById(R.id.bubble_workout_plan).setOnClickListener(v -> loadFragment(new WorkoutPlanFragment()));

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

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();

        // Replace the current fragment in the container
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.fragment_enter,  // Enter animation
                        R.anim.fragment_exit,  // Exit animation
                        R.anim.fragment_pop_enter,  // Pop Enter animation
                        R.anim.fragment_pop_exit   // Pop Exit animation
                )
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // Add to back stack for navigation
                .commit();
    }

    private void resetToHome() {
        // Clear the back stack and show the home screen
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Toast.makeText(getContext(), "Reset to home", Toast.LENGTH_SHORT).show();
    }

    private void handleBackNavigation() {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack(); // Go to the previous fragment
        } else {
            Toast.makeText(getContext(), "Already on the home screen", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleNextNavigation() {
        Toast.makeText(getContext(), "No next page available", Toast.LENGTH_SHORT).show();
    }

    private void setDownsampledImage(View imageView, int drawableRes) {
        if (imageView instanceof ImageView) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true; // Check dimensions without loading the bitmap
            BitmapFactory.decodeResource(getResources(), drawableRes, options);

            // Calculate the required size (e.g., 100x100 pixels for bubbles)
            int reqWidth = 100;
            int reqHeight = 100;
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false; // Load the actual bitmap

            Bitmap downsampledBitmap = BitmapFactory.decodeResource(getResources(), drawableRes, options);
            ((ImageView) imageView).setImageBitmap(downsampledBitmap);
        }
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
