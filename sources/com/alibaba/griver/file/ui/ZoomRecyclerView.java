package com.alibaba.griver.file.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.fullstory.instrumentation.FSDispatchDraw;

/* loaded from: classes6.dex */
public class ZoomRecyclerView extends RecyclerView implements FSDispatchDraw {

    /* renamed from: a  reason: collision with root package name */
    private ScaleGestureDetector f6541a;
    private GestureDetectorCompat b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private float i;
    private float j;
    private boolean k;
    private boolean l;
    private ValueAnimator m;
    private float n;

    /* renamed from: o  reason: collision with root package name */
    private float f6542o;
    private float p;
    private float q;

    public ZoomRecyclerView(Context context) {
        super(context);
        this.h = -1;
        this.k = false;
        this.l = false;
        a();
    }

    public ZoomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = -1;
        this.k = false;
        this.l = false;
        a();
    }

    public ZoomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = -1;
        this.k = false;
        this.l = false;
        a();
    }

    private void a() {
        this.f6541a = new ScaleGestureDetector(getContext(), new ScaleListener());
        this.b = new GestureDetectorCompat(getContext(), new GestureListener());
        this.g = 1.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        this.c = View.MeasureSpec.getSize(i);
        this.d = View.MeasureSpec.getSize(i2);
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.l) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z = this.b.MyBillsEntityDataFactory(motionEvent) || this.f6541a.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int actionIndex = motionEvent.getActionIndex();
            float x = motionEvent.getX(actionIndex);
            float y = motionEvent.getY(actionIndex);
            this.i = x;
            this.j = y;
            this.h = motionEvent.getPointerId(0);
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    try {
                        int findPointerIndex = motionEvent.findPointerIndex(this.h);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        if (!this.k && this.g > 1.0f) {
                            a(this.e + (x2 - this.i), this.f + (y2 - this.j));
                            b();
                        }
                        invalidate();
                        this.i = x2;
                        this.j = y2;
                    } catch (Exception unused) {
                        float x3 = motionEvent.getX();
                        float y3 = motionEvent.getY();
                        if (!this.k && this.g > 1.0f) {
                            float f = this.i;
                            if (f != -1.0f) {
                                a(this.e + (x3 - f), this.f + (y3 - this.j));
                                b();
                            }
                        }
                        invalidate();
                        this.i = x3;
                        this.j = y3;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.h) {
                            int i = actionIndex2 == 0 ? 1 : 0;
                            this.i = motionEvent.getX(i);
                            this.j = motionEvent.getY(i);
                            this.h = motionEvent.getPointerId(i);
                        }
                    }
                }
            }
            this.h = -1;
            this.i = -1.0f;
            this.j = -1.0f;
        }
        return super.onTouchEvent(motionEvent) || z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.e, this.f);
        float f = this.g;
        canvas.scale(f, f);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        this.e = f;
        this.f = f2;
    }

    private void b() {
        float[] b = b(this.e, this.f);
        this.e = b[0];
        this.f = b[1];
    }

    private float[] b(float f, float f2) {
        if (this.g <= 1.0f) {
            return new float[]{f, f2};
        }
        if (f > 0.0f) {
            f = 0.0f;
        } else {
            float f3 = this.p;
            if (f < f3) {
                f = f3;
            }
        }
        if (f2 > 0.0f) {
            f2 = 0.0f;
        } else {
            float f4 = this.q;
            if (f2 < f4) {
                f2 = f4;
            }
        }
        return new float[]{f, f2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, float f2) {
        if (this.m == null) {
            c();
        }
        if (this.m.isRunning()) {
            return;
        }
        float f3 = this.c;
        this.p = f3 - (f3 * f2);
        float f4 = this.d;
        this.q = f4 - (f4 * f2);
        float f5 = this.e;
        float f6 = this.f;
        float f7 = f2 - f;
        float[] b = b(f5 - (this.n * f7), f6 - (f7 * this.f6542o));
        float f8 = b[0];
        float f9 = b[1];
        this.m.setValues(PropertyValuesHolder.ofFloat(H5MapRenderOptimizer.KEY_SCALE, f, f2), PropertyValuesHolder.ofFloat("tranX", f5, f8), PropertyValuesHolder.ofFloat("tranY", f6, f9));
        this.m.setDuration(300L);
        this.m.start();
    }

    private void c() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.m = valueAnimator;
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.file.ui.ZoomRecyclerView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ZoomRecyclerView.this.g = ((Float) valueAnimator2.getAnimatedValue(H5MapRenderOptimizer.KEY_SCALE)).floatValue();
                ZoomRecyclerView.this.a(((Float) valueAnimator2.getAnimatedValue("tranX")).floatValue(), ((Float) valueAnimator2.getAnimatedValue("tranY")).floatValue());
                ZoomRecyclerView.this.invalidate();
            }
        });
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.alibaba.griver.file.ui.ZoomRecyclerView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ZoomRecyclerView.this.k = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomRecyclerView.this.k = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ZoomRecyclerView.this.k = false;
            }
        });
    }

    public boolean isEnableScale() {
        return this.l;
    }

    public void setEnableScale(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        if (z) {
            return;
        }
        float f = this.g;
        if (f != 1.0f) {
            c(f, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f = ZoomRecyclerView.this.g;
            ZoomRecyclerView.this.g *= scaleGestureDetector.getScaleFactor();
            ZoomRecyclerView zoomRecyclerView = ZoomRecyclerView.this;
            zoomRecyclerView.g = Math.max(0.5f, Math.min(zoomRecyclerView.g, 5.0f));
            ZoomRecyclerView zoomRecyclerView2 = ZoomRecyclerView.this;
            zoomRecyclerView2.p = zoomRecyclerView2.c - (ZoomRecyclerView.this.c * ZoomRecyclerView.this.g);
            ZoomRecyclerView zoomRecyclerView3 = ZoomRecyclerView.this;
            zoomRecyclerView3.q = zoomRecyclerView3.d - (ZoomRecyclerView.this.d * ZoomRecyclerView.this.g);
            ZoomRecyclerView.this.n = scaleGestureDetector.getFocusX();
            ZoomRecyclerView.this.f6542o = scaleGestureDetector.getFocusY();
            float f2 = ZoomRecyclerView.this.n;
            float f3 = ZoomRecyclerView.this.g;
            float f4 = ZoomRecyclerView.this.f6542o;
            float f5 = ZoomRecyclerView.this.g;
            ZoomRecyclerView zoomRecyclerView4 = ZoomRecyclerView.this;
            zoomRecyclerView4.a(zoomRecyclerView4.e + (f2 * (f - f3)), ZoomRecyclerView.this.f + (f4 * (f - f5)));
            ZoomRecyclerView.this.k = true;
            ZoomRecyclerView.this.invalidate();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (ZoomRecyclerView.this.g <= 0.5f) {
                ZoomRecyclerView zoomRecyclerView = ZoomRecyclerView.this;
                zoomRecyclerView.n = (-zoomRecyclerView.e) / (ZoomRecyclerView.this.g - 1.0f);
                ZoomRecyclerView zoomRecyclerView2 = ZoomRecyclerView.this;
                zoomRecyclerView2.f6542o = (-zoomRecyclerView2.f) / (ZoomRecyclerView.this.g - 1.0f);
                ZoomRecyclerView zoomRecyclerView3 = ZoomRecyclerView.this;
                zoomRecyclerView3.n = Float.isNaN(zoomRecyclerView3.n) ? 0.0f : ZoomRecyclerView.this.n;
                ZoomRecyclerView zoomRecyclerView4 = ZoomRecyclerView.this;
                zoomRecyclerView4.f6542o = Float.isNaN(zoomRecyclerView4.f6542o) ? 0.0f : ZoomRecyclerView.this.f6542o;
                ZoomRecyclerView zoomRecyclerView5 = ZoomRecyclerView.this;
                zoomRecyclerView5.c(zoomRecyclerView5.g, 0.5f);
            }
            ZoomRecyclerView.this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return a(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return a(motionEvent);
        }

        private boolean a(MotionEvent motionEvent) {
            float f = ZoomRecyclerView.this.g;
            float f2 = 1.0f;
            if (ZoomRecyclerView.this.g == 1.0f) {
                ZoomRecyclerView.this.n = motionEvent.getX();
                ZoomRecyclerView.this.f6542o = motionEvent.getY();
                f2 = 5.0f;
            } else {
                ZoomRecyclerView zoomRecyclerView = ZoomRecyclerView.this;
                zoomRecyclerView.n = zoomRecyclerView.g == 1.0f ? motionEvent.getX() : (-ZoomRecyclerView.this.e) / (ZoomRecyclerView.this.g - 1.0f);
                ZoomRecyclerView zoomRecyclerView2 = ZoomRecyclerView.this;
                zoomRecyclerView2.f6542o = zoomRecyclerView2.g == 1.0f ? motionEvent.getY() : (-ZoomRecyclerView.this.f) / (ZoomRecyclerView.this.g - 1.0f);
            }
            ZoomRecyclerView.this.c(f, f2);
            return super.onDoubleTap(motionEvent);
        }
    }
}
