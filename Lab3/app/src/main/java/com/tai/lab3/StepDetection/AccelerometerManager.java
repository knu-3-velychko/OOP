package com.tai.lab3.StepDetection;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.tai.lab3.Views.DonutChart;
import com.tai.lab3.Views.StepsCount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static android.net.DnsResolver.TYPE_A;

public class AccelerometerManager {

    private static final String TAG = AccelerometerManager.class.getSimpleName();

    /**
     * Suggested periods:
     * DELAY_UI: T ~= 60ms => f = 16,6Hz
     * DELAY_GAME: T ~= 20ms => f = 50Hz
     */
    private static final int CONFIG_SENSOR = SensorManager.SENSOR_DELAY_GAME;


    private StepDetector stepDetector;

    private SensorManager sensorManager;

    private Sensor sensor;

    private List<OnStepListener> onStepListeners;

    private double threshold=12.0;

    private StepsCount count;

    public AccelerometerManager(SensorManager sensorManager,
                                StepDetector stepDetector, StepsCount count) {
        this.sensorManager = sensorManager;

        this.stepDetector = stepDetector;
        this.count = count;

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (stepDetector.detect(getSensorValue(event), threshold)) {
                    System.out.println("Steps: " + stepDetector.getStepCount());
                    count.setValue(stepDetector.getStepCount());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener, sensor, CONFIG_SENSOR);
    }

    private Double getSensorValue(SensorEvent event) {
        return Math.sqrt(event.values[0] * event.values[0] +
                event.values[1] * event.values[1] +
                event.values[2] * event.values[2]);
    }

    private long getTimestamp(SensorEvent event) {
        return (new Date()).getTime() + (event.timestamp - System.nanoTime()) / 1000000L;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;

    }

    private void updateListeners(long eventTime) {
        for (OnStepListener listener : onStepListeners) {
            listener.onStepEvent(eventTime, stepDetector.getStepCount());
        }
    }

    public void addOnStepChangeListener(OnStepListener listener) {
        if (onStepListeners == null)
            onStepListeners = new ArrayList<>();
        onStepListeners.add(listener);
    }

    public interface OnStepListener {
        void onStepEvent(long milliseconds, int stepsCount);
    }
}
