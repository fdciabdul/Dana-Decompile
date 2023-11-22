package com.alipay.mobile.zebra.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alipay.mobile.zebra.widget.PercentLayout;

/* loaded from: classes7.dex */
public class LinearBox extends LinearLayout implements PercentBox {

    /* renamed from: a  reason: collision with root package name */
    private final PercentLayout f7319a;
    private boolean b;

    public LinearBox(Context context) {
        super(context);
        this.f7319a = new PercentLayout(this);
        this.b = false;
    }

    public LinearBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7319a = new PercentLayout(this);
        this.b = false;
    }

    public LinearBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7319a = new PercentLayout(this);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b) {
            this.f7319a.adjustChildren(i, i2);
        }
        super.onMeasure(i, i2);
        if (this.b && this.f7319a.handleMeasuredStateTooSmall()) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b) {
            this.f7319a.restoreOriginalParams();
        }
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams implements GravityParams, PercentLayout.PercentLayoutWrapper {

        /* renamed from: a  reason: collision with root package name */
        private PercentLayout.PercentLayoutParams f7320a;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f7320a = new PercentLayout.PercentLayoutParams();
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.f7320a = new PercentLayout.PercentLayoutParams();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7320a = new PercentLayout.PercentLayoutParams();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7320a = new PercentLayout.PercentLayoutParams();
        }

        @Override // com.alipay.mobile.zebra.widget.PercentLayout.PercentLayoutWrapper
        public PercentLayout.PercentLayoutParams getPercentLayoutParams() {
            return this.f7320a;
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
