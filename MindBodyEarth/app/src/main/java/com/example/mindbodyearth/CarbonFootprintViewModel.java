package com.example.mindbodyearth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarbonFootprintViewModel extends ViewModel {

    private final MutableLiveData<Double> totalFootprint = new MutableLiveData<>(0.0);
    private final MutableLiveData<Double> wasteFootprint = new MutableLiveData<>(0.0);
    private final MutableLiveData<Double> energyFootprint = new MutableLiveData<>(0.0);
    private final MutableLiveData<Double> transportFootprint = new MutableLiveData<>(0.0);
    private final MutableLiveData<Double> mealFootprint = new MutableLiveData<>(0.0);

    // Getters for LiveData
    public LiveData<Double> getTotalFootprint() { return totalFootprint; }
    public LiveData<Double> getWasteFootprint() { return wasteFootprint; }
    public LiveData<Double> getEnergyFootprint() { return energyFootprint; }
    public LiveData<Double> getTransportFootprint() { return transportFootprint; }
    public LiveData<Double> getMealFootprint() { return mealFootprint; }

    // Setters to update values
    public void setWasteFootprint(double value) {
        wasteFootprint.setValue(value);
        updateTotalFootprint();
    }

    public void setEnergyFootprint(double value) {
        energyFootprint.setValue(value);
        updateTotalFootprint();
    }

    public void setTransportFootprint(double value) {
        transportFootprint.setValue(value);
        updateTotalFootprint();
    }

    public void setMealFootprint(double value) {
        mealFootprint.setValue(value);
        updateTotalFootprint();
    }

    private void updateTotalFootprint() {
        double total = wasteFootprint.getValue() + energyFootprint.getValue() +
                transportFootprint.getValue() + mealFootprint.getValue();
        totalFootprint.setValue(total);
    }
}
