package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
class CameraFrontSightView extends View implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Paint f6569a;
    private boolean b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private int g;
    private ViewGroup.LayoutParams h;
    protected int mHeight;
    protected int mWidth;

    public CameraFrontSightView(Context context) {
        super(context);
        this.f6569a = new Paint();
        this.b = false;
        this.c = false;
        this.d = 0L;
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6569a = new Paint();
        this.b = false;
        this.c = false;
        this.d = 0L;
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6569a = new Paint();
        this.b = false;
        this.c = false;
        this.d = 0L;
    }

    public final void startDraw() {
        setVisibility(0);
        this.b = true;
        this.c = false;
        this.d = System.currentTimeMillis();
        invalidate();
    }

    public final void init(int i, int i2) {
        this.mWidth = a(i);
        this.mHeight = a(i2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.h = layoutParams;
        if (layoutParams != null) {
            layoutParams.width = this.mWidth;
            this.h.height = this.mHeight;
        }
        setLayoutParams(this.h);
        this.e = this.mWidth / 2;
        this.f = this.mHeight / 2;
        this.g = a(1.0f);
        this.f6569a.setColor(-8393929);
        this.f6569a.setStrokeWidth(this.g);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.translate(this.e / 2, this.f / 2);
        long currentTimeMillis = System.currentTimeMillis() - this.d;
        if (currentTimeMillis > 200) {
            this.b = false;
        }
        if (currentTimeMillis > BeaconManager.DEFAULT_FOREGROUND_SCAN_PERIOD) {
            this.c = true;
        }
        if (currentTimeMillis > 1300) {
            setVisibility(8);
            return;
        }
        if (this.b) {
            float f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, this.e / 2, this.f / 2);
            this.f6569a.setAlpha((int) ((2.0f - f) * 255.0f));
        }
        if (this.c) {
            this.f6569a.setAlpha((int) (((1300.0f - ((float) currentTimeMillis)) / 200.0f) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, this.e, 0.0f, this.f6569a);
        canvas.drawLine(0.0f, 0.0f, 0.0f, this.f, this.f6569a);
        float f2 = this.e;
        canvas.drawLine(f2, 0.0f, f2, this.f, this.f6569a);
        float f3 = this.f;
        canvas.drawLine(0.0f, f3, this.e, f3, this.f6569a);
        float f4 = this.f / 2;
        canvas.drawLine(0.0f, f4, this.e / 10, f4, this.f6569a);
        int i = this.e;
        float f5 = this.f / 2;
        canvas.drawLine(i, f5, (i * 9) / 10, f5, this.f6569a);
        float f6 = this.e / 2;
        canvas.drawLine(f6, 0.0f, f6, this.f / 10, this.f6569a);
        float f7 = this.e / 2;
        canvas.drawLine(f7, this.f, f7, (r0 * 9) / 10, this.f6569a);
        invalidate();
    }

    private int a(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
