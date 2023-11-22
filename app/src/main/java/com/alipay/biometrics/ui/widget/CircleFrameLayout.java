package com.alipay.biometrics.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.alipay.android.phone.mobilecommon.biometric.bio.R;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class CircleFrameLayout extends FrameLayout implements FSDispatchDraw {
    private final String BRAND;
    private float circleX;
    private float circleY;
    boolean isEnable;
    WidgetListener widgetListener;

    /* loaded from: classes6.dex */
    public interface WidgetListener {
        void notifyError(int i);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_d289365f2b3db8022806ec7c5cef2af3(canvas, view, j);
    }

    public void fsSuperDispatchDraw_d289365f2b3db8022806ec7c5cef2af3(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_d289365f2b3db8022806ec7c5cef2af3(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public CircleFrameLayout(Context context) {
        super(context);
        this.BRAND = "Meizu";
        this.circleX = -1.0f;
        this.circleY = -1.0f;
    }

    public CircleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BRAND = "Meizu";
        this.circleX = -1.0f;
        this.circleY = -1.0f;
    }

    public CircleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BRAND = "Meizu";
        this.circleX = -1.0f;
        this.circleY = -1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.bio_circle_frrameLayout);
        this.isEnable = obtainStyledAttributes.getBoolean(R.styleable.bio_circle_frrameLayout_bio_facesdk_enabled, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.isEnable) {
            if (this.circleX < 0.0f) {
                this.circleX = (canvas.getWidth() * 1.0f) / 2.0f;
                this.circleY = (canvas.getHeight() * 1.0f) / 2.0f;
            }
            Path path = new Path();
            float f = this.circleX;
            path.addCircle(f, this.circleY, f, Path.Direction.CCW);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            try {
                canvas.clipPath(path, Region.Op.REPLACE);
            } catch (UnsupportedOperationException unused) {
            }
        }
        fsSuperDispatchDraw_d289365f2b3db8022806ec7c5cef2af3(canvas);
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
        postInvalidate();
    }

    public void setWidgetListener(WidgetListener widgetListener) {
        this.widgetListener = widgetListener;
    }
}
