package com.example.mindbodyearth;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class TransportationFragment extends Fragment {

    private EditText modeOfTransportEditText;
    private EditText distanceTravelledEditText;
    private EditText fuelEfficiencyEditText;

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
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateFootprint());

        return view;
    }

    private void calculateFootprint() {
        String modeOfTransport = modeOfTransportEditText.getText().toString();
        double distanceTravelled = Double.parseDouble(distanceTravelledEditText.getText().toString());
        double fuelEfficiency = Double.parseDouble(fuelEfficiencyEditText.getText().toString());

        // Create a Transportation object and calculate the footprint
        Transportation transportation = new Transportation(modeOfTransport, distanceTravelled, fuelEfficiency);
        double footprint = transportation.calcTransportFootprint();

        // Display the result

    }
}

