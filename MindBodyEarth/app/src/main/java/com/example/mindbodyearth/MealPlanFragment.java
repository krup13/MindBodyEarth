package com.example.mindbodyearth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MealPlanFragment extends Fragment {

    private RecyclerView mealPlanRecyclerView;
    private MealPlanAdapter mealPlanAdapter;
    private List<MealPlan> mealPlans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);

        mealPlanRecyclerView = view.findViewById(R.id.mealPlanRecyclerView);
        mealPlanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mealPlans = new ArrayList<>();
        // Example Data
        Meal meal1 = new Meal();
        meal1.addFood(new Food("Chicken Breast", "Protein", 200));
        meal1.addFood(new Food("Rice", "Carbs", 200));
        MealPlan mealPlan1 = new MealPlan("Monday");
        mealPlan1.addMeal(meal1);
        mealPlans.add(mealPlan1);

        mealPlanAdapter = new MealPlanAdapter(mealPlans);
        mealPlanRecyclerView.setAdapter(mealPlanAdapter);

        return view;
    }
}