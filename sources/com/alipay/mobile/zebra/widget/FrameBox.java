package com.alipay.mobile.zebra.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alipay.mobile.zebra.widget.PercentLayout;

/* loaded from: classes7.dex */
public class FrameBox extends FrameLayout implements PercentBox {

    /* renamed from: a  reason: collision with root package name */
    private final PercentLayout f7317a;
    private boolean b;

    public FrameBox(Context context) {
        super(context);
        this.f7317a = new PercentLayout(this);
        this.b = false;
    }

    public FrameBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7317a = new PercentLayout(this);
        this.b = false;
    }

    public FrameBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7317a = new PercentLayout(this);
        this.b = false;
    }

    @Override // com.alipay.mobile.zebra.widget.PercentBox
    public boolean isPercentLayoutEnabled() {
        return this.b;
    }

    @Override // com.alipay.mobile.zebra.widget.PercentBox
    public void setPercentLayoutEnabled(boolean z) {
        this.b = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b) {
            this.f7317a.adjustChildren(i, i2);
        }
        super.onMeasure(i, i2);
        if (this.b && this.f7317a.handleMeasuredStateTooSmall()) {
            super.onMeasure(i, i2);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z = true;
        boolean z2 = false;
        if (layoutParams != null) {
            if (layoutParams.width > 0 && layoutParams.width > getMeasuredWidth()) {
                measuredWidth = layoutParams.width;
                z2 = true;
            }
            if (layoutParams.height <= 0 || layoutParams.height <= getMeasuredHeight()) {
                z = z2;
            } else {
                measuredHeight = layoutParams.height;
            }
        } else {
            z = false;
        }
        if (z) {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b) {
            this.f7317a.restoreOriginalParams();
        }
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams implements GravityParams, PercentLayout.PercentLayoutWrapper {

        /* renamed from: a  reason: collision with root package name */
        private PercentLayout.PercentLayoutParams f7318a;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f7318a = new PercentLayout.PercentLayoutParams();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7318a = new PercentLayout.PercentLayoutParams();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7318a = new PercentLayout.PercentLayoutParams();
        }

        @Override // com.alipay.mobile.zebra.widget.PercentLayout.PercentLayoutWrapper
        public PercentLayout.PercentLayoutParams getPercentLayoutParams() {
            return this.f7318a;
        }

        @Override // com.alipay.mobile.zebra.widget.GravityParams
        public int getGravity() {
            return this.gravity;
        }

        @Override // com.alipay.mobile.zebra.widget.GravityParams
        public void setGravity(int i) {
            this.gravity = i;
        }
    }
}
