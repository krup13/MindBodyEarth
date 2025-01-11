package com.example.mindbodyearth;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

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

    private void calculateFootprint() {
        double electricityUsage = Double.parseDouble(electricityUsageEditText.getText().toString());
        double gasUsage = Double.parseDouble(gasUsageEditText.getText().toString());

        // Create an EnergyConsumption object and calculate the footprint
        EnergyConsumption energyConsumption = new EnergyConsumption(electricityUsage, gasUsage);
        double energyFootprint = energyConsumption.calcEnergyFootprint();

        // Display the result
        energyFootprintTextView.setText(String.format("Energy Footprint: %.2f kWh", energyFootprint));
    }
}
