package com.tai.lab3.StepDetection;

import com.tai.lab3.Constants;

public class StepDetector {

    private final int accelerationsSize = 50;
    private final int velocitiesSize = 10;

    private double threshold = Constants.DEFAULT_THRESHOLD;
    private int delay = Constants.DEFAULT_DELAY;
    private int stepCount = 0;

    private boolean isActive;

    private int accelerationsCounter = 0;
    private float[] accelerationsX = new float[accelerationsSize];
    private float[] accelerationsY = new float[accelerationsSize];
    private float[] accelerationsZ = new float[accelerationsSize];


    private int velocitiesCounter = 0;
    private float[] velocities = new float[velocitiesSize];

    private float lastStepTime = 0;
    private float oldVelocityEstimate = 0;

    private float norm = 1f;

    public StepDetector() {
        isActive = true;
        for (int i = 0; i < velocitiesSize; i++) {
            velocities[i] = 0f;
        }
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int newDelay) {
        if (newDelay >= 0)
            delay = newDelay;
    }


    public boolean detect(long time, float x, float y, float z) {
        float[] newAcceleration = new float[3];
        newAcceleration[0] = x;
        newAcceleration[1] = y;
        newAcceleration[2] = z;

        saveAcceleration(x, y, z);

        float[] world = getGlobalVector();

        float newVelocity = VectorOperations.dot(world, newAcceleration) - norm;

        saveVelocity(newVelocity);

        float velocityEstimate = VectorOperations.sum(velocities);

        if (!isActive && (velocityEstimate < threshold)) {
            isActive = true;
        }
        if (isActive && (velocityEstimate > threshold) && (time - lastStepTime) > delay) {
            isActive = false;
            stepCount++;
            return true;
        }

        return false;
    }

    private float[] getGlobalVector() {
        float[] world = new float[3];
        float min = Math.min(accelerationsCounter, accelerationsSize);
        world[0] = VectorOperations.sum(accelerationsX) / min;
        world[1] = VectorOperations.sum(accelerationsY) / min;
        world[2] = VectorOperations.sum(accelerationsZ) / min;
        norm = VectorOperations.norm(world);
        return VectorOperations.normalize(world);
    }

    private void saveAcceleration(float x, float y, float z) {
        accelerationsCounter++;
        int position = accelerationsCounter % accelerationsSize;
        accelerationsX[position] = x;
        accelerationsY[position] = y;
        accelerationsZ[position] = z;
    }

    private void saveVelocity(float newVelocity) {
        velocitiesCounter++;
        int position = velocitiesCounter % velocitiesSize;
        if (!Float.isNaN(newVelocity)) {
            velocities[position] = newVelocity;
        }
        else{
            velocities[position]=0f;
        }
    }

    public int getStepCount() {
        return stepCount;
    }
}
