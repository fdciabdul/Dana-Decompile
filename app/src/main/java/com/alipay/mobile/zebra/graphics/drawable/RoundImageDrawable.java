package com.alipay.mobile.zebra.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes7.dex */
public class RoundImageDrawable extends Drawable implements FSDraw {
    public static final int COLOR_DEFAULT = -1;
    public static final int COLOR_TRANSPARENT = 0;

    /* renamed from: a  reason: collision with root package name */
    private Paint f7316a;
    private Bitmap b;
    private BitmapShader c;
    private Matrix d;
    private int e = 0;
    private int f = -1;
    private int g;
    private int h;
    private RectF i;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public RoundImageDrawable(Bitmap bitmap) {
        this.b = bitmap;
        Bitmap bitmap2 = this.b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.c = new BitmapShader(bitmap2, tileMode, tileMode);
        this.d = new Matrix();
        Paint paint = new Paint();
        this.f7316a = paint;
        paint.setAntiAlias(true);
        this.i = new RectF();
    }

    public RoundImageDrawable setBackgroundColor(int i) {
        this.e = i;
        return this;
    }

    public RoundImageDrawable setBorderRadius(int i) {
        this.h = i;
        return this;
    }

    public RoundImageDrawable setBorderWidth(int i) {
        this.g = i;
        return this;
    }

    public RoundImageDrawable setBorderColor(int i) {
        this.f = i;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float width = bounds.width();
        float height = bounds.height();
        if (width == 0.0f || height == 0.0f) {
            return;
        }
        this.d.setScale(width / this.b.getWidth(), height / this.b.getHeight());
        this.c.setLocalMatrix(this.d);
        this.i.set(bounds);
        float f = this.h;
        if (this.g > 0) {
            this.f7316a.setColor(this.f);
            if (this.e != 0) {
                canvas.drawRoundRect(this.i, f, f, this.f7316a);
            } else {
                this.f7316a.setStyle(Paint.Style.STROKE);
                this.f7316a.setStrokeWidth(this.g);
                float f2 = this.g * 0.5f;
                float f3 = this.h - f2;
                if (f3 <= 0.0f) {
                    f3 = 0.0f;
                }
                this.i.set(f2, f2, width - f2, height - f2);
                canvas.drawRoundRect(this.i, f3, f3, this.f7316a);
                this.f7316a.setStyle(Paint.Style.FILL);
            }
            int i = this.h;
            int i2 = this.g;
            float f4 = i - i2;
            float f5 = f4 > 0.0f ? f4 : 0.0f;
            float f6 = i2;
            this.i.set(f6, f6, width - f6, height - f6);
            int i3 = this.e;
            if (i3 != 0) {
                this.f7316a.setColor(i3);
                canvas.drawRoundRect(this.i, f5, f5, this.f7316a);
            }
            this.f7316a.setShader(this.c);
            canvas.drawRoundRect(this.i, f5, f5, this.f7316a);
            return;
        }
        int i4 = this.e;
        if (i4 != 0) {
            this.f7316a.setColor(i4);
            canvas.drawRoundRect(this.i, f, f, this.f7316a);
        }
        this.f7316a.setShader(this.c);
        canvas.drawRoundRect(this.i, f, f, this.f7316a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7316a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7316a.setColorFilter(colorFilter);
    }
}
