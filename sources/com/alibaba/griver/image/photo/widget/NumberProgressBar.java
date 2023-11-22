package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.griver.base.common.utils.DensityUtil;

/* loaded from: classes6.dex */
public class NumberProgressBar extends View {
    private static final int f = Color.parseColor("#80108EE9");
    private static final int g = Color.parseColor("#FFFFFF");
    private static int h;

    /* renamed from: a  reason: collision with root package name */
    private Paint f6622a;
    private RectF b;
    private RectF c;
    private String d;
    private float e;

    public NumberProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "";
        this.e = -1.0f;
        Paint paint = new Paint();
        this.f6622a = paint;
        paint.setDither(true);
        h = DensityUtil.dip2px(context, 14.0f);
    }

    private void a(Canvas canvas) {
        this.f6622a.setColor(f);
        this.f6622a.setStyle(Paint.Style.FILL);
        RectF rectF = this.c;
        if (rectF != null) {
            canvas.drawRoundRect(rectF, 8.0f, 8.0f, this.f6622a);
        }
    }

    private void b(Canvas canvas) {
        this.f6622a.setStyle(Paint.Style.FILL);
        this.f6622a.setTextSize(h);
        Paint.FontMetricsInt fontMetricsInt = this.f6622a.getFontMetricsInt();
        if (this.e < 0.0f) {
            this.e = (this.b.top + ((((this.b.bottom - this.b.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top;
        }
        this.f6622a.setTextAlign(Paint.Align.CENTER);
        this.f6622a.setColor(g);
        canvas.drawText(this.d, getWidth() / 2.0f, this.e, this.f6622a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            this.b = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        a(canvas);
        b(canvas);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberProgressBar(Context context) {
        this(context, null, 0);
    }

    public NumberProgressBar setProgress(int i) {
        if (getWidth() != 0 && getHeight() != 0) {
            if (i > 100.0f) {
                i = 100;
            }
            if (this.c == null) {
                this.c = new RectF(0.0f, 0.0f, 0.0f, getHeight());
            }
            this.c.right = (i / 100.0f) * getWidth();
            invalidate();
        }
        return this;
    }

    public NumberProgressBar setText(String str) {
        this.d = str;
        invalidate();
        return this;
    }
}
