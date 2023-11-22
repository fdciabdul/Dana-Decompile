package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes9.dex */
class CircularProgressBackgroundDrawable extends BaseSingleCircularProgressDrawable implements ShowBackgroundDrawable, FSDraw {
    private boolean mShow = true;

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

    @Override // me.zhanghai.android.materialprogressbar.BaseSingleCircularProgressDrawable
    protected void onDrawRing(Canvas canvas, Paint paint) {
        drawRing(canvas, paint, 0.0f, 360.0f);
    }
}
