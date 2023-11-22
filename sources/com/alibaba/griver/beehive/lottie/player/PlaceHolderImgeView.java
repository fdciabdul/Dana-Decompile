package com.alibaba.griver.beehive.lottie.player;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;

/* loaded from: classes6.dex */
public class PlaceHolderImgeView extends ImageView {
    public PlaceHolderImgeView(Context context) {
        super(context);
    }

    public PlaceHolderImgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlaceHolderImgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PlaceHolderImgeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void addToParentView(FrameLayout frameLayout, RectF rectF) {
        if (frameLayout == null || rectF == null) {
            return;
        }
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) rectF.width(), (int) rectF.height());
        layoutParams.leftMargin = (int) rectF.left;
        layoutParams.topMargin = (int) rectF.top;
        frameLayout.addView(this, layoutParams);
    }

    public void loadImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MultimediaServiceAdapter.loadImage(str, this);
    }
}
