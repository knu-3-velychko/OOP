package com.lab3.StepDetection;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorOperationsTest {

    private float[] vector = {1f, 2f, 3f};

    @Test
    public void sum() {
        assertEquals(VectorOperations.sum(vector), 6f, 0.1e-6);
    }

    @Test
    public void norm() {
        assertEquals(VectorOperations.norm(vector), (float) Math.sqrt(14f), 0.1e-6);
    }

    @Test
    public void dot() {
        float[] newVector={2f,4f,6f};
        assertEquals(VectorOperations.dot(vector,newVector),28f,0.1e-6);
    }

    @Test
    public void normalize() {
        float[] normalizedVector = VectorOperations.normalize(vector);
        assertEquals(VectorOperations.norm(normalizedVector), 1f, 0.1e-6);
    }
}