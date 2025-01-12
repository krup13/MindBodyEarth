//package com.example.mindbodyearth.Adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Food;
//import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Meal;
//import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.MealPlan;
//import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
//import com.example.mindbodyearth.R;
//
//import java.util.List;
//
//public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder> {
//    private List<MealPlan> mealPlans;
//
//    public MealPlanAdapter(List<MealPlan> mealPlans) {
//        this.mealPlans = mealPlans;
//    }
//
//    @NonNull
//    @Override
//    public MealPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_plan_item, parent, false);
//        return new MealPlanViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealPlanViewHolder holder, int position) {
//        MealPlan mealPlan = mealPlans.get(position);
//        holder.dayTextView.setText(mealPlan.getDay());
//        String mealsText = "";
//        for (Meal meal : mealPlan.getMeals()) {
//            mealsText += "Meal Total Calories: " + meal.getTotalCalories() + "\n";
//            for(Food food: meal.getMealComposition()){
//                mealsText += food.getFoodName() + " ";
//            }
//            mealsText += "\n";
//        }
//        holder.mealsTextView.setText(mealsText);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mealPlans.size();
//    }
//
//    public class MealPlanViewHolder extends RecyclerView.ViewHolder {
//        TextView dayTextView;
//        TextView mealsTextView;
//
//        public MealPlanViewHolder(@NonNull View itemView) {
//            super(itemView);
//            dayTextView = itemView.findViewById(R.id.dayTextView);
//            mealsTextView = itemView.findViewById(R.id.mealsTextView);
//        }
//    }
//}

//WorkoutPlanAdapter.java



