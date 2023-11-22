package com.alibaba.griver.ui.blur;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
class AUBubbleDrawable extends Drawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private int f6703a;
    private int b;
    private float e;
    private float f;
    private int c = 1;
    private int d = -65536;
    private Paint g = new Paint(1);
    private Path h = new Path();
    private Path i = new Path();
    private RectF j = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public AUBubbleDrawable() {
        this.g.setColor(this.d);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f = Math.min(this.f6703a, this.e) / 2.0f;
        int i = this.c;
        if (i == 0) {
            b(canvas);
        } else if (i == 1) {
            a(canvas);
        } else if (i == 2) {
            c(canvas);
        } else {
            a(canvas);
        }
    }

    private void a(Canvas canvas) {
        canvas.save();
        canvas.scale(-1.0f, 1.0f, this.f6703a / 2, this.b / 2);
        b(canvas);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        a();
        b();
        this.g.setStyle(Paint.Style.FILL);
        this.g.setStrokeWidth(0.0f);
        canvas.drawPath(this.h, this.g);
        this.g.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.i, this.g);
    }

    private void c(Canvas canvas) {
        a();
        c();
        this.g.setStyle(Paint.Style.FILL);
        this.g.setStrokeWidth(0.0f);
        canvas.drawPath(this.h, this.g);
        canvas.drawPath(this.i, this.g);
    }

    private void a() {
        this.h.rewind();
        this.h.moveTo(this.f, 0.0f);
        this.h.lineTo(this.f6703a - this.f, 0.0f);
        RectF rectF = this.j;
        float f = this.f6703a;
        float f2 = this.f * 2.0f;
        rectF.set(f - f2, 0.0f, f, f2);
        this.h.arcTo(this.j, -90.0f, 90.0f, false);
        this.h.lineTo(this.f6703a, this.e - this.f);
        RectF rectF2 = this.j;
        float f3 = this.f6703a;
        float f4 = this.f;
        float f5 = this.e;
        float f6 = f4 * 2.0f;
        rectF2.set(f3 - f6, f5 - f6, f3, f5);
        this.h.arcTo(this.j, 0.0f, 90.0f, false);
        this.h.lineTo(this.f, this.e);
        RectF rectF3 = this.j;
        float f7 = this.e;
        float f8 = this.f * 2.0f;
        rectF3.set(0.0f, f7 - f8, f8, f7);
        this.h.arcTo(this.j, 90.0f, 90.0f, false);
        this.h.lineTo(0.0f, this.f);
        RectF rectF4 = this.j;
        float f9 = this.f * 2.0f;
        rectF4.set(0.0f, 0.0f, f9, f9);
        this.h.arcTo(this.j, -180.0f, 90.0f, false);
    }

    private void b() {
        this.i.rewind();
        Path path = this.i;
        float f = this.f6703a;
        float f2 = this.f / 2.0f;
        path.moveTo(f - f2, this.e - f2);
        Path path2 = this.i;
        int i = this.f6703a;
        double d = i;
        float f3 = this.f;
        double d2 = f3;
        Double.isNaN(d2);
        Double.isNaN(d);
        path2.quadTo((float) (d - (d2 / 2.2d)), this.e, i - (f3 / 4.0f), this.b);
        Path path3 = this.i;
        float f4 = this.f6703a;
        float f5 = this.f;
        path3.lineTo((f4 - f5) - (f5 / 8.0f), this.e - (f5 / 20.0f));
        this.i.close();
    }

    private void c() {
        this.i.rewind();
        Path path = this.i;
        float f = this.f6703a / 2;
        float f2 = this.b;
        float f3 = this.e;
        path.moveTo(f - (f2 - f3), f3 - 2.0f);
        this.i.lineTo(this.f6703a / 2, this.b);
        Path path2 = this.i;
        float f4 = this.f6703a / 2;
        float f5 = this.b;
        float f6 = this.e;
        path2.lineTo(f4 + (f5 - f6), f6 - 2.0f);
        this.i.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidth(int i) {
        this.f6703a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHeight(int i) {
        float f;
        this.b = i;
        if (this.c == 2) {
            float f2 = i;
            f = f2 - (f2 / 6.6f);
        } else {
            f = i - (i / 14);
        }
        this.e = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPosition(int i) {
        this.c = i;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColor(int i) {
        this.d = i;
        this.g.setColor(i);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getBubbleHeight() {
        return this.e;
    }
}
