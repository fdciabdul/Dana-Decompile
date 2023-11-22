package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.FSDraw;
import com.google.maps.android.R;

/* loaded from: classes7.dex */
class BubbleDrawable extends Drawable implements FSDraw {
    private int mColor = -1;
    private final Drawable mMask;
    private final Drawable mShadow;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public BubbleDrawable(Context context) {
        this.mMask = ContextCompat.PlaceComponentResult(context, R.drawable.amu_bubble_mask);
        this.mShadow = ContextCompat.PlaceComponentResult(context, R.drawable.amu_bubble_shadow);
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mMask.draw(canvas);
        canvas.drawColor(this.mColor, PorterDuff.Mode.SRC_IN);
        this.mShadow.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.mMask.setBounds(i, i2, i3, i4);
        this.mShadow.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.mMask.setBounds(rect);
        this.mShadow.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.mMask.getPadding(rect);
    }
}
