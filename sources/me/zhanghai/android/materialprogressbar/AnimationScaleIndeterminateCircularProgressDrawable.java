package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.internal.AnimationScaleListDrawableCompat;

/* loaded from: classes9.dex */
public class AnimationScaleIndeterminateCircularProgressDrawable extends AnimationScaleListDrawableCompat implements MaterialProgressDrawable, IntrinsicPaddingDrawable, TintableDrawable {
    public AnimationScaleIndeterminateCircularProgressDrawable(Context context) {
        super(new Drawable[]{new StaticIndeterminateCircularProgressDrawable(context), new IndeterminateCircularProgressDrawable(context)});
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public boolean getUseIntrinsicPadding() {
        return getIntrinsicPaddingDrawable().getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public void setUseIntrinsicPadding(boolean z) {
        getIntrinsicPaddingDrawable().setUseIntrinsicPadding(z);
    }

    private IntrinsicPaddingDrawable getIntrinsicPaddingDrawable() {
        return (IntrinsicPaddingDrawable) getCurrent();
    }
}
