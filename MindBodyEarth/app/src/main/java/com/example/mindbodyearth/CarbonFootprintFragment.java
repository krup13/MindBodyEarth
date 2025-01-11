package com.example.mindbodyearth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint;
import com.example.mindbodyearth.R;

import java.io.Serializable;

public class CarbonFootprintFragment extends Fragment {

    private CarbonFootprint carbonFootprint;

    public CarbonFootprintFragment() {
        // Required empty public constructor
    }

    public static CarbonFootprintFragment newInstance(CarbonFootprint carbonFootprint) {
        CarbonFootprintFragment fragment = new CarbonFootprintFragment();
        Bundle args = new Bundle();
        args.putSerializable("carbon_footprint", (Serializable) carbonFootprint);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_carbon_footprint, container, false);

        // Retrieve the CarbonFootprint object passed in arguments
        if (getArguments() != null) {
            carbonFootprint = (CarbonFootprint) getArguments().getSerializable("carbon_footprint");
        }

        // Set up TextViews to display the footprint values
        TextView totalFootprintTextView = rootView.findViewById(R.id.totalFootprintTextView);
        TextView energyFootprintTextView = rootView.findViewById(R.id.energyFootprintTextView);
        TextView transportFootprintTextView = rootView.findViewById(R.id.transportFootprintTextView);
        TextView mealFootprintTextView = rootView.findViewById(R.id.mealFootprintTextView);
        TextView wasteFootprintTextView = rootView.findViewById(R.id.wasteFootprintTextView);

        // Display the carbon footprint values in TextViews
        if (carbonFootprint != null) {
            totalFootprintTextView.setText(String.format("Total Footprint: %.2f kg CO₂", carbonFootprint.getTotalFootprint()));
            energyFootprintTextView.setText(String.format("Energy Footprint: %.2f kg CO₂", carbonFootprint.getEnergyFootprint()));
            transportFootprintTextView.setText(String.format("Transport Footprint: %.2f kg CO₂", carbonFootprint.getTransportFootprint()));
            mealFootprintTextView.setText(String.format("Meal Footprint: %.2f kg CO₂", carbonFootprint.getMealFootprint()));
            wasteFootprintTextView.setText(String.format("Waste Footprint: %.2f kg CO₂", carbonFootprint.getWasteFootprint()));
        }

        return rootView;
    }
}
