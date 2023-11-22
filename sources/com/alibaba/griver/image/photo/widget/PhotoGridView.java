package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/* loaded from: classes6.dex */
public class PhotoGridView extends GridView {
    public static final String TAG = "PhotoGridView";

    /* renamed from: a  reason: collision with root package name */
    private OnOverScrolledListener f6631a;

    /* loaded from: classes6.dex */
    public interface OnOverScrolledListener {
        void onOverScrolled(int i, int i2);
    }

    public PhotoGridView(Context context) {
        this(context, null);
    }

    public PhotoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnOverScrolledListener(OnOverScrolledListener onOverScrolledListener) {
        this.f6631a = onOverScrolledListener;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        OnOverScrolledListener onOverScrolledListener = this.f6631a;
        if (onOverScrolledListener != null) {
            onOverScrolledListener.onOverScrolled(i, i2);
        }
    }
}
