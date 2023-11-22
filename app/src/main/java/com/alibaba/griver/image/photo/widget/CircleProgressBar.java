package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.image.R;

/* loaded from: classes6.dex */
public class CircleProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f6619a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Paint f;
    private int g;
    private int h;
    private RectF i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f6619a = -1;
        this.b = 0;
        this.c = -1;
        this.d = 100;
        this.e = -1;
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6619a = -1;
        this.b = 0;
        this.c = -1;
        this.d = 100;
        this.e = -1;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.griver_image_video_pregress_radius);
        this.h = dimensionPixelOffset;
        this.f6619a = dimensionPixelOffset - DensityUtil.dip2px(context, 3.0f);
        this.b = 0;
        this.c = -1;
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.g = DensityUtil.dip2px(context, 1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f6619a == -1 || getVisibility() != 0) {
            return;
        }
        c(canvas);
        b(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(this.g);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.h, this.f);
    }

    private void b(Canvas canvas) {
        int i;
        int i2 = this.d;
        float f = (i2 <= 0 || (i = this.e) < 0) ? 0.0f : (i / i2) * 360.0f;
        this.f.setColor(this.c);
        a();
        canvas.drawArc(this.i, 270.0f, f, true, this.f);
    }

    private void c(Canvas canvas) {
        this.f.setColor(this.b);
        this.f.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f6619a, this.f);
    }

    private void a() {
        float width = (getWidth() - (this.f6619a * 2)) / 2.0f;
        float height = (getHeight() - (this.f6619a * 2.0f)) / 2.0f;
        float width2 = getWidth() - ((getWidth() - (this.f6619a * 2)) / 2.0f);
        float height2 = getHeight() - ((getHeight() - (this.f6619a * 2.0f)) / 2.0f);
        RectF rectF = this.i;
        if (rectF == null) {
            this.i = new RectF(width, height, width2, height2);
            return;
        }
        rectF.left = width;
        this.i.top = height;
        this.i.right = width2;
        this.i.bottom = height2;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            invalidate();
        }
    }

    public void setRadius(int i) {
        this.f6619a = i;
    }

    public void setRadius(int i, int i2) {
        this.h = i;
        this.f6619a = i2;
        invalidate();
    }

    public void setProgressBackground(int i) {
        this.b = i;
    }

    public void setProgressColor(int i) {
        this.c = i;
    }

    public void setMax(int i) {
        this.d = i;
    }

    public void setProgress(int i) {
        this.e = i;
        invalidate();
    }

    public void safeSetProgress(final int i) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new Runnable() { // from class: com.alibaba.griver.image.photo.widget.CircleProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    CircleProgressBar.this.setProgress(i);
                }
            });
        } else {
            setProgress(i);
        }
    }
}
