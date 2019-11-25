package com.tai.lab3.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.tai.lab3.R;

public class DoughnutChart extends ViewGroup {

    private DoughnutChartView doughnutChartView;

    private Paint paintPrimary;
    private Paint paintSecondary;
    private Paint paintTextPrimary;
    private Paint paintTextSecondary;

    private final RectF oval = new RectF();
    private float width;

    private float textSizePrimary;
    private float textSizeSecondary;

    private int colorPrimary;
    private int colorSecondary;
    private int colorTextPrimary;
    private int colorTextSecondary;

    private float percentDeg;

    public float getPercent() {
        return (percentDeg / 360.f) * 100.f;
    }

    public void setPercent(float percent) {
        percentDeg = ((percent % 100) / 100.f) * 360.f;
        doughnutChartView.invalidate();
    }

    private float originAngle = 0;

    private float getOriginAngle() {
        return (originAngle + 270) % 360;
    }

    private void setOriginAngle(Float value) {
        originAngle = (value % 360);
    }


    public DoughnutChart(Context ctx) {
        super(ctx);
        init();
    }

    public DoughnutChart(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);

        TypedArray a = ctx.getTheme().obtainStyledAttributes(attrs, R.styleable.DoughnutChart, 0, 0);

        try {
            colorPrimary = a.getColor(R.styleable.DoughnutChart_colorPrimary, Color.rgb(225, 140, 80));
            colorSecondary = a.getColor(R.styleable.DoughnutChart_colorSecondary, Color.rgb(200, 200, 200));
        } finally {
            a.recycle();
        }

        init();
    }


    private void init() {

        doughnutChartView = new DoughnutChartView(getContext());
        addView(doughnutChartView);

        textSizePrimary = 10.f;
        textSizeSecondary = 10.f;

        colorTextPrimary = Color.BLACK;
        colorTextSecondary = Color.BLACK;

        paintPrimary = setPaint(colorPrimary);
        paintPrimary.setStrokeCap(Paint.Cap.ROUND);

        paintSecondary = setPaint(colorSecondary);

        paintTextPrimary = setTextPaint(colorTextPrimary);

        paintTextSecondary = setTextPaint(colorTextSecondary);
    }

    private Paint setPaint(int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    private TextPaint setTextPaint(int color) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(color);
        textPaint.setStyle(Paint.Style.STROKE);
        return textPaint;
    }

    @Override
    protected void onLayout(boolean b, int i, int i2, int i3, int i4) {
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);

        float xPad = (float) (getPaddingLeft() + getPaddingRight());
        float yPad = (float) (getPaddingTop() + getPaddingBottom());

        float ww = (float) w - xPad;
        float hh = (float) h - yPad;
        float diameter = Math.min(ww, hh);

        oval.set(0.f, 0.f, diameter, diameter);
        oval.offsetTo(getPaddingLeft(), getPaddingTop());

        width = diameter / 15.f;
        paintPrimary.setStrokeWidth(width);
        paintSecondary.setStrokeWidth(width);

        doughnutChartView.layout((int) oval.left, (int) oval.top, (int) oval.right, (int) oval.bottom);
    }


    class DoughnutChartView extends View {

        private final RectF vOval = new RectF();

        public DoughnutChartView(Context ctx) {
            super(ctx);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(vOval, 0, 360, false, paintSecondary);
            canvas.drawArc(vOval, getOriginAngle(), percentDeg, false, paintPrimary);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldW, int oldH) {
            vOval.set(width, width, w - width, h - width);
        }
    }

}