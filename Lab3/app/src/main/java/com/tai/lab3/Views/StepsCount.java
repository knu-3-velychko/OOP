package com.tai.lab3.Views;

import com.google.android.material.textview.MaterialTextView;

public class StepsCount {
    private MaterialTextView view;
    private int value;
    private int maxValue;

    public StepsCount(MaterialTextView view) {
        this.view = view;
    }

    public void setValue(int value) {
        this.value = value;
        setText();
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        setText();
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    private void setText() {
        String text = value + "/" + maxValue + "  steps";
        view.setText(text);
    }
}
