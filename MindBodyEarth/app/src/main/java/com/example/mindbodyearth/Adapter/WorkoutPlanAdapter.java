package com.example.mindbodyearth.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
import com.example.mindbodyearth.R;

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
    public void onBindViewHolder(@NonNull WorkoutPlanViewHolder holder, int position) {
        WorkoutPlan workoutPlan = workoutPlans.get(position);
        holder.titleTextView.setText(workoutPlan.getWorkoutPlanName());
        holder.descriptionTextView.setText(workoutPlan.getWorkoutPlanDescription());
        holder.durationTextView.setText("Duration: " + workoutPlan.getWorkoutPlanDuration() + " mins");
    }

    @Override
    public int getItemCount() {
        return workoutPlans.size();
    }

    public static class WorkoutPlanViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView durationTextView;

        public WorkoutPlanViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);
        }
    }
}
