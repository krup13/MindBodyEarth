package com.example.mindbodyearth.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mindbodyearth.Adapter.WorkoutPlanAdapter;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.WorkoutPlan;
import com.example.mindbodyearth.R;

public class WorkoutPlanFragment extends Fragment
{

    private WorkoutPlan workoutPlan;
    private RecyclerView recyclerView;
    private WorkoutPlanAdapter adapter;
    private EditText workoutNameEditText;
    private EditText workoutTypeEditText;
    private EditText setsEditText;
    private EditText repsEditText;
    private Button addWorkoutButton;
    private Button editWorkoutButton;
    private Button cancelEditButton;

    private int selectedWorkoutPosition = -1;

    private void setSelectedWorkoutPosition(int position)
    {
        this.selectedWorkoutPosition = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_workout_plan, container, false);

        recyclerView = view.findViewById(R.id.workout_recycler_view);
        workoutNameEditText = view.findViewById(R.id.workout_name_edit_text);
        workoutTypeEditText = view.findViewById(R.id.workout_type_edit_text);
        setsEditText = view.findViewById(R.id.workout_sets_edit_text);
        repsEditText = view.findViewById(R.id.workout_reps_edit_text);
        addWorkoutButton = view.findViewById(R.id.add_workout_button);
        editWorkoutButton = view.findViewById(R.id.edit_workout_button);
        cancelEditButton = view.findViewById(R.id.cancel_edit_workout_button);

        editWorkoutButton.setVisibility(View.GONE);
        cancelEditButton.setVisibility(View.GONE);

        // Create a sample workout plan (replace with your data source)
        workoutPlan = new WorkoutPlan();
        workoutPlan.addWorkout(new Workout("Push-ups", "Strength", 3, 10));
        workoutPlan.addWorkout(new Workout("Squats", "Strength", 3, 12));
        workoutPlan.addWorkout(new Workout("Running", "Cardio", 1, 30));
//
//        adapter = new WorkoutPlanAdapter(workoutPlan.getWorkoutRoutine(), new WorkoutPlanAdapter.OnWorkoutClickListener()
//        {
//            @Override
//            public void onWorkoutClicked(int position)
//            {
//                // Handle workout click event (e.g., show details, start workout)
//            }
//        });
//        recyclerView.setAdapter(adapter);

        adapter = new WorkoutPlanAdapter(workoutPlan.getWorkoutRoutine(),
                new WorkoutPlanAdapter.OnWorkoutClickListener() {
                    @Override
                    public void onWorkoutClicked(int position)
                    {
                        Workout selectedWorkout = workoutPlan.getWorkoutRoutine().get(position);

                        // Populate the input fields with the selected workout data
                        workoutNameEditText.setText(selectedWorkout.getWorkoutName());
                        workoutTypeEditText.setText(selectedWorkout.getType());
                        setsEditText.setText(String.valueOf(selectedWorkout.getSets()));
                        repsEditText.setText(String.valueOf(selectedWorkout.getReps()));

                        // Set the edit mode
                        addWorkoutButton.setVisibility(View.GONE);
                        editWorkoutButton.setVisibility(View.VISIBLE);
                        cancelEditButton.setVisibility(View.VISIBLE);

                        // Store the position of the selected workout
                        selectedWorkoutPosition = position;
                    }
                },
                new WorkoutPlanAdapter.OnWorkoutLongClickListener() {
                    @Override
                    public void onWorkoutLongClicked(int position) {
                        setSelectedWorkoutPosition(position);

                        // Populate the input fields with the selected workout data
                        Workout selectedWorkout = workoutPlan.getWorkoutRoutine().get(position);
                        workoutNameEditText.setText(selectedWorkout.getWorkoutName());
                        workoutTypeEditText.setText(selectedWorkout.getType());
                        setsEditText.setText(String.valueOf(selectedWorkout.getSets()));
                        repsEditText.setText(String.valueOf(selectedWorkout.getReps()));
                    }
                },
                new WorkoutPlanAdapter.OnWorkoutDeleteClickListener(){
                    @Override
                    public void onWorkoutDeleted(int position) {
                        // Remove the workout from the list
                        workoutPlan.getWorkoutRoutine().remove(position);

                        // Notify the adapter about the data change
                        adapter.notifyItemRemoved(position);
                    }
                });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        addWorkoutButton.setOnClickListener(v -> {
            String name = workoutNameEditText.getText().toString();
            String type = workoutTypeEditText.getText().toString();
            int sets = Integer.parseInt(setsEditText.getText().toString());
            int reps = Integer.parseInt(repsEditText.getText().toString());

            if (name.isEmpty() || type.isEmpty() || setsEditText.getText().toString().isEmpty() || repsEditText.getText().toString().isEmpty()) {
                // Show an error message to the user
                Toast.makeText(getContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create a new Workout object
            Workout newWorkout = new Workout(name, type, sets, reps);

            // Add the new Workout to the workoutPlan
            workoutPlan.addWorkout(newWorkout);

            // Update the RecyclerView
            adapter.notifyItemInserted(workoutPlan.getWorkoutRoutine().size() - 1);

            // Clear the input fields
            workoutNameEditText.setText("");
            workoutTypeEditText.setText("");
            setsEditText.setText("");
            repsEditText.setText("");
        });

        editWorkoutButton.setOnClickListener(v -> {
            // Get the selected workout position (e.g., from a long click listener on the RecyclerView item)
            int position = getSelectedWorkoutPosition();

            if (selectedWorkoutPosition != -1) {
                Workout workoutToEdit = workoutPlan.getWorkoutRoutine().get(selectedWorkoutPosition);

                if (workoutNameEditText.getText().toString().isEmpty() ||
                        workoutTypeEditText.getText().toString().isEmpty() ||
                        setsEditText.getText().toString().isEmpty() ||
                        repsEditText.getText().toString().isEmpty()) {
                    // Show an error message to the user
                    Toast.makeText(getContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                workoutToEdit.setWorkoutName(workoutNameEditText.getText().toString());
                workoutToEdit.setType(workoutTypeEditText.getText().toString());
                workoutToEdit.setSets(Integer.parseInt(setsEditText.getText().toString()));
                workoutToEdit.setReps(Integer.parseInt(repsEditText.getText().toString()));

                adapter.notifyItemChanged(selectedWorkoutPosition);

                // Clear the input fields and reset selected position
                workoutNameEditText.setText("");
                workoutTypeEditText.setText("");
                setsEditText.setText("");
                repsEditText.setText("");
                selectedWorkoutPosition = -1;
            }
        });

        cancelEditButton.setOnClickListener(v -> {
            clearInputFields();
            resetEditMode();
        });

        return view;
    }

    private void clearInputFields() {
        workoutNameEditText.setText("");
        workoutTypeEditText.setText("");
        setsEditText.setText("");
        repsEditText.setText("");
    }

    private void resetEditMode()
    {
        addWorkoutButton.setVisibility(View.VISIBLE);
        editWorkoutButton.setVisibility(View.GONE);
        cancelEditButton.setVisibility(View.GONE);
        selectedWorkoutPosition = -1;
    }

    private int getSelectedWorkoutPosition() {
        // Implement logic to get the selected workout position from the RecyclerView
        // (e.g., using a long click listener)
        // ...
        return selectedWorkoutPosition; // Placeholder: Implement actual logic here
    }

    // Example of adding a new workout to the plan
//    public void addNewWorkout(Workout newWorkout)
//    {
//        workoutPlan.addWorkout(newWorkout);
//        adapter.notifyItemInserted(workoutPlan.getWorkoutRoutine().size() - 1); // Update the RecyclerView
//        // Save the updated workout plan to database or shared preferences
//    }

    // Example of tracking progress for a workout
//    public void trackWorkoutProgress(int position, boolean isCompleted)
//    {
//        if (workoutPlan.trackProgress(isCompleted, position))
//            {
//            adapter.notifyItemChanged(position); // Update the RecyclerView
//            // Save the updated workout plan to database or shared preferences
//        }
//    }
}