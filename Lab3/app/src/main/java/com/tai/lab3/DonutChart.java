package com.tai.lab3;

import android.widget.ProgressBar;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.charts.CircularGauge;
import com.anychart.core.axes.Circular;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.VAlign;

public class DonutChart {
    private final int minValue = 0;
    private int maxValue;

    AnyChartView chartView;

    void setMaxValue(int value) {
        maxValue = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    DonutChart(AnyChartView view, ProgressBar progressBar, int maxValue) {
        this.chartView = view;
        this.maxValue = maxValue;

        chartView.setProgressBar(progressBar);

        setCircularGauge();
    }

    private void setCircularGauge() {
        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff").
                stroke(null).
                padding(0d, 0d, 0d, 0d).
                margin(100d, 100d, 100d, 100d).fill();
        circularGauge.startAngle(0d);
        circularGauge.sweepAngle(270d);

        setCircular(circularGauge);

        circularGauge.label(0d)
                .text("Steps, <span style=\"\">32%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(0d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(100d + "%")
                .offsetX(0d);
    }

    private void setCircular(CircularGauge circularGauge) {
        Circular xAxis = circularGauge.axis(0)
                .radius(100d)
                .width(1d)
                .fill((Fill) null);
        xAxis.scale()
                .minimum(0d)
                .maximum(100d);
        xAxis.ticks("{ interval: 1 }")
                .minorTicks("{ interval: 1 }");
        xAxis.labels().enabled(false);
        xAxis.ticks().enabled(false);
        xAxis.minorTicks().enabled(false);
    }
}
