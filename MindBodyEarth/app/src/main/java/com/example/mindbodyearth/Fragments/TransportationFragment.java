package com.example.mindbodyearth.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.Transportation;
import com.example.mindbodyearth.R;

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

        modeOfTransportEditText = view.findViewById(R.id.modeOfTransportEditText);
        distanceTravelledEditText = view.findViewById(R.id.distanceTravelledEditText);
        fuelEfficiencyEditText = view.findViewById(R.id.fuelEfficiencyEditText);
        footprintResultTextView = view.findViewById(R.id.footprintResultTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateFootprint());

        return view;
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void calculateFootprint() {
        try {
            // Create a Transportation object
            Transportation transportation = new Transportation("", 0, 0);

            // Set values using setters
            transportation.setModeOfTransport(modeOfTransportEditText.getText().toString());
            transportation.setDistanceTravelled(Double.parseDouble(distanceTravelledEditText.getText().toString()));
            transportation.setFuelEfficiency(Double.parseDouble(fuelEfficiencyEditText.getText().toString()));

            // Retrieve values using getters and calculate footprint
            String mode = transportation.getModeOfTransport();
            double distance = transportation.getDistanceTravelled();
            double efficiency = transportation.getFuelEfficiency();
            double footprint = distance / efficiency;

            // Display the result
            footprintResultTextView.setText(String.format("Transport Footprint: %.2f kg CO₂", footprint));
        } catch (NumberFormatException e) {
            footprintResultTextView.setText("Invalid input. Please enter numeric values.");
        }
    }
}
