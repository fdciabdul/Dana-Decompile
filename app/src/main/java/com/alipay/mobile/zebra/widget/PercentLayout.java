package com.alipay.mobile.zebra.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: classes7.dex */
public class PercentLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f7321a;

    /* loaded from: classes7.dex */
    public interface PercentLayoutWrapper {
        PercentLayoutParams getPercentLayoutParams();
    }

    public PercentLayout(ViewGroup viewGroup) {
        this.f7321a = viewGroup;
    }

    public void adjustChildren(int i, int i2) {
        PercentLayoutParams percentLayoutParams;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = this.f7321a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewGroup.LayoutParams layoutParams = this.f7321a.getChildAt(i3).getLayoutParams();
            if ((layoutParams instanceof PercentLayoutWrapper) && (percentLayoutParams = ((PercentLayoutWrapper) layoutParams).getPercentLayoutParams()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutParams.fillMarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    percentLayoutParams.fillLayoutParams(layoutParams, size, size2);
                }
            }
        }
    }

    public void restoreOriginalParams() {
        PercentLayoutParams percentLayoutParams;
        int childCount = this.f7321a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = this.f7321a.getChildAt(i).getLayoutParams();
            if ((layoutParams instanceof PercentLayoutWrapper) && (percentLayoutParams = ((PercentLayoutWrapper) layoutParams).getPercentLayoutParams()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutParams.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                } else {
                    percentLayoutParams.restoreLayoutParams(layoutParams);
                }
            }
        }
    }

    public boolean handleMeasuredStateTooSmall() {
        PercentLayoutParams percentLayoutParams;
        int childCount = this.f7321a.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7321a.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof PercentLayoutWrapper) && (percentLayoutParams = ((PercentLayoutWrapper) layoutParams).getPercentLayoutParams()) != null) {
                if (a(childAt, percentLayoutParams)) {
                    layoutParams.width = -2;
                    z = true;
                }
                if (b(childAt, percentLayoutParams)) {
                    layoutParams.height = -2;
                    z = true;
                }
            }
        }
        return z;
    }

    private static boolean a(View view, PercentLayoutParams percentLayoutParams) {
        return (ViewCompat.newProxyInstance(view) & (-16777216)) == 16777216 && percentLayoutParams.widthPercent >= 0.0f && percentLayoutParams.mPreservedParams.width == -2;
    }

    private static boolean b(View view, PercentLayoutParams percentLayoutParams) {
        return (ViewCompat.GetContactSyncConfig(view) & (-16777216)) == 16777216 && percentLayoutParams.heightPercent >= 0.0f && percentLayoutParams.mPreservedParams.height == -2;
    }

    /* loaded from: classes7.dex */
    public static class PercentLayoutParams {
        public float widthPercent = -1.0f;
        public float heightPercent = -1.0f;
        public float leftMarginPercent = -1.0f;
        public float topMarginPercent = -1.0f;
        public float rightMarginPercent = -1.0f;
        public float bottomMarginPercent = -1.0f;
        final ViewGroup.MarginLayoutParams mPreservedParams = new ViewGroup.MarginLayoutParams(0, 0);

        public void fillLayoutParams(ViewGroup.LayoutParams layoutParams, int i, int i2) {
            this.mPreservedParams.width = layoutParams.width;
            this.mPreservedParams.height = layoutParams.height;
            float f = this.widthPercent;
            if (f >= 0.0f) {
                layoutParams.width = (int) (i * f);
            }
            float f2 = this.heightPercent;
            if (f2 >= 0.0f) {
                layoutParams.height = (int) (i2 * f2);
            }
        }

        public void fillMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            fillLayoutParams(marginLayoutParams, i, i2);
            this.mPreservedParams.leftMargin = marginLayoutParams.leftMargin;
            this.mPreservedParams.topMargin = marginLayoutParams.topMargin;
            this.mPreservedParams.rightMargin = marginLayoutParams.rightMargin;
            this.mPreservedParams.bottomMargin = marginLayoutParams.bottomMargin;
            float f = this.leftMarginPercent;
            if (f >= 0.0f) {
                marginLayoutParams.leftMargin = (int) (i * f);
            }
            float f2 = this.topMarginPercent;
            if (f2 >= 0.0f) {
                marginLayoutParams.topMargin = (int) (i2 * f2);
            }
            float f3 = this.rightMarginPercent;
            if (f3 >= 0.0f) {
                marginLayoutParams.rightMargin = (int) (i * f3);
            }
            float f4 = this.bottomMarginPercent;
            if (f4 >= 0.0f) {
                marginLayoutParams.bottomMargin = (int) (i2 * f4);
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f)", Float.valueOf(this.widthPercent), Float.valueOf(this.heightPercent), Float.valueOf(this.leftMarginPercent), Float.valueOf(this.topMarginPercent), Float.valueOf(this.rightMarginPercent), Float.valueOf(this.bottomMarginPercent));
        }

        public void restoreMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            restoreLayoutParams(marginLayoutParams);
            marginLayoutParams.leftMargin = this.mPreservedParams.leftMargin;
            marginLayoutParams.topMargin = this.mPreservedParams.topMargin;
            marginLayoutParams.rightMargin = this.mPreservedParams.rightMargin;
            marginLayoutParams.bottomMargin = this.mPreservedParams.bottomMargin;
        }

        public void restoreLayoutParams(ViewGroup.LayoutParams layoutParams) {
            layoutParams.width = this.mPreservedParams.width;
            layoutParams.height = this.mPreservedParams.height;
        }
    }
}
