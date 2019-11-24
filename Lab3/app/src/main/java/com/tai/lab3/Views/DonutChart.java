package com.tai.lab3.Views;

import android.widget.ProgressBar;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.CircularGauge;
import com.anychart.core.axes.Circular;
import com.anychart.core.gauge.pointers.Bar;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.VAlign;

public class DonutChart {
    private AnyChartView view;
    private ProgressBar progressBar;

    private final int minValue = 0;
    private int value = 0;
    private int maxValue;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setMaxValue(int value) {
        maxValue = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public DonutChart(AnyChartView view, ProgressBar progressBar, int maxValue) {
        this.maxValue = maxValue;
        this.view = view;
        this.progressBar = progressBar;
    }

    public void setUp() {
        view.setProgressBar(progressBar);

        setCircularGauge();
    }

    private void setCircularGauge() {
        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.data(new SingleValueDataSet(new String[]{"50", "100"}));
        circularGauge.fill("#fff")
                .stroke(null)
                .padding(0d, 0d, 0d, 0d)
                .margin(100d, 100d, 100d, 100d);
        circularGauge.startAngle(0d);
        circularGauge.sweepAngle(360d);

        setCircular(circularGauge);

        addBar(circularGauge, 0d, 0d, new SolidFill("#64b5f6", 1d), null, 5d);
        addBar(circularGauge, 100d, 1d, new SolidFill("#F5F4F4", 1d), "1 #e5e4e4", 4d);

        circularGauge.label(0d)
                .text("Steps")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(0d)
                .anchor(Anchor.CENTER)
                .padding(0d, 0d, 0d, 0d)
                .height(50d + "%");

        circularGauge.margin(50d, 50d, 100d, 50d);

        view.setChart(circularGauge);
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

    private void addBar(CircularGauge circularGauge, Number index, Number dataIndex, SolidFill fill, String stroke, Number zIndex) {
        Bar bar = circularGauge.bar(index);
        bar.dataIndex(dataIndex);
        bar.radius(100d);
        bar.width(17d);
        bar.fill(fill);
        bar.stroke(stroke);
        bar.zIndex(zIndex);
    }
}
