package com.alipay.mobile.embedview.mapbiz.ui.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public class CircleImageDrawable extends Drawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Paint f7189a;
    private Bitmap b;
    private BitmapShader c;
    private int d = -1;
    private int e;
    private int f;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CircleImageDrawable(Bitmap bitmap) {
        this.b = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.c = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.f7189a = paint;
        paint.setAntiAlias(true);
        this.f = Math.min(this.b.getWidth(), this.b.getHeight()) / 2;
    }

    public CircleImageDrawable setStrokeWidth(int i) {
        this.e = i;
        return this;
    }

    public CircleImageDrawable setStrokeColor(int i) {
        this.d = i;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = this.e;
        if (i > 0 && this.f - i > 1) {
            this.f7189a.setColor(this.d);
            canvas.drawCircle(this.b.getWidth() / 2, this.b.getHeight() / 2, this.f, this.f7189a);
            this.f7189a.setColor(-1);
            this.f7189a.setShader(this.c);
            canvas.drawCircle(this.b.getWidth() / 2, this.b.getHeight() / 2, this.f - this.e, this.f7189a);
            return;
        }
        this.f7189a.setShader(this.c);
        canvas.drawCircle(this.b.getWidth() / 2, this.b.getHeight() / 2, this.f, this.f7189a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7189a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7189a.setColorFilter(colorFilter);
    }
}
