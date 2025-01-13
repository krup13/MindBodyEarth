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

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.EnergyConsumption;
import com.example.mindbodyearth.R;

public class EnergyConsumptionFragment extends Fragment {

    private EditText electricityUsageEditText;
    private EditText gasUsageEditText;
    private TextView energyFootprintTextView;

    public EnergyConsumptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_energy_consumption, container, false);
        electricityUsageEditText = view.findViewById(R.id.electricityUsageEditText);
        gasUsageEditText = view.findViewById(R.id.gasUsageEditText);
        energyFootprintTextView = view.findViewById(R.id.energyFootprintTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateFootprint());

        return view;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void calculateFootprint() {
        try {
            // Create an EnergyConsumption object
            EnergyConsumption energyConsumption = new EnergyConsumption(0, 0);

            // Set values using setters
            energyConsumption.setElectricityUsage(Double.parseDouble(electricityUsageEditText.getText().toString()));
            energyConsumption.setGasUsage(Double.parseDouble(gasUsageEditText.getText().toString()));

            // Retrieve values using getters and calculate footprint
            double electricityUsage = energyConsumption.getElectricityUsage();
            double gasUsage = energyConsumption.getGasUsage();
            double energyFootprint = electricityUsage + (gasUsage * 29.3); // Assuming 1 therm = 29.3 kWh

            // Display the result
            energyFootprintTextView.setText(String.format("Energy Footprint: %.2f kWh", energyFootprint));
        } catch (NumberFormatException e) {
            energyFootprintTextView.setText("Invalid input. Please enter numeric values.");
        }
    }
}
