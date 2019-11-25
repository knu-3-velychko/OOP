package com.tai.lab3.Views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.tai.lab3.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.chrono.ThaiBuddhistEra;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

public class DoughnutChartTest {
    Context context = mock(Context.class);

    private DoughnutChart doughnutChart = new DoughnutChart(context);
    private DoughnutChart doughnutChartAttr;


    @Before
    public void setUp() {
        Resources.Theme theme = mock(Resources.Theme.class);
        when(theme.obtainStyledAttributes(any(), any(int[].class), anyInt(), anyInt())).thenReturn(mock(TypedArray.class));

        when(context.getTheme()).thenReturn(theme);

        doughnutChartAttr = new DoughnutChart(context, mock(AttributeSet.class));
    }

    @Test
    public void getPercent() {
        assertEquals(doughnutChart.getPercent(), 0.0f, 0.1e12);
        assertEquals(doughnutChartAttr.getPercent(), 0.0f, 0.1e12);
    }

    @Test
    public void setPercent() {
        float newPercent = 50f;

        doughnutChart.setPercent(newPercent);
        doughnutChartAttr.setPercent(newPercent);

        assertEquals(doughnutChart.getPercent(), newPercent, 0.1e12);
        assertEquals(doughnutChartAttr.getPercent(), newPercent, 0.1e12);
    }

    @Test
    public void onLayout() {
        testOnLayout(doughnutChart);
        testOnLayout(doughnutChartAttr);
    }

    private void testOnLayout(DoughnutChart chart) {
        int left = chart.getLeft();
        int right = chart.getRight();
        int top = chart.getTop();
        int bottom = chart.getBottom();

        chart.onLayout(true, 1, 2, 3, 4);

        int newLeft = chart.getLeft();
        int newRight = chart.getRight();
        int newTop = chart.getTop();
        int newBottom = chart.getBottom();

        assertEquals(left, newLeft);
        assertEquals(right, newRight);
        assertEquals(top, newTop);
        assertEquals(bottom, newBottom);

    }

    @Test
    public void onSizeChanged() {
        int width = doughnutChart.getWidth();
        int height = doughnutChart.getHeight();

        doughnutChart.onSizeChanged(width / 2, height / 2, width, height);
        doughnutChartAttr.onSizeChanged(width / 2, height / 2, width, height);

        assertEquals(doughnutChart.getWidth(), width / 2);
        assertEquals(doughnutChart.getHeight(), height / 2);
        assertEquals(doughnutChartAttr.getWidth(), width / 2);
        assertEquals(doughnutChartAttr.getHeight(), height / 2);
    }
}