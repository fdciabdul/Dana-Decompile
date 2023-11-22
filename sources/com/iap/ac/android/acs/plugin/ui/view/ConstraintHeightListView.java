package com.iap.ac.android.acs.plugin.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes8.dex */
public class ConstraintHeightListView extends ListView {
    public int mMaxHeight;

    public ConstraintHeightListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.mMaxHeight;
        if (i3 > 0 && i3 <= size) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public ConstraintHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConstraintHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
