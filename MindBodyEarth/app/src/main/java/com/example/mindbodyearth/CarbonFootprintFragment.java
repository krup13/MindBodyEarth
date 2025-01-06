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

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint;

public class CarbonFootprintFragment extends Fragment {

    private EditText energyFootprintEditText;
    private EditText transportFootprintEditText;
    private EditText mealFootprintEditText;
    private EditText wasteFootprintEditText;
    private TextView totalFootprintTextView;

    public CarbonFootprintFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carbon_footprint, container, false);

        energyFootprintEditText = view.findViewById(R.id.energyFootprintEditText);
        transportFootprintEditText = view.findViewById(R.id.transportFootprintEditText);
        mealFootprintEditText = view.findViewById(R.id.mealFootprintEditText);
        wasteFootprintEditText = view.findViewById(R.id.wasteFootprintEditText);
        totalFootprintTextView = view.findViewById(R.id.totalFootprintTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateFootprint());

        return view;
    }

    private void calculateFootprint() {
        double energyFootprint = Double.parseDouble(energyFootprintEditText.getText().toString());
        double transportFootprint = Double.parseDouble(transportFootprintEditText.getText().toString());
        double mealFootprint = Double.parseDouble(mealFootprintEditText.getText().toString());
        double wasteFootprint = Double.parseDouble(wasteFootprintEditText.getText().toString());

        // Create a CarbonFootprint object and calculate the total footprint
        CarbonFootprint carbonFootprint = new CarbonFootprint(energyFootprint, transportFootprint, mealFootprint, wasteFootprint);
        double totalFootprint = carbonFootprint.getTotalFootprint();

        // Display the result
        totalFootprintTextView.setText(String.format("Total Carbon Footprint: %.2f kg CO₂", totalFootprint));
    }
}
