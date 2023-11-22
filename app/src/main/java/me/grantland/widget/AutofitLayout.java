package me.grantland.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.WeakHashMap;

/* loaded from: classes9.dex */
public class AutofitLayout extends FrameLayout {
    private boolean mEnabled;
    private WeakHashMap<View, AutofitHelper> mHelpers;
    private float mMinTextSize;
    private float mPrecision;

    public AutofitLayout(Context context) {
        super(context);
        this.mHelpers = new WeakHashMap<>();
        init(context, null, 0);
    }

    public AutofitLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHelpers = new WeakHashMap<>();
        init(context, attributeSet, 0);
    }

    public AutofitLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHelpers = new WeakHashMap<>();
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        float f = -1.0f;
        int i2 = -1;
        boolean z = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(R.styleable.AutofitTextView_sizeToFit, true);
            i2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutofitTextView_minTextSize, -1);
            f = obtainStyledAttributes.getFloat(R.styleable.AutofitTextView_precision, -1.0f);
            obtainStyledAttributes.recycle();
        }
        this.mEnabled = z;
        this.mMinTextSize = i2;
        this.mPrecision = f;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        TextView textView = (TextView) view;
        AutofitHelper enabled = AutofitHelper.create(textView).setEnabled(this.mEnabled);
        float f = this.mPrecision;
        if (f > 0.0f) {
            enabled.setPrecision(f);
        }
        float f2 = this.mMinTextSize;
        if (f2 > 0.0f) {
            enabled.setMinTextSize(0, f2);
        }
        this.mHelpers.put(textView, enabled);
    }

    public AutofitHelper getAutofitHelper(TextView textView) {
        return this.mHelpers.get(textView);
    }

    public AutofitHelper getAutofitHelper(int i) {
        return this.mHelpers.get(getChildAt(i));
    }
}
