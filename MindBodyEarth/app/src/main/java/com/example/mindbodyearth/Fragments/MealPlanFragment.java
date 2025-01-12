package com.example.mindbodyearth.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindbodyearth.Adapter.ealPlanAdapter;
import com.example.mindbodyearth.AppDatabase;
import com.example.mindbodyearth.Dao.WorkoutAndMealPackageDaos.MealPlanDao;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.R;

import java.util.List;

public class MealPlanFragment extends Fragment {

    private RecyclerView recyclerView;
    private MealPlanAdapter adapter;
    private MealPlanDao mealPlanDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.mealPlanRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Initialize database and DAO
        AppDatabase database = AppDatabase.getDatabase(requireContext());
        mealPlanDao = database.mealPlanDao();

        // Fetch meal plans and bind to RecyclerView
        fetchAndBindMealPlans();

        return view;
    }

    private void fetchAndBindMealPlans() {
        // Fetch data from the database
        List<MealPlan> mealPlans = mealPlanDao.getAllMealPlans();

        // Check if meal plans exist
        if (mealPlans != null && !mealPlans.isEmpty()) {
            adapter = new MealPlanAdapter(mealPlans);
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(requireContext(), "No meal plans available", Toast.LENGTH_SHORT).show();
        }
    }
}
