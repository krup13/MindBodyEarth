package com.example.mindbodyearth.Adapter;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder> {

    private final List<MealPlan> mealPlans;

    private OnItemClickListener listener;



    public interface OnItemClickListener

    {

        void onItemClick(MealPlan mealPlan);

    }



    public MealPlanAdapter(List<MealPlan> mealPlans, OnItemClickListener listener)

    {

        this.mealPlans = mealPlans;

        this.listener = listener;

    }



    @NonNull

    @Override

    public MealPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_plan_item, parent, false);

        return new MealPlanViewHolder(view);

    }



    @Override

    public void onBindViewHolder(@NonNull MealPlanViewHolder holder, int position)

    {

        MealPlan mealPlan = mealPlans.get(position);

        holder.dayTextView.setText(mealPlan.getDay());



        StringBuilder mealListText = new StringBuilder();

        for (Meal meal : mealPlan.getMeals()) {

            mealListText.append("Total Calories: ").append(meal.getTotalCalories()).append("\n");

            for (Food food : meal.getMealComposition()) {

                mealListText.append("- ").append(food.getFoodName()).append(" (").append(food.getCalories()).append(" cal)\n");

            }

            mealListText.append("\n"); // Add spacing between meals

        }

        holder.mealsTextView.setText(mealListText.toString());



// ... (rest of onBindViewHolder as before)

        holder.itemView.setOnClickListener(v -> {

            if (listener != null && position != RecyclerView.NO_POSITION) {

                listener.onItemClick(mealPlan);

            }

        });

    }



    @Override

    public int getItemCount() {

        return mealPlans.size();

    }



    public class MealPlanViewHolder extends RecyclerView.ViewHolder {

        private final TextView dayTextView;

        private final TextView mealsTextView;



        public MealPlanViewHolder(@NonNull View itemView) {

            super(itemView);

            dayTextView = itemView.findViewById(R.id.meal_plan_day);

            mealsTextView = itemView.findViewById(R.id.meal_list);

        }

    }

}