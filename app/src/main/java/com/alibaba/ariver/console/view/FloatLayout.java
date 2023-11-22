package com.alibaba.ariver.console.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class FloatLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f6012a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;

    public FloatLayout(Context context) {
        super(context);
        this.g = new ViewConfiguration().getScaledTouchSlop();
    }

    public void setRange(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6012a = motionEvent.getX();
            this.b = motionEvent.getY();
        } else if (action == 1) {
            if (Math.abs(this.c) <= this.g && Math.abs(this.d) <= this.g) {
                this.b = 0.0f;
                this.f6012a = 0.0f;
                return super.onTouchEvent(motionEvent);
            }
            a();
            this.b = 0.0f;
            this.f6012a = 0.0f;
            return true;
        } else if (action == 2) {
            this.c = motionEvent.getX() - this.f6012a;
            this.d = motionEvent.getY() - this.b;
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        setTranslationX(this.c);
        setTranslationY(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append("updateViewPosition ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(this.f);
        sb.append(" ");
        sb.append(this.c);
        sb.append(" ");
        sb.append(this.d);
        RVLogger.d("AriverRemoteDebug:FloatLayout", sb.toString());
        int i = this.e;
        if (getX() <= 0.0f) {
            setX(0.0f);
        } else if (getX() + getWidth() > i) {
            setX(i - getWidth());
        }
        int i2 = this.f;
        if (getY() <= 0.0f) {
            setY(0.0f);
        } else if (getY() + getHeight() > i2) {
            setY(i2 - getHeight());
        }
    }
}
