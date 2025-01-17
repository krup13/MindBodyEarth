package com.example.mindbodyearth.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mindbodyearth.CarbonFootprintViewModel;
import com.example.mindbodyearth.Entities.CarbonFootprintTrackerPackageEntities.CarbonFootprint;
import com.example.mindbodyearth.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CarbonFootprintFragment extends Fragment {

    private CarbonFootprint carbonFootprint;

    public CarbonFootprintFragment() {
        // Required empty public constructor
    }

    public static CarbonFootprintFragment newInstance(CarbonFootprint carbonFootprint) {
        CarbonFootprintFragment fragment = new CarbonFootprintFragment();
        Bundle args = new Bundle();
        args.putParcelable("carbon_footprint", carbonFootprint); // Use Parcelable
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carbon_footprint, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CarbonFootprintViewModel viewModel = new ViewModelProvider(requireActivity()).get(CarbonFootprintViewModel.class);

        // Retrieve the CarbonFootprint object from arguments
        if (getArguments() != null) {
            carbonFootprint = getArguments().getParcelable("carbon_footprint");
        }

//        // Retrieve the NavHostFragment and NavController
//        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment);
//
//
//        if (navHostFragment == null) {
//            throw new IllegalStateException("NavHostFragment is null. Ensure it is added to the layout with the correct ID.");
//        }
//
//        NavController navController = navHostFragment.getNavController();
//
        // Set up TextViews
        TextView totalFootprintTextView = view.findViewById(R.id.totalFootprintTextView);
        TextView energyFootprintTextView = view.findViewById(R.id.energyFootprintTextView);
        TextView transportFootprintTextView = view.findViewById(R.id.transportFootprintTextView);
        TextView mealFootprintTextView = view.findViewById(R.id.mealFootprintTextView);
        TextView wasteFootprintTextView = view.findViewById(R.id.wasteFootprintTextView);
        TextView currentDateTextView = view.findViewById(R.id.currentDateTextView);

        // Set the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());
        currentDateTextView.setText(String.format("Date: %s", currentDate));

        // Populate TextViews with carbon footprint values
        if (carbonFootprint != null) {
            totalFootprintTextView.setText(String.format("Total Footprint: %.2f kg CO₂", carbonFootprint.getTotalFootprint()));
            energyFootprintTextView.setText(String.format("Energy Footprint: %.2f kg CO₂", carbonFootprint.getEnergyFootprint()));
            transportFootprintTextView.setText(String.format("Transport Footprint: %.2f kg CO₂", carbonFootprint.getTransportFootprint()));
            mealFootprintTextView.setText(String.format("Meal Footprint: %.2f kg CO₂", carbonFootprint.getMealFootprint()));
            wasteFootprintTextView.setText(String.format("Waste Footprint: %.2f kg CO₂", carbonFootprint.getWasteFootprint()));
        }

        // Update values from ViewModel
        viewModel.getTotalFootprint().observe(getViewLifecycleOwner(), total ->
                totalFootprintTextView.setText(String.format("Total Footprint: %.2f kg CO₂", total)));
        viewModel.getEnergyFootprint().observe(getViewLifecycleOwner(), energy ->
                energyFootprintTextView.setText(String.format("Energy Footprint: %.2f kg CO₂", energy)));
        viewModel.getTransportFootprint().observe(getViewLifecycleOwner(), transport ->
                transportFootprintTextView.setText(String.format("Transport Footprint: %.2f kg CO₂", transport)));
        viewModel.getMealFootprint().observe(getViewLifecycleOwner(), meal ->
                mealFootprintTextView.setText(String.format("Meal Footprint: %.2f kg CO₂", meal)));
        viewModel.getWasteFootprint().observe(getViewLifecycleOwner(), waste ->
                wasteFootprintTextView.setText(String.format("Waste Footprint: %.2f kg CO₂", waste)));

        // Handle navigation
//        wasteFootprintTextView.setOnClickListener(v -> navController.navigate(R.id.action_to_wasteFragment));
//        energyFootprintTextView.setOnClickListener(v -> navController.navigate(R.id.action_to_energyConsumptionFragment));
//        transportFootprintTextView.setOnClickListener(v -> navController.navigate(R.id.action_to_transportationFragment));
//        mealFootprintTextView.setOnClickListener(v -> navController.navigate(R.id.action_to_mealPlanFragment));
    }
}
