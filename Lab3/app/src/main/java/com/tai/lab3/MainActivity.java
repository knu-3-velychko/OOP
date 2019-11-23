package com.tai.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.anychart.AnyChartView;
import com.tai.lab3.Views.DonutChart;

public class MainActivity extends AppCompatActivity {
    private DonutChart donutChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnyChartView view = findViewById(R.id.any_chart_view);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        donutChart = new DonutChart(view, progressBar, 100);
    }
}
