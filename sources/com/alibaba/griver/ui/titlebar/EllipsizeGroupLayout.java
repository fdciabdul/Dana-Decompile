package com.alibaba.griver.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes6.dex */
public class EllipsizeGroupLayout extends LinearLayout {
    public EllipsizeGroupLayout(Context context) {
        this(context, null);
    }

    public EllipsizeGroupLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r18, int r19) {
        /*
            r17 = this;
            r6 = r17
            int r0 = r17.getOrientation()
            if (r0 != 0) goto L90
            r0 = 0
            int r7 = r17.getChildCount()
            int r8 = android.view.View.MeasureSpec.getSize(r18)
            int r1 = android.view.View.MeasureSpec.getSize(r18)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L1f:
            r14 = 1
            if (r11 >= r7) goto L77
            if (r12 != 0) goto L77
            android.view.View r15 = r6.getChildAt(r11)
            if (r15 == 0) goto L74
            int r1 = r15.getVisibility()
            r2 = 8
            if (r1 == r2) goto L74
            if (r0 != 0) goto L44
            boolean r1 = r15 instanceof android.view.ViewGroup
            if (r1 == 0) goto L44
            r1 = r15
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            boolean r2 = r6.containTextView(r1)
            if (r2 == 0) goto L44
            r16 = r1
            goto L46
        L44:
            r16 = r0
        L46:
            r3 = 0
            r5 = 0
            r0 = r17
            r1 = r15
            r2 = r9
            r4 = r19
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            if (r0 == 0) goto L71
            float r1 = r0.weight
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L61
            goto L62
        L61:
            r14 = 0
        L62:
            r12 = r12 | r14
            int r1 = r15.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r0 = r0.rightMargin
            int r1 = r1 + r0
            int r13 = r13 + r1
            r0 = r16
            goto L74
        L71:
            r0 = r16
            r12 = 1
        L74:
            int r11 = r11 + 1
            goto L1f
        L77:
            if (r0 == 0) goto L7d
            if (r13 != 0) goto L7c
            goto L7d
        L7c:
            r14 = 0
        L7d:
            r1 = r12 | r14
            if (r1 != 0) goto L90
            if (r13 <= r8) goto L90
            int r1 = r0.getMeasuredWidth()
            int r13 = r13 - r8
            int r1 = r1 - r13
            if (r1 >= 0) goto L8c
            goto L8d
        L8c:
            r10 = r1
        L8d:
            r6.setChildTextViewMaxWidth(r0, r10)
        L90:
            super.onMeasure(r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.EllipsizeGroupLayout.onMeasure(int, int):void");
    }

    public void setChildTextViewMaxWidth(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                setChildTextViewMaxWidth((ViewGroup) childAt, i);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setMaxWidth(i);
            }
        }
    }

    public boolean containTextView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                if (containTextView((ViewGroup) childAt)) {
                    return true;
                }
            } else if ((childAt instanceof TextView) && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
