package com.example.mindbodyearth.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
import com.example.mindbodyearth.R;
//import com.example.mindbodyearth.Adapter.WorkoutPlanAdapter;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanFragment extends Fragment {

    private RecyclerView workoutPlanRecyclerView;
//    private WorkoutPlanAdapter workoutPlanAdapter;
    private List<WorkoutPlan> workoutPlans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_plan, container, false);

//        workoutPlanRecyclerView = view.findViewById(R.id.workoutPlanRecyclerView);
        workoutPlanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        workoutPlans = new ArrayList<>();
        Workout workout1 = new Workout("Bench Press", 3, 8);
        WorkoutPlan workoutPlan1 = new WorkoutPlan();
        workoutPlan1.addWorkout(workout1);
        workoutPlans.add(workoutPlan1);

//        workoutPlanAdapter = new WorkoutPlanAdapter(workoutPlans);
//        workoutPlanRecyclerView.setAdapter(workoutPlanAdapter);

        return view;
    }
}