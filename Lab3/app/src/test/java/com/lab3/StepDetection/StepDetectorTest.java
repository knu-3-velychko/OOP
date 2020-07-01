package com.lab3.StepDetection;

import com.lab3.Constants;

import org.junit.Test;

import static org.junit.Assert.*;

public class StepDetectorTest {

    private StepDetector stepDetector = new StepDetector();

    @Test
    public void getDelay() {
        assertEquals(stepDetector.getDelay(), Constants.DEFAULT_DELAY);
    }

    @Test
    public void setDelay() {
        int newDelay = 500000000;
        stepDetector.setDelay(newDelay);
        assertEquals(stepDetector.getDelay(), newDelay);
    }

    @Test
    public void getThreshold() {
        assertEquals(stepDetector.getThreshold(), Constants.DEFAULT_THRESHOLD, 0.1e-10);
    }

    @Test
    public void setThreshold() {
        double newThreshold = 100f;
        stepDetector.setThreshold(newThreshold);
        assertEquals(stepDetector.getThreshold(), newThreshold, 0.1e-10);
    }

    @Test
    public void detect() {
        assertFalse(stepDetector.detect(0, 0f, 0f, 0f));
        assertFalse(stepDetector.detect(Constants.DEFAULT_DELAY,0f,0f,0f));
        assertTrue(stepDetector.detect(Constants.DEFAULT_DELAY*2,100f,100f,100f));
    }

    @Test
    public void getStepCount() {
        assertEquals(stepDetector.getStepCount(), 0);
        stepDetector.detect(0, 0f, 0f, 0f);
        assertEquals(stepDetector.getStepCount(), 0);
        stepDetector.detect(0, 100f, 100f, 100f);
        //assertEquals(1,stepDetector.getStepCount());
    }
}