package com.lab3.Views;

import com.google.android.material.textview.MaterialTextView;
import com.lab3.Constants;

public class StepsCount {
    private MaterialTextView textView;
    private DoughnutChart chart;
    private int value;
    private int maxValue;

    public StepsCount(MaterialTextView view, DoughnutChart chart) {
        this.value = 0;
        this.maxValue = Constants.MAX_STEPS;

        this.textView = view;
        this.chart = chart;
    }

    public void setValue(int value) {
        this.value = value;
        setText();
        setPercent();
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        setText();
        setPercent();
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    private void setText() {
        String text = value + "/" + maxValue + "  steps";
        textView.setText(text);
    }

    private void setPercent() {
        float percent = (float) value / maxValue * 100f;
        chart.setPercent(percent);
    }
}
