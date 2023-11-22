package com.alipay.mobile.zebra.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes7.dex */
public class TextBox extends TextView {
    public static final int DEFAULT_STOKE_COLOR = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f7322a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;

    public TextBox(Context context) {
        super(context);
        this.f7322a = 0;
        this.b = -1;
    }

    public TextBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7322a = 0;
        this.b = -1;
    }

    public TextBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7322a = 0;
        this.b = -1;
    }

    public void setStrokeWidth(int i) {
        this.f7322a = i;
    }

    public void setStrokeColor(int i) {
        this.b = i;
    }

    private void a() {
        if (this.f7322a > 0) {
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f7322a);
            super.setTextColor(this.b);
            super.setShadowLayer(this.d, this.e, this.f, this.g);
        }
    }

    private void b() {
        TextPaint paint = getPaint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        super.setTextColor(this.c);
        super.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.c = i;
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        super.setShadowLayer(f, f2, f3, i);
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7322a > 0) {
            a();
            super.onDraw(canvas);
            b();
        }
        super.onDraw(canvas);
    }
}
