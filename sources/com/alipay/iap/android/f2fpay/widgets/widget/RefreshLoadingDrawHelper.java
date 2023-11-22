package com.alipay.iap.android.f2fpay.widgets.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.R;
import com.alipay.iap.android.f2fpay.b.a.a;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class RefreshLoadingDrawHelper {

    /* renamed from: a  reason: collision with root package name */
    private Resources f6988a;
    private View b;
    private int d;
    private Drawable g;
    private Drawable h;
    private float i;
    private int j;
    private ValueAnimator k;
    private Paint c = new Paint();
    private int[] e = new int[2];
    private int[] f = new int[2];

    public RefreshLoadingDrawHelper(View view) {
        this.b = view;
        this.f6988a = view.getResources();
        this.c.setColor(-1);
        a();
    }

    private void a() {
        this.g = InstrumentInjector.Resources_getDrawable(this.f6988a, R.drawable.iap_f2fpay_refresh);
        this.h = InstrumentInjector.Resources_getDrawable(this.f6988a, R.drawable.iap_f2fpay_loading);
        this.d = a.a(this.f6988a, 40.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.k = ofFloat;
        ofFloat.setDuration(2000L);
        this.k.setRepeatMode(1);
        this.k.setInterpolator(new LinearInterpolator());
        this.k.addListener(new AnimatorListenerAdapter() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.RefreshLoadingDrawHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                RefreshLoadingDrawHelper.this.k.setRepeatCount(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RefreshLoadingDrawHelper.this.k.setRepeatCount(-1);
            }
        });
        this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alipay.iap.android.f2fpay.widgets.widget.RefreshLoadingDrawHelper.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshLoadingDrawHelper.this.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                StringBuilder sb = new StringBuilder();
                sb.append("onAnimationUpdate:");
                sb.append(RefreshLoadingDrawHelper.this.i);
                LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
                RefreshLoadingDrawHelper.this.b.invalidate();
            }
        });
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
        float f = this.j;
        canvas.drawRoundRect(rectF, f, f, this.c);
    }

    public void calculatePosition() {
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int paddingLeft = this.b.getPaddingLeft();
        int paddingRight = this.b.getPaddingRight();
        int paddingTop = this.b.getPaddingTop();
        int paddingBottom = this.b.getPaddingBottom();
        int[] iArr = this.f;
        int i = ((width - paddingLeft) - paddingRight) / 2;
        iArr[0] = i;
        int i2 = ((height - paddingTop) - paddingBottom) / 2;
        iArr[1] = i2;
        int[] iArr2 = this.e;
        int i3 = this.d;
        int i4 = i3 / 2;
        int i5 = i - i4;
        iArr2[0] = i5;
        int i6 = i2 - i4;
        iArr2[1] = i6;
        this.h.setBounds(i5, i6, i5 + i3, i3 + i6);
        Drawable drawable = this.g;
        int[] iArr3 = this.e;
        int i7 = iArr3[0];
        int i8 = iArr3[1];
        int i9 = this.d;
        drawable.setBounds(i7, i8, i7 + i9, i9 + i8);
    }

    public void cancelLoading() {
        this.k.cancel();
    }

    public void drawLoading(Canvas canvas) {
        canvas.save();
        a(canvas);
        canvas.translate(this.b.getPaddingLeft(), this.b.getPaddingTop());
        StringBuilder sb = new StringBuilder();
        sb.append("drawLoading:");
        sb.append(this.i);
        LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
        float f = this.i;
        int[] iArr = this.f;
        canvas.rotate(f, iArr[0], iArr[1]);
        this.h.draw(canvas);
        canvas.restore();
    }

    public void drawRefresh(Canvas canvas) {
        canvas.save();
        a(canvas);
        canvas.translate(this.b.getPaddingLeft(), this.b.getPaddingTop());
        this.g.draw(canvas);
        canvas.restore();
    }

    public void setLoadingBkgRadius(int i) {
        this.j = i;
    }

    public void startLoading() {
        this.k.start();
    }
}
