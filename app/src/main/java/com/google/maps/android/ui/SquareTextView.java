package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public class SquareTextView extends TextView implements FSDraw {
    private int mOffsetLeft;
    private int mOffsetTop;

    public void fsSuperDraw_702785fc09ab8a22e53b32f537cb9a68(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public SquareTextView(Context context) {
        super(context);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.mOffsetTop = measuredWidth - measuredHeight;
            this.mOffsetLeft = 0;
        } else {
            this.mOffsetTop = 0;
            this.mOffsetLeft = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.translate(this.mOffsetLeft / 2, this.mOffsetTop / 2);
        fsSuperDraw_702785fc09ab8a22e53b32f537cb9a68(canvas);
    }
}
