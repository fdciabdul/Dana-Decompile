package com.alibaba.griver.base.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class MovableFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6386a;
    private boolean b;
    private Helper c;
    private float d;

    public MovableFrameLayout(Context context) {
        super(context);
        a();
    }

    public MovableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MovableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setMovable(boolean z) {
        this.f6386a = z;
        if (z) {
            return;
        }
        setTranslationX(0.0f);
        setTranslationY(0.0f);
    }

    public void setFullScreen(boolean z) {
        this.b = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6386a) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b) {
            int action = motionEvent.getAction();
            if (action == 0) {
                requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3 || action == 4) {
                requestDisallowInterceptTouchEvent(false);
            }
        }
        if (this.f6386a && this.c.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    private void a() {
        this.c = new Helper();
        this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f6386a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Helper {

        /* renamed from: a  reason: collision with root package name */
        private float f6387a;
        private float b;
        private boolean c;

        private Helper() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        
            if (r0 != 4) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                com.alibaba.griver.base.ui.widget.MovableFrameLayout r0 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.this
                boolean r0 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.access$100(r0)
                r1 = 1
                if (r0 == 0) goto L76
                int r0 = r7.getAction()
                float r2 = r7.getRawX()
                float r7 = r7.getRawY()
                r3 = 0
                if (r0 == 0) goto L6c
                if (r0 == r1) goto L5a
                r4 = 2
                if (r0 == r4) goto L24
                r7 = 3
                if (r0 == r7) goto L5a
                r7 = 4
                if (r0 == r7) goto L5a
                goto L76
            L24:
                float r0 = r6.f6387a
                float r0 = r2 - r0
                int r0 = (int) r0
                float r3 = r6.b
                float r3 = r7 - r3
                int r3 = (int) r3
                boolean r4 = r6.c
                if (r4 == 0) goto L36
                r6.a(r2, r7, r0, r3)
                goto L76
            L36:
                int r4 = java.lang.Math.abs(r0)
                float r4 = (float) r4
                com.alibaba.griver.base.ui.widget.MovableFrameLayout r5 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.this
                float r5 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.access$200(r5)
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 >= 0) goto L54
                int r4 = java.lang.Math.abs(r3)
                float r4 = (float) r4
                com.alibaba.griver.base.ui.widget.MovableFrameLayout r5 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.this
                float r5 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.access$200(r5)
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 < 0) goto L76
            L54:
                r6.a(r2, r7, r0, r3)
                r6.c = r1
                goto L76
            L5a:
                boolean r7 = r6.c
                if (r7 == 0) goto L6b
                r7 = 0
                r6.f6387a = r7
                r6.b = r7
                r6.c = r3
                com.alibaba.griver.base.ui.widget.MovableFrameLayout r7 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.this
                r7.requestDisallowInterceptTouchEvent(r3)
                goto L76
            L6b:
                return r3
            L6c:
                com.alibaba.griver.base.ui.widget.MovableFrameLayout r0 = com.alibaba.griver.base.ui.widget.MovableFrameLayout.this
                r0.requestDisallowInterceptTouchEvent(r1)
                r6.f6387a = r2
                r6.b = r7
                return r3
            L76:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.ui.widget.MovableFrameLayout.Helper.onTouchEvent(android.view.MotionEvent):boolean");
        }

        private void a(float f, float f2, int i, int i2) {
            this.f6387a = f;
            this.b = f2;
            a(i, i2);
        }

        private void a(int i, int i2) {
            float translationX = MovableFrameLayout.this.getTranslationX() + i;
            float translationY = MovableFrameLayout.this.getTranslationY() + i2;
            if (MovableFrameLayout.this.getLeft() + translationX >= 0.0f && (!(MovableFrameLayout.this.getParent() instanceof View) || MovableFrameLayout.this.getRight() + translationX <= ((View) MovableFrameLayout.this.getParent()).getWidth())) {
                MovableFrameLayout.this.setTranslationX(translationX);
            }
            if (MovableFrameLayout.this.getTop() + translationY >= 0.0f) {
                if (!(MovableFrameLayout.this.getParent() instanceof View) || MovableFrameLayout.this.getBottom() + translationY <= ((View) MovableFrameLayout.this.getParent()).getHeight()) {
                    MovableFrameLayout.this.setTranslationY(translationY);
                }
            }
        }
    }
}
