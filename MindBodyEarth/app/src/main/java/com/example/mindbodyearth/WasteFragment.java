package com.example.mindbodyearth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Waste;

public class WasteFragment extends Fragment {

    private EditText wasteGeneratedEditText;
    private EditText recyclingRateEditText;
    private TextView footprintResultTextView;

    public WasteFragment() {
        // Required empty public constructor
    }

    private boolean validateInput() {
        if (wasteGeneratedEditText.getText().toString().isEmpty()) {
            wasteGeneratedEditText.setError("Please enter waste generated");
            return false;
        }
        if (recyclingRateEditText.getText().toString().isEmpty()) {
            recyclingRateEditText.setError("Please enter recycling rate");
            return false;
        }
        double recyclingRate = Double.parseDouble(recyclingRateEditText.getText().toString());
        if (recyclingRate < 0 || recyclingRate > 100) {
            recyclingRateEditText.setError("Recycling rate must be between 0 and 100");
            return false;
        }
        return true;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_waste, container, false);

        wasteGeneratedEditText = view.findViewById(R.id.wasteGeneratedEditText);
        recyclingRateEditText = view.findViewById(R.id.recyclingRateEditText);
        footprintResultTextView = view.findViewById(R.id.footprintResultTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateFootprint());

        return view;
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void calculateFootprint() {
        try {
            if (!validateInput()) return;

            double wasteGenerated = Double.parseDouble(wasteGeneratedEditText.getText().toString());
            double recyclingRate = Double.parseDouble(recyclingRateEditText.getText().toString());

            // Create a Waste object and set values using setters
            Waste waste = new Waste(0, 0); // Temporary initialization, values will be set using setters
            waste.setWasteGenerated(wasteGenerated);
            waste.setRecyclingRate(recyclingRate);

            // Calculate footprint using getter methods
            double footprint = waste.getWasteGenerated() * (1 - (waste.getRecyclingRate() / 100));

            // Display the result
            footprintResultTextView.setText(String.format("Waste Footprint: %.2f kg", footprint));
        } catch (NumberFormatException e) {
            footprintResultTextView.setText("Invalid input. Please enter numeric values.");
        }
    }
}

