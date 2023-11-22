package com.alibaba.griver.ui.ant.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class AUMaxItemCornerListView extends AUCornerListView {

    /* renamed from: a  reason: collision with root package name */
    private float f6691a;
    private float b;

    public AUMaxItemCornerListView(Context context) {
        this(context, null);
    }

    public AUMaxItemCornerListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AUMaxItemCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.griverAUInputBox);
        this.f6691a = obtainStyledAttributes.getInt(R.styleable.griverMaxItemsHeightListView_maxItems, 5);
        this.b = obtainStyledAttributes.getDimension(R.styleable.griverMaxItemsHeightListView_singleItemHeight, getResources().getDimension(R.dimen.griver_AU_SPACE12));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        float f = this.f6691a;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min((int) (getResources().getDisplayMetrics().heightPixels * 0.8f), (int) ((this.b * f) + ((f - 1.0f) * getDividerHeight()))), Integer.MIN_VALUE));
    }

    public void setMaxItems(float f) {
        this.f6691a = f;
    }

    public void setSingleItemHeight(float f) {
        this.b = f;
    }
}
