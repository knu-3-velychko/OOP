package com.tai.lab3;

import android.content.Context;
import android.test.mock.MockContext;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChartView;
import com.tai.lab3.Views.DonutChart;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class DonutChartTest {
    private int maxValue = 100;

    private AnyChartView view;

    private ProgressBar progressBar = mock(ProgressBar.class);

    @Mock
    private Context context;

    private DonutChart donutChart;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        donutChart = new DonutChart(view, progressBar, maxValue);

    }

    @Test
    public void getMaxValue() {
        assertEquals(donutChart.getMaxValue(), maxValue);
    }

    @Test
    public void setMaxValue() {
        int newMaxValue = 500;
        donutChart.setMaxValue(newMaxValue);
        assertEquals(donutChart.getMaxValue(), newMaxValue);
    }

    @Test
    public void getValue() {
        assertEquals(donutChart.getValue(), 0);
    }

    @Test
    public void setValue() {
        int newValue = 100;
        donutChart.setValue(newValue);
        assertEquals(donutChart.getValue(), newValue);
    }
}