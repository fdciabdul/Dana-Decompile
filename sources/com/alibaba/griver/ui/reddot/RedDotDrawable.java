package com.alibaba.griver.ui.reddot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public class RedDotDrawable extends Drawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f6743a;
    private boolean b;
    private Paint c;
    private int d;
    private int e = 17;
    int mDx;
    int mDy;

    public RedDotDrawable(Context context, Drawable drawable, int i, int i2, int i3, int i4) {
        this.f6743a = drawable;
        Paint paint = new Paint(5);
        this.c = paint;
        paint.setColor(i4);
        this.d = i;
        this.mDx = i2;
        this.mDy = i3;
    }

    public void setColor(int i) {
        this.c.setColor(i);
    }

    public void setShowRedPoint(boolean z) {
        this.b = z;
        invalidateSelf();
    }

    public void setRadius(int i) {
        this.d = i;
    }

    public void setGravity(int i) {
        this.e = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f6743a.draw(canvas);
        if (this.b) {
            canvas.drawCircle(getBounds().right - this.mDx, getBounds().top + this.mDy, this.d, this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6743a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6743a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f6743a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6743a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6743a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f6743a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f6743a.setBounds(i, i2, i3, i4);
    }

    public static void wrap(View view, int i, int i2, int i3, int i4) {
        Drawable background = view.getBackground();
        if (background != null) {
            if (background instanceof RedDotDrawable) {
                return;
            }
            view.setBackground(new RedDotDrawable(view.getContext(), background, i, i2, i3, i4));
            return;
        }
        view.setBackground(new RedDotDrawable(view.getContext(), new GradientDrawable(), i, i2, i3, i4));
    }

    public static void showRedPoint(View view, boolean z) {
        Drawable background = view.getBackground();
        if (background instanceof RedDotDrawable) {
            ((RedDotDrawable) background).setShowRedPoint(z);
        }
    }
}
