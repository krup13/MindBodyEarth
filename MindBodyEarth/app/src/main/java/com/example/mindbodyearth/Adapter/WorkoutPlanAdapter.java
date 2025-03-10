package com.example.mindbodyearth.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindbodyearth.Entities.WorkoutAndMealPackageEntities.Workout;
import com.example.mindbodyearth.R;

import java.io.File;
import java.util.List;

public class WorkoutPlanAdapter extends RecyclerView.Adapter<WorkoutPlanAdapter.WorkoutViewHolder>
{

    private List<Workout> workouts;
    private OnWorkoutClickListener listener;
    private OnWorkoutLongClickListener longClickListener;
    private OnWorkoutDeleteClickListener deleteClickListener;

    public interface OnWorkoutClickListener
    {
        void onWorkoutClicked(int position);
    }

    public interface OnWorkoutLongClickListener
    {
        void onWorkoutLongClicked(int position);
    }

    public interface OnWorkoutDeleteClickListener
    {
        void onWorkoutDeleted(int position);
    }

    public WorkoutPlanAdapter(List<Workout> workouts, OnWorkoutClickListener listener, OnWorkoutLongClickListener longClickListener, OnWorkoutDeleteClickListener deleteClickListener)
    {
        this.workouts = workouts;
        this.listener = listener;
        this.longClickListener = longClickListener;
        this.deleteClickListener = deleteClickListener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position)
    {
        Workout workout = workouts.get(position);
        holder.bind(workout, listener);
    }

    @Override
    public int getItemCount()
    {
        return workouts.size();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder
    {

        private TextView workoutNameTextView;
        private TextView workoutTypeTextView;
        private TextView setsTextView;
        private TextView repsTextView;
        private CheckBox completionCheckBox;
        private ImageView workoutImageView;

        public WorkoutViewHolder(@NonNull View itemView)
        {
            super(itemView);

            workoutNameTextView = itemView.findViewById(R.id.workout_name);
            workoutTypeTextView = itemView.findViewById(R.id.workout_type);
            setsTextView = itemView.findViewById(R.id.workout_sets);
            repsTextView = itemView.findViewById(R.id.workout_reps);
//            completionCheckBox = itemView.findViewById(R.id.workout_completed);
//            workoutImageView = itemView.findViewById(R.id.workout_image);
        }

        public void bind(Workout workout, OnWorkoutClickListener listener)
        {
            workoutNameTextView.setText(workout.getWorkoutName());
            workoutTypeTextView.setText(workout.getType());
            setsTextView.setText(String.valueOf(workout.getSets()));
            repsTextView.setText(String.valueOf(workout.getReps()));
//            completionCheckBox.setChecked(workout.isCompletionStatus());

//            itemView.setOnClickListener(v -> listener.onWorkoutClicked(getAdapterPosition()));
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onWorkoutClicked(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(v -> {
                if(longClickListener != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        longClickListener.onWorkoutLongClicked(position);
                        return true;
                    }
                }
                return false;
            });

            itemView.findViewById(R.id.delete_button).setOnClickListener(v -> {
                if (deleteClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        deleteClickListener.onWorkoutDeleted(position);
                    }
                }
            });

//            completionCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                // Update workout completion status in the ViewModel or Presenter
//                // and notify the adapter of the change
//                workout.setCompletionStatus(isChecked);
//                notifyDataSetChanged(); // Update the entire RecyclerView
//            });

//            if (workout.getImageResourceId() != 0) {
//                workoutImageView.setImageResource(workout.getImageResourceId());
//            }
        }
    }
}