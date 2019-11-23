package com.tai.lab3;

import com.tai.lab3.Views.DonutChart;

import android.widget.ProgressBar;

import com.anychart.AnyChartView;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class DonutChartTest {
    private int maxValue = 100;
    private AnyChartView view = mock(AnyChartView.class);
    private ProgressBar progressBar = mock(ProgressBar.class);

    private DonutChart donutChart = new DonutChart(view, progressBar, maxValue);

    @Test
    public void setMaxValue() {
        assertEquals(donutChart.getMaxValue(), maxValue);
    }

    @Test
    public void getMaxValue() {
        int newMaxValue = 500;
        donutChart.setMaxValue(newMaxValue);
    }

    //TODO: tests for mocks
}