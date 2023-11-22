package com.alipay.zoloz.zface.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public class RoundFrameLayout extends FrameLayout implements FSDispatchDraw {
    private Path mPath;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_26abb961936cc5951a90966e1bd0f43c(canvas);
    }

    public void fsSuperDispatchDraw_26abb961936cc5951a90966e1bd0f43c(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_26abb961936cc5951a90966e1bd0f43c(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public RoundFrameLayout(Context context) {
        super(context);
        init();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF();
        rectF.left = getPaddingLeft();
        rectF.top = getPaddingTop();
        rectF.right = i - getPaddingRight();
        rectF.bottom = i2 - getPaddingBottom();
        float f = (rectF.right - rectF.left) / 2.0f;
        this.mPath.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.clipPath(this.mPath);
        return fsSuperDrawChild_26abb961936cc5951a90966e1bd0f43c(canvas, view, j);
    }
}
