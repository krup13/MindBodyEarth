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
//import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
//import com.example.mindbodyearth.R;
//
//import java.util.List;
//
//public class WorkoutPlanAdapter extends RecyclerView.Adapter<WorkoutPlanAdapter.WorkoutPlanViewHolder> {
//    private List<WorkoutPlan> workoutPlans;
//
//    public WorkoutPlanAdapter(List<WorkoutPlan> workoutPlans) {
//        this.workoutPlans = workoutPlans;
//    }
//
//    @NonNull
//    @Override
//    public WorkoutPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_plan_item, parent, false);
//        return new WorkoutPlanViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull WorkoutPlanAdapter.WorkoutPlanViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
