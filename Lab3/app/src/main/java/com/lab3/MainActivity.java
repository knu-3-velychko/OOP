package com.lab3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.lab3.StepDetection.StepDetector;
import com.lab3.R;
import com.lab3.Views.DoughnutChart;
import com.lab3.Views.StepsCount;

public class MainActivity extends AppCompatActivity {
    private StepsCount count;

    private StepDetector stepDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        stepDetector = new StepDetector();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoughnutChart doughnutChart = findViewById(R.id.doughnut_view);
        MaterialTextView textView = findViewById(R.id.materialTextView);
        count = new StepsCount(textView, doughnutChart);
        setUpAccelerometer();

    }

    private void setUpAccelerometer() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (stepDetector.detect(event.timestamp, event.values[0], event.values[1], event.values[2])) {
                    count.setValue(stepDetector.getStepCount());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

}
