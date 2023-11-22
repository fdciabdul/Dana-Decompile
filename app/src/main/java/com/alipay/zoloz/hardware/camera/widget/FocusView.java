package com.alipay.zoloz.hardware.camera.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alipay.mobile.security.bio.utils.DisplayUtil;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public class FocusView extends View {
    private final String TAG;
    private ObjectAnimator animator;
    private int colorCurrent;
    private int colorFailed;
    private int colorNormal;
    private int colorSuccess;
    private RectF innerRectF;
    private RectF outerRectF;
    private Paint paint;
    private int previewHeight;
    private int previewWidth;
    private int radiusInner;
    private int radiusOuter;
    private int strokeWidth;

    public FocusView(Context context) {
        this(context, null);
    }

    public FocusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getSimpleName();
        this.radiusOuter = DisplayUtil.dip2px(context, 20.0f);
        this.radiusInner = DisplayUtil.dip2px(context, 10.0f);
        this.strokeWidth = DisplayUtil.dip2px(context, 2.0f);
        this.colorFailed = Color.parseColor("#FFC52E");
        this.colorSuccess = Color.parseColor("#FFC52E");
        int parseColor = Color.parseColor("#FFC52E");
        this.colorNormal = parseColor;
        this.colorCurrent = parseColor;
        int i2 = this.strokeWidth;
        float f = i2;
        float f2 = (this.radiusOuter * 2) - i2;
        this.outerRectF = new RectF(f, f, f2, f2);
        int i3 = this.radiusOuter;
        int i4 = this.radiusInner;
        float f3 = i3 - i4;
        float f4 = i3 + i4;
        this.innerRectF = new RectF(f3, f3, f4, f4);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(this.strokeWidth);
        initAnimation();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.radiusOuter * 2;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas, this.colorCurrent);
    }

    private void drawCircle(Canvas canvas, int i) {
        this.paint.setColor(i);
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 90;
            canvas.drawArc(this.outerRectF, i3 + 5, 80.0f, false, this.paint);
            canvas.drawArc(this.innerRectF, i3 + 50, 80.0f, false, this.paint);
        }
    }

    public void startFocus() {
        setVisibility(0);
        this.colorCurrent = this.colorNormal;
        invalidate();
        setAnimator(0.0f, 90.0f, 500L).start();
    }

    public void focusSuccess() {
        this.colorCurrent = this.colorSuccess;
        invalidate();
        setAnimator(90.0f, 0.0f, 200L).start();
    }

    public void focusFailed() {
        this.colorCurrent = this.colorFailed;
        invalidate();
        setAnimator(180.0f, 0.0f, 200L).start();
    }

    public void hideFocusView() {
        setVisibility(8);
    }

    public ObjectAnimator setAnimator(float f, float f2, long j) {
        this.animator.cancel();
        this.animator.setRepeatCount(-1);
        this.animator.setRepeatMode(2);
        this.animator.setFloatValues(f, f2);
        this.animator.setDuration(j);
        return this.animator;
    }

    private void initAnimation() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        this.animator = objectAnimator;
        objectAnimator.setTarget(this);
        this.animator.setPropertyName("rotation");
        this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void moveToPosition(float f, float f2) {
        float f3 = this.radiusOuter;
        setTranslationX(f - f3);
        setTranslationY(f2 - f3);
        setVisibility(0);
        this.colorCurrent = this.colorNormal;
        invalidate();
    }

    public void resetToDefaultPosition() {
        int i = this.previewWidth / 2;
        int i2 = this.radiusOuter;
        int i3 = this.previewHeight / 2;
        setTranslationX(i - i2);
        setTranslationY(i3 - i2);
    }

    public void initFocusArea(int i, int i2) {
        this.previewWidth = i;
        this.previewHeight = i2;
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("init focus view:");
        sb.append(this.previewWidth);
        sb.append("x");
        sb.append(this.previewHeight);
        InstrumentInjector.log_d(str, sb.toString());
        resetToDefaultPosition();
    }

    public static RectF rectToRectF(Rect rect) {
        return new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }
}
