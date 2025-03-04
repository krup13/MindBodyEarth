package com.example.mindbodyearth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mindbodyearth.DAO.HealthDataDao;
import com.example.mindbodyearth.Entities.HealthTrackerPackageEntities.HealthData;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HealthDataChartFragment extends Fragment {

    private HealthDataDao healthDataDao;
    private ExecutorService executorService;
    private LineChart lineChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health_data_chart, container, false);

        AppDatabase db = DatabaseClient.getInstance(getContext()).getAppDatabase();
        healthDataDao = db.healthDataDao();
        executorService = Executors.newSingleThreadExecutor();

        lineChart = view.findViewById(R.id.line_chart);
        setupChart();

        loadHealthData();

        return view;
    }

    private void setupChart() {
        lineChart.getDescription().setEnabled(false);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
    }

    private void loadHealthData() {
        executorService.execute(() -> {
            List<HealthData> healthDataList = healthDataDao.getAllHealthData();
            List<Entry> entries = new ArrayList<>();
            for (int i = 0; i < healthDataList.size(); i++) {
                HealthData data = healthDataList.get(i);
                entries.add(new Entry(i, (float) data.getWeight())); // Example: Visualize weight
            }
            LineDataSet dataSet = new LineDataSet(entries, "Weight");
            LineData lineData = new LineData(dataSet);
            getActivity().runOnUiThread(() -> lineChart.setData(lineData));
        });
    }
}