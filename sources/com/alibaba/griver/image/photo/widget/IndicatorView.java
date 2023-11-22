package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.R;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class IndicatorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f6621a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.griver_image_dot_width);
        this.b = dimension;
        this.c = dimension;
        this.f6621a = 0;
        setOrientation(0);
        this.e = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_image_indicator_normal);
        this.d = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_image_indicator_selected);
    }

    public void setCount(int i) {
        removeAllViews();
        if (i > 50) {
            StringBuilder sb = new StringBuilder();
            sb.append("Count overflow! count = ");
            sb.append(i);
            RVLogger.w("IndicatorView", sb.toString());
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = new ImageView(getContext());
            int i3 = this.b;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            if (i2 > 0) {
                layoutParams.setMargins(this.c, 0, 0, 0);
            }
            imageView.setImageDrawable(this.e);
            addView(imageView, i2, layoutParams);
        }
    }

    public void setSelection(int i) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) getChildAt(this.f6621a);
        if (imageView != null) {
            imageView.setImageDrawable(this.e);
        }
        ((ImageView) getChildAt(i)).setImageDrawable(this.d);
        this.f6621a = i;
    }
}
