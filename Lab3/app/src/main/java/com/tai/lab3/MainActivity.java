package com.tai.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.anychart.AnyChartView;
import com.google.android.material.textview.MaterialTextView;
import com.tai.lab3.StepDetection.AccelerometerManager;
import com.tai.lab3.StepDetection.StepDetector;
import com.tai.lab3.Views.DonutChart;
import com.tai.lab3.Views.StepsCount;

public class MainActivity extends AppCompatActivity {
    private DonutChart donutChart;
    private StepsCount count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnyChartView view = findViewById(R.id.any_chart_view);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        donutChart = new DonutChart(view, progressBar, 100);
        donutChart.setUp();

        MaterialTextView textView = findViewById(R.id.materialTextView);
        count = new StepsCount(textView);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        AccelerometerManager accelerometerManager = new AccelerometerManager(sensorManager, new StepDetector(), count);
    }
}
