package com.example.mindbodyearth;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

        distanceTravelledEditText = view.findViewById(R.id.distanceTravelledEditText);
        fuelEfficiencyEditText = view.findViewById(R.id.fuelEfficiencyEditText);
        footprintResultTextView = view.findViewById(R.id.footprintResultTextView);
        Spinner modeOfTransportSpinner = view.findViewById(R.id.modeOfTransportSpinner);

// Create an ArrayAdapter for the spinner
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mode_of_transport_options)) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Get the default view
                View view = super.getView(position, convertView, parent);

                // Apply bold to the first item (the placeholder)
                if (position == 0) {
                    TextView text = (TextView) view;
                    text.setTypeface(null, Typeface.BOLD); // Apply bold style
                }

                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // Get the dropdown view
                View view = super.getDropDownView(position, convertView, parent);

                // Apply bold to the first item (the placeholder)
                if (position == 0) {
                    TextView text = (TextView) view;
                    text.setTypeface(null, Typeface.BOLD); // Apply bold style
                }

                return view;
            }
        };

// Set the dropdown view layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Set the adapter to the Spinner
        modeOfTransportSpinner.setAdapter(adapter);


        Button calculateFootprintButton = view.findViewById(R.id.calculateButton);


        // Set up the button click listener
        calculateFootprintButton.setOnClickListener(v -> calculateCarbonFootprint());

        return view;
    }

    private void calculateCarbonFootprint() {
        CarbonFootprintViewModel viewModel = new ViewModelProvider(requireActivity()).get(CarbonFootprintViewModel.class);

        try {
            // Get input values from the user
            Spinner modeOfTransportSpinner = getView().findViewById(R.id.modeOfTransportSpinner);
            String modeOfTransport = modeOfTransportSpinner.getSelectedItem().toString();
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

            viewModel.setTransportFootprint(carbonFootprint); // Update ViewModel

            // Display the carbon footprint
            footprintResultTextView.setText(String.format("Transportation Footprint: %.2f kg CO₂", carbonFootprint));
        } catch (NumberFormatException e) {
            footprintResultTextView.setText("Invalid input. Please enter numeric values.");
        }
    }
}
