package com.alibaba.griver.ui.ant.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class AUMaxItemListView extends AUListView {
    public static final int DEFAULT_MAX_ITEMS = 5;

    /* renamed from: a  reason: collision with root package name */
    private int f6692a;
    private float b;

    public AUMaxItemListView(Context context) {
        this(context, null);
    }

    public AUMaxItemListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AUMaxItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.griverAUInputBox);
        this.f6692a = obtainStyledAttributes.getInteger(R.styleable.griverMaxItemsHeightListView_maxItems, 5);
        this.b = obtainStyledAttributes.getDimension(R.styleable.griverMaxItemsHeightListView_singleItemHeight, getResources().getDimension(R.dimen.griver_AU_SPACE12));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min((int) (getResources().getDisplayMetrics().heightPixels * 0.8f), (int) ((this.f6692a * this.b) + ((r0 - 1) * getDividerHeight()))), Integer.MIN_VALUE));
    }
}
