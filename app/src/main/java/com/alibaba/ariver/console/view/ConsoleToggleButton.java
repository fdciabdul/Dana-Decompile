package com.alibaba.ariver.console.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;

/* loaded from: classes6.dex */
public class ConsoleToggleButton extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private float f6011a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;

    public ConsoleToggleButton(Context context) {
        super(context);
        a(context);
        this.g = new ViewConfiguration().getScaledTouchSlop();
    }

    private void a(Context context) {
        Resources resources = context.getResources();
        int color = resources.getColor(R.color.console_toggle_button_background);
        setText(resources.getString(R.string.console_toggle_button_text));
        setBackgroundColor(color);
        setTextSize(15.0f);
        setPadding(18, 12, 18, 12);
        setTextColor(-1);
    }

    public void setRange(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6011a = motionEvent.getX();
            this.b = motionEvent.getY();
        } else if (action == 1) {
            if (Math.abs(this.c) <= this.g && Math.abs(this.d) <= this.g) {
                this.b = 0.0f;
                this.f6011a = 0.0f;
                return super.onTouchEvent(motionEvent);
            }
            a();
            this.b = 0.0f;
            this.f6011a = 0.0f;
            return true;
        } else if (action == 2) {
            this.c = motionEvent.getX() - this.f6011a;
            this.d = motionEvent.getY() - this.b;
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.rightMargin = (int) (layoutParams.rightMargin - this.c);
        layoutParams.bottomMargin = (int) (layoutParams.bottomMargin - this.d);
        StringBuilder sb = new StringBuilder();
        sb.append("updateViewPosition ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(this.f);
        sb.append(" ");
        sb.append(this.c);
        sb.append(" ");
        sb.append(this.d);
        RVLogger.d("ConsoleToggleButton", sb.toString());
        int i = this.e;
        if (layoutParams.rightMargin <= 0) {
            layoutParams.rightMargin = 0;
        } else if (layoutParams.rightMargin + getWidth() > i) {
            layoutParams.rightMargin = i - getWidth();
        }
        int i2 = this.f;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        } else if (layoutParams.bottomMargin + getHeight() > i2) {
            layoutParams.bottomMargin = i2 - getHeight();
        }
        getParent().requestLayout();
    }
}
