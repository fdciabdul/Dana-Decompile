package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: classes9.dex */
public class StaticIndeterminateCircularProgressDrawable extends BaseProgressDrawable implements FSDraw {
    private static final int PADDED_INTRINSIC_SIZE_DP = 48;
    private static final Path PATH_PROGRESS;
    private static final int PROGRESS_INTRINSIC_SIZE_DP = 42;
    private static final RectF RECT_PADDED_BOUND;
    private static final RectF RECT_PROGRESS_BOUND;
    private final int mPaddedIntrinsicSize;
    private final int mProgressIntrinsicSize;
    private final Path mPath = new Path();
    private final Matrix mMatrix = new Matrix();

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable.ConstantState getConstantState() {
        return super.getConstantState();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressDrawable, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ boolean getUseIntrinsicPadding() {
        return super.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isStateful() {
        return super.isStateful();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTint(int i) {
        super.setTint(i);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressDrawable, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ void setUseIntrinsicPadding(boolean z) {
        super.setUseIntrinsicPadding(z);
    }

    static {
        Path path = new Path();
        PATH_PROGRESS = path;
        path.moveTo(17.65f, 6.35f);
        path.cubicTo(16.2f, 4.9f, 14.21f, 4.0f, 12.0f, 4.0f);
        path.cubicTo(7.58f, 4.0f, 4.01f, 7.58f, 4.01f, 12.0f);
        path.rCubicTo(0.0f, 4.42f, 3.57f, 8.0f, 7.99f, 8.0f);
        path.rCubicTo(3.73f, 0.0f, 6.84f, -2.55f, 7.73f, -6.0f);
        path.rLineTo(-2.08f, 0.0f);
        path.cubicTo(16.83f, 16.33f, 14.61f, 18.0f, 12.0f, 18.0f);
        path.cubicTo(8.69f, 18.0f, 6.0f, 15.31f, 6.0f, 12.0f);
        path.cubicTo(6.0f, 8.69f, 8.69f, 6.0f, 12.0f, 6.0f);
        path.rCubicTo(1.66f, 0.0f, 3.1f, 0.69f, 4.22f, 1.78f);
        path.lineTo(13.0f, 11.0f);
        path.rLineTo(7.0f, 0.0f);
        path.lineTo(20.0f, 4.0f);
        path.close();
        RECT_PROGRESS_BOUND = new RectF(3.0f, 3.0f, 21.0f, 21.0f);
        RECT_PADDED_BOUND = new RectF(0.0f, 0.0f, 24.0f, 24.0f);
    }

    public StaticIndeterminateCircularProgressDrawable(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicSize = Math.round(42.0f * f);
        this.mPaddedIntrinsicSize = Math.round(f * 48.0f);
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    private int getIntrinsicSize() {
        return this.mUseIntrinsicPadding ? this.mPaddedIntrinsicSize : this.mProgressIntrinsicSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getIntrinsicSize();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getIntrinsicSize();
    }

    @Override // me.zhanghai.android.materialprogressbar.BasePaintDrawable
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // me.zhanghai.android.materialprogressbar.BasePaintDrawable
    protected void onDraw(Canvas canvas, int i, int i2, Paint paint) {
        RectF rectF = this.mUseIntrinsicPadding ? RECT_PADDED_BOUND : RECT_PROGRESS_BOUND;
        this.mMatrix.setScale(i / rectF.width(), i2 / rectF.height());
        this.mMatrix.preTranslate(-rectF.left, -rectF.top);
        PATH_PROGRESS.transform(this.mMatrix, this.mPath);
        canvas.drawPath(this.mPath, paint);
    }
}
