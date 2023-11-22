package com.iap.ac.android.acs.plugin.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.iap.ac.android.acs.transition.a.a;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACPluginLoadingView extends View implements ValueAnimator.AnimatorUpdateListener {
    public static final int ANIMATION_DURATION = 1500;
    public static final float ANIMATION_PROGRESS_FLOAT = 1.0f;
    public static final String DEFAULT_COLOR = "#aacdff";
    public static final int DEFAULT_VIEW_HEIGHT = 50;
    public ValueAnimator mAnimator;
    public Path mBlueLoadingDestPath1;
    public Path mBlueLoadingDestPath2;
    public Path mBlueLoadingPath1;
    public Path mBlueLoadingPath2;
    public PathMeasure mBlueLoadingPathMeasure1;
    public PathMeasure mBlueLoadingPathMeasure2;
    public Paint mBluePaint;
    public Path mDefaultPath1;
    public Path mDefaultPath2;
    public float mProgress;
    public float mStrokeWidth;
    public Path mTransparentLoadingDestPath1;
    public Path mTransparentLoadingDestPath2;
    public Path mTransparentLoadingPath1;
    public Path mTransparentLoadingPath2;
    public PathMeasure mTransparentLoadingPathMeasure1;
    public PathMeasure mTransparentLoadingPathMeasure2;
    public Paint mTransparentPaint;

    public ACPluginLoadingView(Context context) {
        super(context);
        initView();
    }

    private void drawBlueLoadingPath1(Canvas canvas) {
        this.mBlueLoadingDestPath1.reset();
        this.mBlueLoadingPathMeasure1.getSegment(0.0f, this.mBlueLoadingPathMeasure1.getLength() * this.mProgress * 2.0f, this.mBlueLoadingDestPath1, true);
        canvas.drawPath(this.mBlueLoadingDestPath1, this.mBluePaint);
    }

    private void drawBlueLoadingPath2(Canvas canvas) {
        this.mBlueLoadingDestPath2.reset();
        this.mBlueLoadingPathMeasure2.getSegment(0.0f, ((this.mProgress * 2.0f) - 1.0f) * this.mBlueLoadingPathMeasure2.getLength(), this.mBlueLoadingDestPath2, true);
        canvas.drawPath(this.mBlueLoadingDestPath2, this.mBluePaint);
    }

    private void drawTransparentLoadingPath1(Canvas canvas) {
        this.mTransparentLoadingDestPath1.reset();
        this.mTransparentLoadingPathMeasure1.getSegment(0.0f, this.mTransparentLoadingPathMeasure1.getLength() * this.mProgress * 2.0f, this.mTransparentLoadingDestPath1, true);
        canvas.drawPath(this.mTransparentLoadingDestPath1, this.mTransparentPaint);
    }

    private void drawTransparentLoadingPath2(Canvas canvas) {
        this.mTransparentLoadingDestPath2.reset();
        this.mTransparentLoadingPathMeasure2.getSegment(0.0f, ((this.mProgress * 2.0f) - 1.0f) * this.mTransparentLoadingPathMeasure2.getLength(), this.mTransparentLoadingDestPath2, true);
        canvas.drawPath(this.mTransparentLoadingDestPath2, this.mTransparentPaint);
    }

    private void initAnimator() {
        if (this.mAnimator == null) {
            ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initAnimator");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mAnimator = ofFloat;
            ofFloat.setDuration(1500L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.addUpdateListener(this);
        }
    }

    private void initBlueLoadingPath1(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initBlueLoadingPath1");
        Path path = new Path();
        this.mBlueLoadingPath1 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(f3, f4);
        Path path2 = this.mBlueLoadingPath1;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f5 = this.mStrokeWidth;
        path2.lineTo(a2 + f4, (f2 - f5) + ((float) a.a(2.0d, f5, 2.0d)));
        Path path3 = this.mBlueLoadingPath1;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f6 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(((float) ((tan * d) / 2.0d)) + f4, f6, f4, f6);
        float f7 = this.mStrokeWidth / 2.0f;
        float f8 = f2 - f7;
        this.mBlueLoadingPath1.arcTo(new RectF(f7, f7, f8, f8), 90.0f, 180.0f, false);
        Path path4 = this.mBlueLoadingPath1;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f9 = (float) ((tan2 * d2) / 2.0d);
        float f10 = this.mStrokeWidth;
        float f11 = f10 / 2.0f;
        float a3 = (float) a.a(2.0d, f10, 2.0d);
        float f12 = this.mStrokeWidth;
        path4.quadTo(f9 + f4, f11, a3 + f4, f12 - ((float) a.a(2.0d, f12, 2.0d)));
        this.mBlueLoadingPath1.lineTo(f3, f4);
        this.mBlueLoadingPathMeasure1 = new PathMeasure(this.mBlueLoadingPath1, false);
        this.mBlueLoadingDestPath1 = new Path();
    }

    private void initBlueLoadingPath2(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initBlueLoadingPath2");
        Path path = new Path();
        this.mBlueLoadingPath2 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(f3, f4);
        Path path2 = this.mBlueLoadingPath2;
        float f5 = f - f4;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f6 = this.mStrokeWidth;
        path2.lineTo(f5 - a2, (f2 - f6) + ((float) a.a(2.0d, f6, 2.0d)));
        Path path3 = this.mBlueLoadingPath2;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f7 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(f5 - ((float) ((tan * d) / 2.0d)), f7, f5, f7);
        float f8 = this.mStrokeWidth / 2.0f;
        this.mBlueLoadingPath2.arcTo(new RectF((f - f2) + f8, f8, f - f8, f2 - f8), 90.0f, -180.0f, false);
        Path path4 = this.mBlueLoadingPath2;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f9 = this.mStrokeWidth;
        float f10 = f9 / 2.0f;
        float a3 = (float) a.a(2.0d, f9, 2.0d);
        float f11 = this.mStrokeWidth;
        path4.quadTo(f5 - ((float) ((tan2 * d2) / 2.0d)), f10, f5 - a3, f11 - ((float) a.a(2.0d, f11, 2.0d)));
        this.mBlueLoadingPath2.lineTo(f3, f4);
        this.mBlueLoadingPathMeasure2 = new PathMeasure(this.mBlueLoadingPath2, false);
        this.mBlueLoadingDestPath2 = new Path();
    }

    private void initDefaultPath1(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initDefaultPath1");
        Path path = new Path();
        this.mDefaultPath1 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(f3 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), f4 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
        Path path2 = this.mDefaultPath1;
        float f5 = f - f4;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f6 = this.mStrokeWidth;
        path2.lineTo(f5 - a2, (f2 - f6) + ((float) a.a(2.0d, f6, 2.0d)));
        Path path3 = this.mDefaultPath1;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f7 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(f5 - ((float) ((tan * d) / 2.0d)), f7, f5, f7);
        float f8 = this.mStrokeWidth / 2.0f;
        this.mDefaultPath1.arcTo(new RectF((f - f2) + f8, f8, f - f8, f2 - f8), 90.0f, -180.0f, false);
        Path path4 = this.mDefaultPath1;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f9 = this.mStrokeWidth;
        float f10 = f9 / 2.0f;
        float a3 = (float) a.a(2.0d, f9, 2.0d);
        float f11 = this.mStrokeWidth;
        path4.quadTo(f5 - ((float) ((tan2 * d2) / 2.0d)), f10, f5 - a3, f11 - ((float) a.a(2.0d, f11, 2.0d)));
        this.mDefaultPath1.lineTo(f3 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), f4 + ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
    }

    private void initDefaultPath2(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initDefaultPath2");
        Path path = new Path();
        this.mDefaultPath2 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(((float) a.a(2.0d, this.mStrokeWidth, 2.0d)) + f3, f4 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
        Path path2 = this.mDefaultPath2;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f5 = this.mStrokeWidth;
        path2.lineTo(a2 + f4, (f2 - f5) + ((float) a.a(2.0d, f5, 2.0d)));
        Path path3 = this.mDefaultPath2;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f6 = (float) ((tan * d) / 2.0d);
        float f7 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(f6 + f4, f7, f4, f7);
        float f8 = this.mStrokeWidth / 2.0f;
        float f9 = f2 - f8;
        this.mDefaultPath2.arcTo(new RectF(f8, f8, f9, f9), 90.0f, 180.0f, false);
        Path path4 = this.mDefaultPath2;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f10 = this.mStrokeWidth;
        float f11 = f10 / 2.0f;
        float a3 = (float) a.a(2.0d, f10, 2.0d);
        float f12 = this.mStrokeWidth;
        path4.quadTo(((float) ((tan2 * d2) / 2.0d)) + f4, f11, a3 + f4, f12 - ((float) a.a(2.0d, f12, 2.0d)));
        this.mDefaultPath2.lineTo(f3 + ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), f4 + ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
    }

    private void initPaint() {
        if (this.mBluePaint == null) {
            ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initPaint, init blue paint");
            Paint paint = new Paint(1);
            this.mBluePaint = paint;
            paint.setColor(Color.parseColor(DEFAULT_COLOR));
            this.mBluePaint.setStyle(Paint.Style.STROKE);
            this.mBluePaint.setStrokeWidth(this.mStrokeWidth);
        }
        if (this.mTransparentPaint == null) {
            ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initPaint, init transparent paint");
            Paint paint2 = new Paint(1);
            this.mTransparentPaint = paint2;
            paint2.setColor(Color.parseColor(DEFAULT_COLOR));
            this.mTransparentPaint.setStyle(Paint.Style.STROKE);
            this.mTransparentPaint.setStrokeWidth(this.mStrokeWidth + 2.0f);
            this.mTransparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
    }

    private void initPath(float f, float f2) {
        if (this.mDefaultPath1 == null) {
            initDefaultPath1(f, f2);
        }
        if (this.mDefaultPath2 == null) {
            initDefaultPath2(f, f2);
        }
        if (this.mBlueLoadingPath1 == null) {
            initBlueLoadingPath1(f, f2);
        }
        if (this.mBlueLoadingPath2 == null) {
            initBlueLoadingPath2(f, f2);
        }
        if (this.mTransparentLoadingPath1 == null) {
            initTransparentLoadingPath1(f, f2);
        }
        if (this.mTransparentLoadingPath2 == null) {
            initTransparentLoadingPath2(f, f2);
        }
    }

    private void initTransparentLoadingPath1(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initTransparentLoadingPath1");
        Path path = new Path();
        this.mTransparentLoadingPath1 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(((float) a.a(2.0d, this.mStrokeWidth, 2.0d)) + f3, ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)) + f4);
        Path path2 = this.mTransparentLoadingPath1;
        float f5 = f - f4;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f6 = this.mStrokeWidth;
        path2.lineTo(f5 - a2, (f2 - f6) + ((float) a.a(2.0d, f6, 2.0d)));
        Path path3 = this.mTransparentLoadingPath1;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f7 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(f5 - ((float) ((tan * d) / 2.0d)), f7, f5, f7);
        float f8 = this.mStrokeWidth / 2.0f;
        this.mTransparentLoadingPath1.arcTo(new RectF((f - f2) + f8, f8, f - f8, f2 - f8), 90.0f, -180.0f, false);
        Path path4 = this.mTransparentLoadingPath1;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f9 = this.mStrokeWidth;
        float f10 = f9 / 2.0f;
        float a3 = (float) a.a(2.0d, f9, 2.0d);
        float f11 = this.mStrokeWidth;
        path4.quadTo(f5 - ((float) ((tan2 * d2) / 2.0d)), f10, f5 - a3, f11 - ((float) a.a(2.0d, f11, 2.0d)));
        this.mTransparentLoadingPath1.lineTo(f3 + ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), f4 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
        this.mTransparentLoadingPathMeasure1 = new PathMeasure(this.mTransparentLoadingPath1, false);
        this.mTransparentLoadingDestPath1 = new Path();
    }

    private void initTransparentLoadingPath2(float f, float f2) {
        ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#initTransparentLoadingPath2");
        Path path = new Path();
        this.mTransparentLoadingPath2 = path;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        path.moveTo(f3 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)) + f4);
        Path path2 = this.mTransparentLoadingPath2;
        float a2 = (float) a.a(2.0d, this.mStrokeWidth, 2.0d);
        float f5 = this.mStrokeWidth;
        path2.lineTo(a2 + f4, (f2 - f5) + ((float) a.a(2.0d, f5, 2.0d)));
        Path path3 = this.mTransparentLoadingPath2;
        double d = this.mStrokeWidth;
        double tan = Math.tan(0.19634954084936207d);
        Double.isNaN(d);
        float f6 = (float) ((tan * d) / 2.0d);
        float f7 = f2 - (this.mStrokeWidth / 2.0f);
        path3.quadTo(f6 + f4, f7, f4, f7);
        float f8 = this.mStrokeWidth / 2.0f;
        float f9 = f2 - f8;
        this.mTransparentLoadingPath2.arcTo(new RectF(f8, f8, f9, f9), 90.0f, 180.0f, false);
        Path path4 = this.mTransparentLoadingPath2;
        double d2 = this.mStrokeWidth;
        double tan2 = Math.tan(0.19634954084936207d);
        Double.isNaN(d2);
        float f10 = this.mStrokeWidth;
        float f11 = f10 / 2.0f;
        float a3 = (float) a.a(2.0d, f10, 2.0d);
        float f12 = this.mStrokeWidth;
        path4.quadTo(((float) ((tan2 * d2) / 2.0d)) + f4, f11, a3 + f4, f12 - ((float) a.a(2.0d, f12, 2.0d)));
        this.mTransparentLoadingPath2.lineTo(f3 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)), f4 - ((float) a.a(2.0d, this.mStrokeWidth, 2.0d)));
        this.mTransparentLoadingPathMeasure2 = new PathMeasure(this.mTransparentLoadingPath2, false);
        this.mTransparentLoadingDestPath2 = new Path();
    }

    private void initView() {
        setLayerType(1, null);
        initAnimator();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress <= 0.5f) {
            canvas.drawPath(this.mDefaultPath1, this.mBluePaint);
            drawBlueLoadingPath1(canvas);
            drawTransparentLoadingPath1(canvas);
            return;
        }
        canvas.drawPath(this.mDefaultPath2, this.mBluePaint);
        drawBlueLoadingPath2(canvas);
        drawTransparentLoadingPath2(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : 50;
        float f = size;
        float f2 = (140.0f * f) / 600.0f;
        this.mStrokeWidth = f2;
        double sqrt = Math.sqrt(2.0d);
        double d = this.mStrokeWidth;
        Double.isNaN(d);
        float f3 = ((f - f2) * 2.0f) + ((float) (sqrt * d));
        StringBuilder sb = new StringBuilder();
        sb.append("ACPluginLoadingView#onMeasure, width: ");
        sb.append(f3);
        sb.append(", height: ");
        sb.append(size);
        ACLog.d("IAPConnectPlugin", sb.toString());
        super.setMeasuredDimension((int) f3, size);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("ACPluginLoadingView#onSizeChanged, width: ");
        sb.append(i);
        sb.append(", height: ");
        sb.append(i2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        initPaint();
        initPath(i, i2);
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.mAnimator != null) {
            if (z) {
                ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#onWindowFocusChanged, focus, start animation");
                this.mAnimator.start();
            } else {
                ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#onWindowFocusChanged, lost focus, end animation");
                this.mAnimator.end();
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void stop() {
        if (this.mAnimator != null) {
            ACLog.d("IAPConnectPlugin", "ACPluginLoadingView#stop");
            this.mAnimator.end();
        }
    }

    public ACPluginLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ACPluginLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
