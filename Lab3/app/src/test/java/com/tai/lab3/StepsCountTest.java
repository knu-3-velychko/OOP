package com.tai.lab3;

import com.google.android.material.textview.MaterialTextView;
import com.tai.lab3.Views.StepsCount;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class StepsCountTest {
    private MaterialTextView view = mock(MaterialTextView.class);
    private StepsCount stepsCount = new StepsCount(view);

    @Test
    public void getValue() {
        assertEquals(stepsCount.getValue(),0);
    }

    @Test
    public void getMaxValue() {
        assertEquals(stepsCount.getMaxValue(),0);
    }

    @Test
    public void setValue() {
        stepsCount.setValue(100);
        assertEquals(stepsCount.getValue(),100);
    }

    @Test
    public void setMaxValue() {
        stepsCount.setMaxValue(500);
        assertEquals(stepsCount.getMaxValue(),500);
    }
}