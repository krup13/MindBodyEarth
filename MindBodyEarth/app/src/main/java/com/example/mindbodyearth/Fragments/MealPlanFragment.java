package com.example.mindbodyearth.Fragments;

import com.example.mindbodyearth.Adapter.MealPlanAdapter;
//import com.example.mindbodyearth.AppDatabase;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
import com.example.mindbodyearth.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MealPlanFragment extends Fragment
{

    private ProgressBar calorieProgressBar;
    private TextView calorieTextView;
    private int calorieLimit = 2500; // Your daily calorie limit
    private int dangerZoneThreshold = (int)(calorieLimit * 0.8); // 80% of the limit
    private RecyclerView mealPlanRecyclerView;
    private MealPlanAdapter mealPlanAdapter;
    private List<MealPlan> mealPlans;
    private ImageView myImageView;
//    private AppDatabase db;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);

        calorieProgressBar = view.findViewById(R.id.calorieProgressBar);
        calorieTextView = view.findViewById(R.id.calorieTextView);

        calorieProgressBar.setMax(calorieLimit);
        updateCalorieProgress(0); // Initialize

        mealPlanRecyclerView = view.findViewById(R.id.meal_plan_recycler_view);
        mealPlanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);

        loadMealPlans();

        fab.setOnClickListener(v -> showAddMealPlanDialog());

//        return inflater.inflate(R.layout.fragment_meal_plan, container, false);
        return view;
    }

    private void updateCalorieProgress(int currentCalories) {
        calorieProgressBar.setProgress(currentCalories);
        calorieTextView.setText(currentCalories + " / " + calorieLimit + " Calories");

        if (currentCalories >= dangerZoneThreshold) {
            // Set progress bar color to red
            calorieProgressBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(getResources().getColor(android.R.color.holo_red_dark), PorterDuff.Mode.SRC_IN));
        } else {
            // Set progress bar color back to the default (you might need to store the default color)
            calorieProgressBar.getProgressDrawable().setColorFilter(null); //Resets the color
        }
    }

    private int calculateTotalCalories() {
        int totalCalories = 0;
        for (MealPlan mealPlan : mealPlans) {
            for (Meal meal : mealPlan.getMeals()) {
                for (Food food : meal.getMealComposition()) {
                    totalCalories += food.getCalories();
                }
            }
        }
        return totalCalories;
    }

    private void loadMealPlans()
    {
        executorService.execute(() -> {
            mealPlans = createMealPlans(new MealPlan("Monday"));
            requireActivity().runOnUiThread(() -> {
                mealPlanAdapter = new MealPlanAdapter(mealPlans, mealPlan -> {
                    // Handle item clicks (e.g., edit)
                    showEditMealPlanDialog(mealPlan);
                });
                mealPlanRecyclerView.setAdapter(mealPlanAdapter);
            });
        });
    }

    private void showAddMealPlanDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Add Meal Plan");

        LinearLayout mainLayout = new LinearLayout(requireContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        EditText dayEditText = new EditText(requireContext());
        dayEditText.setHint("Day (e.g., Monday)");
        mainLayout.addView(dayEditText);


        // Meal Input Section
        LinearLayout mealsLayout = new LinearLayout(requireContext());
        mealsLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(mealsLayout); // Add mealsLayout to mainLayout

        List<Meal> mealsToAdd = new ArrayList<>(); // Store meals for the new plan

        // Button to add meals
        android.widget.Button addMealButton = new android.widget.Button(requireContext());
        addMealButton.setText("Add Meal");
        addMealButton.setOnClickListener(v -> {
            showAddMealDialog(mealsLayout, mealsToAdd);
        });
        mainLayout.addView(addMealButton);


        builder.setView(mainLayout);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String day = dayEditText.getText().toString();
            for(int i = 0; i < mealsToAdd.size() ; i++)
            {
                if (!day.isEmpty()) {
                    // Check if a MealPlan with this day already exists
                    MealPlan existingMealPlan = findMealPlanByDay(day);

                    if (existingMealPlan != null) {
                        // Add meals to the existing MealPlan
                        existingMealPlan.getMeals().addAll(mealsToAdd);
                        requireActivity().runOnUiThread(() -> mealPlanAdapter.notifyDataSetChanged()); // Notify adapter of changes
                    } else {
                        // Create a new MealPlan
                        MealPlan newMealPlan = new MealPlan(day);
                        newMealPlan.addMeal(mealsToAdd.get(i));
                        mealPlans.add(newMealPlan);
                        int totalCalories = calculateTotalCalories();
                        updateCalorieProgress(totalCalories);
                        requireActivity().runOnUiThread(() -> mealPlanAdapter.notifyItemInserted(mealPlans.size() - 1));
                    }
                } else {
                    Toast.makeText(requireContext(), "Please enter a day", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private MealPlan findMealPlanByDay(String day)
    {
        for (MealPlan mealPlan : mealPlans)
        {
            if (mealPlan.getDay().equals(day))
            {
                return mealPlan;
            }
        }
        return null;
    }

    private void showAddMealDialog(LinearLayout mealsLayout, List<Meal> meals) {
        AlertDialog.Builder mealDialogBuilder = new AlertDialog.Builder(requireContext());
        mealDialogBuilder.setTitle("Add Meal");

        LinearLayout mealLayout = new LinearLayout(requireContext());
        mealLayout.setOrientation(LinearLayout.VERTICAL);

        EditText foodNameEditText = new EditText(requireContext());
        foodNameEditText.setHint("Food Name");
        mealLayout.addView(foodNameEditText);

        EditText nutrientEditText = new EditText(requireContext());
        nutrientEditText.setHint("Main Nutrient (e.g., Protein)");
        mealLayout.addView(nutrientEditText);

        EditText caloriesEditText = new EditText(requireContext());
        caloriesEditText.setHint("Calories");
        mealLayout.addView(caloriesEditText);

        mealDialogBuilder.setView(mealLayout);

        mealDialogBuilder.setPositiveButton("Add Meal", (mealDialog, whichMeal) -> {
            String foodName = foodNameEditText.getText().toString();
            String nutrient = nutrientEditText.getText().toString();
            String caloriesStr = caloriesEditText.getText().toString();

            if (!foodName.isEmpty() && !nutrient.isEmpty() && !caloriesStr.isEmpty()) {
                try {
                    int calories = Integer.parseInt(caloriesStr);
                    Meal meal = new Meal();
                    meal.addFoodToMeal(new Food(foodName, nutrient, calories));
                    meals.add(meal);

                    android.widget.TextView mealTextView = new android.widget.TextView(requireContext());
                    mealTextView.setText("Meal: " + foodName + " (" + nutrient + ", " + calories + " cal)");
                    mealsLayout.addView(mealTextView);
                } catch (NumberFormatException e) {
                    Toast.makeText(requireContext(), "Invalid calories input", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(requireContext(), "Please fill all meal fields", Toast.LENGTH_SHORT).show();
            }
        });

        mealDialogBuilder.setNegativeButton("Cancel", null);
        mealDialogBuilder.show();
    }


    private void showEditMealPlanDialog(MealPlan mealPlan)
    {
        // Implement edit dialog logic here
        Toast.makeText(requireContext(), "Editing " + mealPlan.getDay(), Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
//    {
//        super.onViewCreated(view, savedInstanceState);
////        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);
//
//        mealPlanRecyclerView = view.findViewById(R.id.meal_plan_recycler_view);
//        mealPlanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        mealPlans = new ArrayList<>();
//        // Example Data
//        Meal meal1 = new Meal();
//        meal1.addFood(new Food("Chicken Breast", "Protein", 200));
//        meal1.addFood(new Food("Rice", "Carbs", 200));
//        meal1.addFood(new Food("Fish", "Protein", 200));
//        MealPlan mealPlan1 = new MealPlan("Tuesday");
//        mealPlan1.addMeal(meal1);
//
//        Meal meal2 = new Meal();
//        meal2.addFood(new Food("Chicken Breast", "Protein", 200));
//        meal2.addFood(new Food("Rice", "Carbs", 200));
//        meal2.addFood(new Food("Fish", "Protein", 200));
//        MealPlan mealPlan2 = new MealPlan("Tuesday");
//        mealPlan2.addMeal(meal1);
//
//        mealPlans = createMealPlans();
////        mealPlans.add(mealPlan2);
//
//
//        mealPlanAdapter = new MealPlanAdapter(mealPlans);
//        mealPlanRecyclerView.setAdapter(mealPlanAdapter);
//
//
////        return view;
//
////        myImageView = view.findViewById(R.id.imageView);
////        if (myImageView == null) {
////            Log.e("MyFragment", "ImageView not found!");
////            return view; // Important: Return the view even if there's an error
////        }
////
////        // Load the image
////        loadImage();
////
////        return view;
////    }
////
////    private void loadImage() {
////        if (myImageView != null) { // Null check is crucial
////            // 1. From Resources (Drawable):
////            Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.aki_hayakawa);
////            if (drawable != null) {
////                myImageView.setImageDrawable(drawable);
////            } else {
////                Log.e("MyFragment", "Drawable not found!");
////            }
////        }
//    }

    private List<MealPlan> createMealPlans(MealPlan mealPlan)
    {
        List<MealPlan> mealPlans = new ArrayList<>();

        // Example: Monday's Meal Plan
//        MealPlan mondayPlan = new MealPlan("Monday");
//        Meal breakfast = new Meal();
//        breakfast.addFood(new Food("Chicken", "Protein", 250));
//        breakfast.addFood(new Food("Banana", "Carbs", 100));
//        mondayPlan.addMeal(breakfast);
//
//        Meal lunch = new Meal();
//        lunch.addFood(new Food("Chicken Salad Sandwich", "Protein", 400));
//        mondayPlan.addMeal(lunch);
//        mealPlans.add(mondayPlan);
//        mealPlans.add(mealPlan);
//
//        // Example: Tuesday's Meal Plan
//        MealPlan tuesdayPlan = new MealPlan("Tuesday");
//        Meal breakfastTuesday = new Meal();
//        breakfastTuesday.addFood(new Food("Eggs", "Protein", 150));
//        tuesdayPlan.addMeal(breakfastTuesday);
//        mealPlans.add(tuesdayPlan);

        // Add more MealPlans here...

        return mealPlans;
    }


}