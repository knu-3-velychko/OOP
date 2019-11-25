package com.tai.lab3.StepDetection;

public class VectorOperations {
    public static float sum(float[] array) {
        float result = 0;
        for (float i : array) {
            result += i;
        }
        return result;
    }

    public static float norm(float[] array) {
        float result = 0f;
        for (float i : array) {
            result += i * i;
        }
        return (float) Math.sqrt(result);
    }

    public static float dot(float[] a, float[] b) {
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    public static float[] normalize(float[] a) {
        float[] result = new float[a.length];
        float norm = norm(a);
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] / norm;
        }
        return result;
    }
}
