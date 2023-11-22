package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes9.dex */
class HorizontalProgressBackgroundDrawable extends BaseSingleHorizontalProgressDrawable implements ShowBackgroundDrawable, FSDraw {
    private boolean mShow;

    public HorizontalProgressBackgroundDrawable(Context context) {
        super(context);
        this.mShow = true;
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public boolean getShowBackground() {
        return this.mShow;
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public void setShowBackground(boolean z) {
        if (this.mShow != z) {
            this.mShow = z;
            invalidateSelf();
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mShow) {
            super.draw(canvas);
        }
    }
}
