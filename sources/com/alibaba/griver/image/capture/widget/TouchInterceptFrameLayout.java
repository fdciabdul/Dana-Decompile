package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes6.dex */
public class TouchInterceptFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TapListener f6574a;
    private GestureDetector b;

    /* loaded from: classes6.dex */
    public interface TapListener {
        void onTap(View view);
    }

    public TouchInterceptFrameLayout(Context context) {
        super(context);
        this.b = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.alibaba.griver.image.capture.widget.TouchInterceptFrameLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchInterceptFrameLayout.this.f6574a != null) {
                    TouchInterceptFrameLayout.this.f6574a.onTap(TouchInterceptFrameLayout.this);
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.alibaba.griver.image.capture.widget.TouchInterceptFrameLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchInterceptFrameLayout.this.f6574a != null) {
                    TouchInterceptFrameLayout.this.f6574a.onTap(TouchInterceptFrameLayout.this);
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.alibaba.griver.image.capture.widget.TouchInterceptFrameLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchInterceptFrameLayout.this.f6574a != null) {
                    TouchInterceptFrameLayout.this.f6574a.onTap(TouchInterceptFrameLayout.this);
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.b.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTapListener(TapListener tapListener) {
        this.f6574a = tapListener;
    }
}
