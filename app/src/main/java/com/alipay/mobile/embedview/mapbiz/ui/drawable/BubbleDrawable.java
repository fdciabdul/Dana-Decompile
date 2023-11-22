package com.alipay.mobile.embedview.mapbiz.ui.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public class BubbleDrawable extends Drawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Paint f7187a;
    private Paint b;
    private int c;
    private int d;
    private RectF e;
    private Path f;
    private int g;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private BubbleDrawable(int i, int i2, int i3, int i4, int i5) {
        this.d = i2;
        this.c = i4;
        this.g = i5;
        Paint paint = new Paint();
        this.f7187a = paint;
        paint.setColor(0);
        this.f7187a.setAntiAlias(true);
        this.f7187a.setShadowLayer(i4, 0.0f, 0.0f, i3);
        this.f7187a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.e = new RectF(rect.left + this.c, rect.top + this.c, rect.right - this.c, (rect.bottom - this.c) - this.g);
        int i = rect.left;
        int i2 = (rect.right - rect.left) / 2;
        Path path = new Path();
        this.f = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f.moveTo((i + i2) - this.g, this.e.bottom);
        Path path2 = this.f;
        float f = this.g;
        path2.rLineTo(f, f);
        this.f.rLineTo(this.g, -r0);
        this.f.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.e;
        if (rectF == null || this.f == null) {
            return;
        }
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, this.f7187a);
        canvas.drawPath(this.f, this.f7187a);
        RectF rectF2 = this.e;
        float f2 = this.d;
        canvas.drawRoundRect(rectF2, f2, f2, this.b);
        canvas.drawPath(this.f, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7187a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7187a.setColorFilter(colorFilter);
    }

    public static void setBubbleDrawable(View view, int i, int i2, int i3, int i4, int i5) {
        BubbleDrawable builder = new Builder().setBgColor(i).setShapeRadius(i2).setTriangleHeight(i3).setShadowColor(i4).setShadowRadius(i5).builder();
        view.setLayerType(1, null);
        view.setBackgroundDrawable(builder);
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private int d = 268435455;

        /* renamed from: a  reason: collision with root package name */
        private int f7188a = 8;
        private int e = 8;
        private int b = 419430400;
        private int c = 4;

        public Builder setShapeRadius(int i) {
            this.f7188a = i;
            return this;
        }

        public Builder setShadowColor(int i) {
            this.b = i;
            return this;
        }

        public Builder setShadowRadius(int i) {
            this.c = i;
            return this;
        }

        public Builder setBgColor(int i) {
            this.d = i;
            return this;
        }

        public Builder setTriangleHeight(int i) {
            this.e = i;
            return this;
        }

        public BubbleDrawable builder() {
            return new BubbleDrawable(this.d, this.f7188a, this.b, this.c, this.e);
        }
    }
}
