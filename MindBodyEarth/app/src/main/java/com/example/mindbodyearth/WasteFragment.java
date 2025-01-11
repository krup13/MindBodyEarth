package com.example.mindbodyearth;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class WasteFragment extends Fragment {

    private EditText wasteGeneratedEditText;
    private EditText recyclingRateEditText;
    private TextView footprintResultTextView;

    public WasteFragment() {
        // Required empty public constructor
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

    private void calculateFootprint() {
        double wasteGenerated = Double.parseDouble(wasteGeneratedEditText.getText().toString());
        double recyclingRate = Double.parseDouble(recyclingRateEditText.getText().toString());

        // Create a Waste object and calculate the footprint
        Waste waste = new Waste(wasteGenerated, recyclingRate);
        double footprint = waste.calcWasteFootprint();

        // Display the result
        footprintResultTextView.setText(String.format("Waste Footprint: %.2f kg", footprint));
    }
}
