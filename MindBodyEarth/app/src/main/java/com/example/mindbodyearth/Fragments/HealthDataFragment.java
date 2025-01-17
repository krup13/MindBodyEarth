package com.example.mindbodyearth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mindbodyearth.DAO.HealthDataDao;
import com.example.mindbodyearth.Entities.HealthTrackerPackageEntities.HealthData;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HealthDataFragment extends Fragment {

    private HealthDataDao healthDataDao;
    private ExecutorService executorService;
    private EditText bloodPressureInput;
    private EditText heartRateInput;
    private EditText weightInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health_data, container, false);

        AppDatabase db = DatabaseClient.getInstance(getContext()).getAppDatabase();
        healthDataDao = db.healthDataDao();
        executorService = Executors.newSingleThreadExecutor();

        bloodPressureInput = view.findViewById(R.id.blood_pressure_input);
        heartRateInput = view.findViewById(R.id.heart_rate_input);
        weightInput = view.findViewById(R.id.weight_input);

        view.findViewById(R.id.save_button).setOnClickListener(v -> saveHealthData());

        return view;
    }

    private void saveHealthData() {
        String bloodPressure = bloodPressureInput.getText().toString();
        int heartRate = Integer.parseInt(heartRateInput.getText().toString());
        double weight = Double.parseDouble(weightInput.getText().toString());

        HealthData healthData = new HealthData(new Date(), bloodPressure, heartRate, weight);
        executorService.execute(() -> healthDataDao.insertHealthData(healthData));
    }
}