package com.example.mindbodyearth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Transportation;
import java.sql.Date;

public class TransportationFragment extends Fragment {

    private EditText modeOfTransportEditText;
    private EditText distanceTravelledEditText;
    private EditText fuelEfficiencyEditText;
    private TextView footprintResultTextView;

    public TransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transportation, container, false);

        // Bind the UI elements
        modeOfTransportEditText = view.findViewById(R.id.modeOfTransportEditText);
        distanceTravelledEditText = view.findViewById(R.id.distanceTravelledEditText);
        fuelEfficiencyEditText = view.findViewById(R.id.fuelEfficiencyEditText);
        footprintResultTextView = view.findViewById(R.id.footprintResultTextView);
        Button calculateFootprintButton = view.findViewById(R.id.calculateButton);

        // Set up the button click listener
        calculateFootprintButton.setOnClickListener(v -> calculateCarbonFootprint());

        return view;
    }

    private void calculateCarbonFootprint() {
        try {
            // Get input values from the user
            String modeOfTransport = modeOfTransportEditText.getText().toString().trim();
            String distanceStr = distanceTravelledEditText.getText().toString().trim();
            String fuelEfficiencyStr = fuelEfficiencyEditText.getText().toString().trim();

            // Check for missing fields
            if (TextUtils.isEmpty(modeOfTransport) || TextUtils.isEmpty(distanceStr) || TextUtils.isEmpty(fuelEfficiencyStr)) {
                footprintResultTextView.setText("Please fill in all fields.");
                return;
            }

            // Parse the input values
            double distanceTravelled = Double.parseDouble(distanceStr);
            double fuelEfficiency = Double.parseDouble(fuelEfficiencyStr);

            // Create a Transportation object
            Transportation transportation = new Transportation(modeOfTransport, distanceTravelled, fuelEfficiency);

            // Set the date for the transportation record

            // Calculate carbon footprint
            double carbonFootprint = transportation.calcTransportFootprint();

            // Display the carbon footprint
            footprintResultTextView.setText(String.format("Carbon Footprint: %.2f kg CO₂", carbonFootprint));
        } catch (NumberFormatException e) {
            footprintResultTextView.setText("Invalid input. Please enter numeric values.");
        }
    }
}
