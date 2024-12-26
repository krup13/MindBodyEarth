package com.example.mindbodyearth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder> {
    private List<MealPlan> mealPlans;

    public MealPlanAdapter(List<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    @NonNull
    @Override
    public MealPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_plan_item, parent, false);
        return new MealPlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealPlanViewHolder holder, int position) {
        MealPlan mealPlan = mealPlans.get(position);
        holder.dayTextView.setText(mealPlan.getDay());
        String mealsText = "";
        for (Meal meal : mealPlan.getMeals()) {
            mealsText += "Meal Total Calories: " + meal.getTotalCalories() + "\n";
            for(Food food: meal.getMealComposition()){
                mealsText += food.getFoodName() + " ";
            }
            mealsText += "\n";
        }
        holder.mealsTextView.setText(mealsText);
    }

    @Override
    public int getItemCount() {
        return mealPlans.size();
    }

    public class MealPlanViewHolder extends RecyclerView.ViewHolder {
        TextView dayTextView;
        TextView mealsTextView;

        public MealPlanViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            mealsTextView = itemView.findViewById(R.id.mealsTextView);
        }
    }
}

//WorkoutPlanAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutPlanAdapter extends RecyclerView.Adapter<WorkoutPlanAdapter.WorkoutPlanViewHolder> {
    private List<WorkoutPlan> workoutPlans;

    public WorkoutPlanAdapter(List<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    @NonNull
    @Override
    public WorkoutPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_plan_item, parent, false);
        return new WorkoutPlanViewHolder(view);
    }

    @Override
